package com.ab.helmesassignment.service.impl;

import com.ab.helmesassignment.dto.UserDTO;
import com.ab.helmesassignment.entity.User;
import com.ab.helmesassignment.repository.UserRepository;
import com.ab.helmesassignment.service.UserService;
import com.github.dozermapper.core.DozerBeanMapperBuilder;
import com.github.dozermapper.core.Mapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    private final Mapper mapper = DozerBeanMapperBuilder.buildDefault();

    @Override
    public UserDTO saveUser(UserDTO userDto) {
        boolean createMode = userDto.getId() == 0;

        User user = mapper.map(userDto, User.class);

        User savedUser = userRepository.save(user);
        if (createMode) {
            userDto.setId(savedUser.getId());
        }

        return userDto;
    }
}
