package com.example.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.demo.model.Course;
import com.example.demo.repository.CourseRepository;

@SpringBootApplication
public class UdemySignupApplication {

	public static void main(String[] args) {
		SpringApplication.run(UdemySignupApplication.class, args);
	}
	
	@Bean
    CommandLineRunner runner(CourseRepository courseRepository) {
        return args -> {
        	
        	if (courseRepository.findByTitle("Spring Boot Basics") == null) {
                courseRepository.save(new Course(null, "Spring Boot Basics", "Learn Spring Boot"));
            }

            if (courseRepository.findByTitle("Advanced Java") == null) {
                courseRepository.save(new Course(null, "Advanced Java", "Deep dive into Java"));
            }
        };
    }

}
