package com.example.demo.DTO;

import java.time.LocalDate;

import lombok.Data;
@Data
public class EducationDTO {
    private long ed_id;
    private String un_name;
    private String place;
    private LocalDate year;
    private Long ex_id;
}
