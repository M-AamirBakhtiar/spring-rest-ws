package com.springrest.webservice.service;

import com.springrest.webservice.shared.dto.UserDTO;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {

    UserDTO createUser(UserDTO userDTO);
}
