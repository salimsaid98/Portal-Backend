package com.example.demo.Model;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Data
@Entity
@Table(name = "Expert_tb")

public class Expert{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long ex_id;
   private String f_name;
   private String s_name;
   private String l_name;
   private String gander;
   private String email;
   private String address;
   private String status;
   private String phone;
   private LocalDate dob;
   private String password;

//    @OneToMany(cascade = CascadeType.ALL)
//    private Set<Talent_info> expert;

//    @OneToMany(fetch = FetchType.LAZY,
//    cascade =  CascadeType.ALL,
//    mappedBy = "expert")
//    private Education education;

   public Expert(Long ex_id){
    this.ex_id = ex_id;
   }

// @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
// @JoinTable(name = "Expert_Talent_tb",
//         joinColumns = {
//                 @JoinColumn(name = "expert_id", referencedColumnName = "ex_id")
//         },
//         inverseJoinColumns = {
//                 @JoinColumn(name = "talent_id", referencedColumnName = "talent_id")
//         }
// )
// private Set<Talent> talents;

}
