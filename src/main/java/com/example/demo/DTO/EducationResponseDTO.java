package com.example.demo.DTO;

import java.time.LocalDate;

import lombok.Data;
@Data
public class EducationResponseDTO {
    private long ed_id;
    private String un_name;
    private String place;
    private LocalDate year;
    private String f_name;
    private String s_name;
    private String l_name;
    private String gander;
    private String email;
    private String address;
    private String status;
    private String phone;
    private LocalDate dob;
}
