package com.myles.demo.repository.student;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.myles.demo.model.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {
}
