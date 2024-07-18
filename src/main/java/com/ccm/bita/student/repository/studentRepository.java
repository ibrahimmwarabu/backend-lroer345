package com.ccm.bita.student.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ccm.bita.student.model.Students;

public interface studentRepository extends JpaRepository<Students,Long>{
    
}
