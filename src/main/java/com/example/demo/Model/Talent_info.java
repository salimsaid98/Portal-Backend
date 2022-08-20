// package com.example.demo.Model;

// import java.io.Serializable;
// import javax.persistence.Entity;
// import javax.persistence.FetchType;
// import javax.persistence.GeneratedValue;
// import javax.persistence.GenerationType;
// import javax.persistence.Id;
// import javax.persistence.JoinColumn;
// import javax.persistence.ManyToOne;
// import javax.persistence.Table;

// import org.hibernate.annotations.OnDelete;
// import org.hibernate.annotations.OnDeleteAction;

// import com.fasterxml.jackson.annotation.JsonIgnore;

// import lombok.Data;

// @Data
// @Entity
// @Table(name = ("Talent_info"))
// public class Talent_info implements Serializable{
//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     private Long id;
//     @ManyToOne(fetch = FetchType.LAZY, optional = false)
//     @JoinColumn(name = "ex_id",referencedColumnName = "ex_id", nullable = false)
//     @OnDelete(action = OnDeleteAction.CASCADE)
//     @JsonIgnore
//     Expert expert;

//     @ManyToOne(fetch = FetchType.LAZY, optional = false)
//     @JoinColumn(name = "talent_id", referencedColumnName = "talent_id" ,nullable = false )
//     @OnDelete(action = OnDeleteAction.CASCADE)
//     @JsonIgnore
//     Talent talent;


// }
