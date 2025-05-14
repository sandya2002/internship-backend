package com.example.demo.controller;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.example.demo.model.Course;
import com.example.demo.model.User;
import com.example.demo.repository.CourseRepository;
import com.example.demo.repository.UserRepository;

@RestController
@CrossOrigin(origins = "http://localhost:4200") 
@RequestMapping("/courses")
@SessionAttributes("loggedInUser")
public class CourseController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CourseRepository courseRepository;
    @PostMapping("/purchase/{courseId}")
    public String purchaseCourse(@PathVariable Long courseId, @ModelAttribute("loggedInUser") User sessionUser) {
        Optional<User> userOpt = userRepository.findById(sessionUser.getId());
        Optional<Course> courseOpt = courseRepository.findById(courseId);

        if (userOpt.isPresent() && courseOpt.isPresent()) {
            User user = userOpt.get();
            Course course = courseOpt.get();

            user.getCourses().add(course);
            userRepository.save(user);

            return "Course purchased successfully!";
        } else {
            return "User or Course not found.";
        }
    }
    @GetMapping("/my-courses")
    public List<Course> getMyCourses(@ModelAttribute("loggedInUser") User sessionUser) {
        Optional<User> userOpt = userRepository.findById(sessionUser.getId());

        if (userOpt.isPresent()) {
            return userOpt.get().getCourses();
        } else {
            return Collections.emptyList();
        }
    }
}
