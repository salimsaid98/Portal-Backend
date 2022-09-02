package com.example.demo.Model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
@Data
@Entity
@Table(name = ("Talent_info"))
public class Talent_info {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    // @Column(name = "ex_id")
    // private Long ex_id;
    // @Column(name = "talent_id")
    // private Long talent_id;

    @ManyToOne()
    // @JoinColumn(name = "ex_id",referencedColumnName = "ex_id", nullable = false)
    // @OnDelete(action = OnDeleteAction.CASCADE)
    // // @JsonIgnore
    private Expert expert;

    @ManyToOne()
    // @JoinColumn(name = "talent_id", referencedColumnName = "talent_id" ,nullable = false )
    // @OnDelete(action = OnDeleteAction.CASCADE)
    // @JsonIgnore
    private Talent talent;


}
