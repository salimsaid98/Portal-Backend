package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Model.Education;

public interface EducationRepo extends JpaRepository<Education,Long> {
    
}
