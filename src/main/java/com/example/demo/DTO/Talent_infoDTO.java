package com.example.demo.DTO;
import com.example.demo.Model.Expert;
import com.example.demo.Model.Talent;

import lombok.Data;
@Data
public class Talent_infoDTO {
    private Long id;
   private Talent talent;
   private Expert expert;
}