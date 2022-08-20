package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Model.Expert;

public interface ExpertRepo extends JpaRepository<Expert,Long> {
    // List<Expert>findExpertsContainedByName(String name);
}
