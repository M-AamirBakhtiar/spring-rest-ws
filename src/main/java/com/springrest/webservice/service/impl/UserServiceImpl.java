package com.springrest.webservice.service.impl;

import com.springrest.webservice.entity.UserEntity;
import com.springrest.webservice.repository.UserRepository;
import com.springrest.webservice.service.UserService;
import com.springrest.webservice.shared.dto.UserDTO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDTO createUser(UserDTO user) {

        UserEntity storedUserDetails = userRepository.findUserEntityByEmail(user.getEmail());

        if( storedUserDetails != null) {
            throw new RuntimeException("User by this email already exists");
        }

        UserEntity userEntity = new UserEntity();

        BeanUtils.copyProperties(user, userEntity);

        userEntity.setEncryptedPassword("test");
        userEntity.setUserId("testUserId");

        UserEntity savedUserDetails = userRepository.save(userEntity);

        UserDTO newlyCreatedUser = new UserDTO();

        BeanUtils.copyProperties(savedUserDetails, newlyCreatedUser);

        return newlyCreatedUser;

    }
}
