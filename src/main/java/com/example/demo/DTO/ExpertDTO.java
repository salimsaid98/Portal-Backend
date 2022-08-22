package com.example.demo.DTO;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import com.example.demo.Model.Talent;
import com.example.demo.Model.Talent_info;

import lombok.Data;

@Data
public class ExpertDTO {
    private long ex_id;
   private String f_name;
   private String s_name;
   private String l_name;
   private String email;
   private String address;
   private String status;
   private int phone;
   private LocalDate dob;
   private String password;  
}
