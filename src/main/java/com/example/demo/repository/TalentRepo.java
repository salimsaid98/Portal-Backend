package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.Model.Talent;

public interface TalentRepo extends JpaRepository<Talent,Long>{
    @Query(value = "select * from talent_tb where specialization=?1 or certification=?1 or workexp=?1", nativeQuery = true)
    List<Talent>getBySpecialization(String name );
}
