package com.ankur.users.controllers;

import com.ankur.users.model.CreateUserRequestDTO;
import com.ankur.users.model.CreateUserResponseDTO;
import com.ankur.users.model.UserDTO;
import com.ankur.users.service.UserService;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/users")
public class UsersController {

    @Autowired
    Environment environment;

    @Autowired
    UserService userService;

    @GetMapping("/status/check")
    public String status() {
        return "Working on port:: " + environment.getProperty("local.server.port");
    }

    @PostMapping
    public ResponseEntity<CreateUserResponseDTO> createUser(@Valid @RequestBody CreateUserRequestDTO userRequestDTO) {

        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);

        UserDTO userDTO = modelMapper.map(userRequestDTO, UserDTO.class);
        UserDTO createdUser = userService.createUser(userDTO);
        CreateUserResponseDTO responseDTO = modelMapper.map(createdUser, CreateUserResponseDTO.class);
        return ResponseEntity.status(HttpStatus.CREATED).body(responseDTO);
    }
}
