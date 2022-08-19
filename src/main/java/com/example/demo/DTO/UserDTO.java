package com.example.demo.DTO;

import lombok.Data;

@Data
public class UserDTO {
    private int user_id;
    private String username;
    private String email;
    private String phone;
    private String password;
}
