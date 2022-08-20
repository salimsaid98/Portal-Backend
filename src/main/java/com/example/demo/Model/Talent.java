package com.example.demo.Model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.Data;
@Data
@Entity
@Table(name = "Talent_tb")
public class Talent implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long talent_id;
    private String specialization;
    private String workexp;
    private String certification;
    private String biography;
    // @OneToMany(cascade = CascadeType.ALL)
    // private Set<Talent_info> talent;
    
    @ManyToMany(mappedBy = "talents",fetch = FetchType.LAZY)
    @JsonBackReference
    private Set<Expert> experts;

}
