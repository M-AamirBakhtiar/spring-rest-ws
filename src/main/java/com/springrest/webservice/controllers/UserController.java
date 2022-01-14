package com.springrest.webservice.controllers;

import com.springrest.webservice.model.request.UserDetailsRequestModel;
import com.springrest.webservice.model.response.UserRestResponse;
import com.springrest.webservice.shared.dto.UserDTO;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    @GetMapping
    public String getUsers() {
        return "Users";
    }

    @PostMapping
    public UserRestResponse createUser(@RequestBody UserDetailsRequestModel userDetails) {

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
