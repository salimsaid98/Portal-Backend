package com.example.demo.Model;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;
@Data
@Entity
@Table(name = "Education")
public class Education {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long ed_id;
    private String un_name;
    private String place;
    private LocalDate year;
    // @OneToOne(fetch = FetchType.LAZY, cascade =  CascadeType.ALL, optional = false)
    // @JoinColumn(name = "ex_id", nullable = false)
    @ManyToOne
     private Expert expert;
    
     

}
