package com.example.demo.DTO;

import com.example.demo.Model.Expert;

import lombok.Data;

@Data
public class TalentDTO {
    private long talent_id;
    private String specialization;
    private String workexp;
    private String certification;
    private String biography;
    private Expert expert;
}
