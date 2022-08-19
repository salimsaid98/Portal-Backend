package com.example.demo.Model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
@Data
@Entity
@Table(name = "Expert_tb")

public class Expert {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
