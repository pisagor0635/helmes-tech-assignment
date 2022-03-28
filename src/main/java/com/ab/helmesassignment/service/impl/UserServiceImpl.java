package com.ab.helmesassignment.service.impl;

import com.ab.helmesassignment.dto.UserDTO;
import com.ab.helmesassignment.entity.User;
import com.ab.helmesassignment.repository.UserRepository;
import com.ab.helmesassignment.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public UserDTO saveUser(UserDTO userDto) {
        boolean createMode = userDto.getId() == 0;
        User user = new User();
        user.setId(userDto.getId());
        user.setFullName(userDto.getFullName());
        user.setSector(userDto.getSector());
        user.setTermAgreed(userDto.isTermAgreed());

        User savedUser = userRepository.save(user);
        if (createMode)
            userDto.setId(savedUser.getId());

        return userDto;
    }
}
