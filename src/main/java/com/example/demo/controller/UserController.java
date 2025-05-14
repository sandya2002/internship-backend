
package com.example.demo.controller;

import com.example.demo.model.User;

import com.example.demo.service.UserService;

import java.util.Optional;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:4200") 
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/signup")
    public ResponseEntity<String> signup(@RequestBody User user) {
        userService.signup(user);
        return ResponseEntity.ok("User signed up successfully!");
    }
//    @GetMapping("/api/health")
//    public String hello(){
//    	return "server is working";
//    }
//    @PostMapping("/login")
//    public ResponseEntity<String> login(@RequestBody User user, HttpSession session) {
//        User foundUser = userService.login(user.getEmail());
//        if (foundUser != null) {
//            session.setAttribute("loggedInUser", foundUser);  // store in session → creates JSESSIONID
//            return ResponseEntity.ok("User logged in successfully!");
//        } else {
//            return ResponseEntity.status(401).body("User does not exist!");
//        }
//    }
    
    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody String email, HttpSession session) {
        // Remove surrounding quotes from raw JSON string
        email = email.replace("\"", "").trim();

        System.out.println("Received email: " + email);  // Debugging log

        User foundUser = userService.login(email);
        if (foundUser != null) {
            session.setAttribute("loggedInUser", foundUser);  // Creates session with JSESSIONID
            return ResponseEntity.ok("User logged in successfully!");
        } else {
            return ResponseEntity.status(401).body("User does not exist!");
        }
    }

    
    @GetMapping("/{id:[0-9]+}")
    public ResponseEntity<?> getUserById(@PathVariable Long id) {
        Optional<User> user = userService.getUserById(id);
        if (user.isPresent()) {
            return ResponseEntity.ok(user.get());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found");
        }
    }
}
