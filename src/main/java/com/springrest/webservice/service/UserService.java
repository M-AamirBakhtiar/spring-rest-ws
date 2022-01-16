package com.springrest.webservice.service;

import com.springrest.webservice.shared.dto.UserDTO;

public interface UserService {

    UserDTO createUser(UserDTO userDTO);
}
