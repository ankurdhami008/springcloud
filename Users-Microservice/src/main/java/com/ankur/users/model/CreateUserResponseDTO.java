package com.ankur.users.model;

import lombok.Data;

@Data
public class CreateUserResponseDTO {

    private String firstName;
    private String lastName;
    private String email;
    private String userId;
}
