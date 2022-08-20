package com.example.demo.Model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Data;
@Data
@Entity
@Table(name = "Expert_tb")

public class Expert implements Serializable {
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
//    @OneToMany(cascade = CascadeType.ALL)
//    private Set<Talent_info> expert;
// //    @OneToOne
// //    @MapsId
// //    @JoinColumn(name = "ed_id")
// //    private Education education;

@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
@JoinTable(name = "Expert_Talent_tb",
        joinColumns = {
                @JoinColumn(name = "expert_id", referencedColumnName = "ex_id")
        },
        inverseJoinColumns = {
                @JoinColumn(name = "talent_id", referencedColumnName = "talent_id")
        }
)
@JsonManagedReference
private Set<Talent> talents;


}
