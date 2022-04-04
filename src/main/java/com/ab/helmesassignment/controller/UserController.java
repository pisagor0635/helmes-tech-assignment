package com.ab.helmesassignment.controller;

import com.ab.helmesassignment.dto.UserDTO;
import com.ab.helmesassignment.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping(value = "/saveUser", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public UserDTO saveEmployee(@RequestBody UserDTO user) {
        return userService.saveUser(user);
    }

}
