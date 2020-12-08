package com.ankur.users.service;

import com.ankur.users.model.UserDTO;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {

    UserDTO createUser(UserDTO userDetails);
    UserDTO getUserDetailsByEmail(String email);
}
