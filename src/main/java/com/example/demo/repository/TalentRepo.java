package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Model.Talent;

public interface TalentRepo extends JpaRepository<Talent,Long>{
    
}
