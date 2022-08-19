package com.example.demo.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
@Data
@Entity
@Table(name = "Talent_tb")
public class Talent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long talent_id;
    private String specialization;
    private String workexp;
    private String certification;
    private String biography;

}
