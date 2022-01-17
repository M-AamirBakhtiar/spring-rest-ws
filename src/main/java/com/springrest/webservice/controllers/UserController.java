package com.springrest.webservice.controllers;

import com.springrest.webservice.model.request.UserSignupRequestModel;
import com.springrest.webservice.model.response.UserRestResponse;
import com.springrest.webservice.service.UserService;
import com.springrest.webservice.shared.dto.UserDTO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping
    public String getUsers() {
        return "Users";
    }

    @PostMapping
    public UserRestResponse createUser(@RequestBody UserSignupRequestModel userDetails) {

        UserRestResponse userRestResponse = new UserRestResponse();

        UserDTO userDTO = new UserDTO();

        BeanUtils.copyProperties(userDetails, userDTO);

        UserDTO createdUser = userService.createUser(userDTO);

        BeanUtils.copyProperties(createdUser, userRestResponse);

        return userRestResponse;
    }

    @PutMapping
    public String updateUser() { return "User Updated"; }

    @DeleteMapping
    public String deleteUser() {
        return "User Deleted";
    }
}
