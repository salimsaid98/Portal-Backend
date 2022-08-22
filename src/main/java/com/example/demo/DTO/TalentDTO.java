package com.example.demo.DTO;

import java.util.List;
import java.util.Set;

import com.example.demo.Model.Expert;
import com.example.demo.Model.Talent_info;

import lombok.Data;

@Data
public class TalentDTO {
    private long talent_id;
    private String specialization;
    private String workexp;
    private String certification;
    private String biography;
      
}
