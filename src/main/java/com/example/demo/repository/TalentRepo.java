package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Model.Talent;

public interface TalentRepo extends JpaRepository<Talent,Long>{
    // List<Talent>findbyworkexp(String workexp);
}
