package com.springrest.webservice.controllers;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    @GetMapping
    public String getUsers() {
        return "Users";
    }

    @PostMapping
    public String createUser() {
        return "User Created";
    }

    @PutMapping
    public String updateUser() { return "User Updated"; }

    @DeleteMapping
    public String deleteUser() {
        return "User Deleted";
    }
}
