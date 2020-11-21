package com.ankur.users.controllers;

import com.ankur.users.model.CreateUserRequestDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/users")
public class UsersController {

    @Autowired
    Environment environment;

    @GetMapping("/status/check")
    public String status() {
        return "Working on port:: " + environment.getProperty("local.server.port");
    }

    @PostMapping
    public String createUser(@Valid @RequestBody CreateUserRequestDTO userRequestDTO) {
        return "Create user method is called";
    }
}
