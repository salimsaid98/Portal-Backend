package com.example.demo.Model;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.criteria.Order;

import lombok.Data;
@Data
@Entity
@Table(name = "Talent_tb")
public class Talent  {
   
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long talent_id;
    private String specialization;
    private String workexp;
    private String certification;
    private String biography;
    // @OneToMany(cascade = CascadeType.ALL)
    // @JsonIgnore
    // private Set<Talent_info> talent;
    
    // @ManyToMany(mappedBy = "talents",fetch = FetchType.LAZY)
    // // @JsonIgnore
    // private Expert experts;
    

}
