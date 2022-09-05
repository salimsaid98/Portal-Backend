package com.example.demo.DTO;

import java.time.LocalDate;
import java.util.Set;

import com.example.demo.Model.Expert;
import com.example.demo.Model.Talent;

import lombok.Data;
@Data
public class Talent_infoRespondDTO {
    private Long id;
    private String f_name;
    private String s_name;
    private String l_name;
    private String gander;
    private String email;
    private String address;
    private String status;
    private String phone;
    private LocalDate dob;
    private String specialization;
    private String workexp;
    private String certification;
    private String biography;
    private String un_name;
    private String place;
    private LocalDate year;
}
