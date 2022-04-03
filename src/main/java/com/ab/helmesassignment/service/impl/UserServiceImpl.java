package com.ab.helmesassignment.service.impl;

import com.ab.helmesassignment.dto.UserDTO;
import com.ab.helmesassignment.entity.Sector;
import com.ab.helmesassignment.entity.User;
import com.ab.helmesassignment.exception.ValidationFailException;
import com.ab.helmesassignment.repository.SectorRepository;
import com.ab.helmesassignment.repository.UserRepository;
import com.ab.helmesassignment.service.UserService;
import com.github.dozermapper.core.DozerBeanMapperBuilder;
import com.github.dozermapper.core.Mapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.HashSet;
import java.util.Set;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    private final SectorRepository sectorRepository;

    private final Mapper mapper = DozerBeanMapperBuilder.buildDefault();

    @Override
    public UserDTO saveUser(UserDTO userDto) {

        validateUser(userDto);

        boolean createMode = userDto.getId() == 0;

        User user = mapper.map(userDto, User.class);

        user.setSectors(prepareUserSectors(userDto.getSector()));

        User savedUser = userRepository.save(user);
        if (createMode) {
            userDto.setId(savedUser.getId());
        }
        return userDto;
    }

    private Set<Sector> prepareUserSectors(long[] sectorIds) {
        Set<Sector> sectorSet = new HashSet<>();
        for (long sectorId : sectorIds) {
            sectorSet.add(sectorRepository.findById(sectorId).get());
        }
        return sectorSet;
    }

    private void validateUser(UserDTO userDto) {
        String logMessage = "{} cannot be empty!";
        StringBuilder validationMessage = new StringBuilder();
        if (ObjectUtils.isEmpty(userDto.getFullName())) {
            validationMessage.append("Full Name");
        }
        if (ObjectUtils.isEmpty(userDto.getSector())) {
            if (validationMessage.length() > 0) {
                validationMessage.append(", ").append("Sector Data");
            } else {
                validationMessage.append("Sector Data");
            }
        }
        if (!userDto.isTermAgreed()) {
            if (validationMessage.length() > 0) {
                validationMessage.append(", ").append("Term Agreed");
            } else {
                validationMessage.append("Term Agreed");
            }
        }
        if (validationMessage.length() > 0) {
            log.error(logMessage, validationMessage.toString());
            throw new ValidationFailException(validationMessage.toString() + " cannot be empty");
        }
    }


}
