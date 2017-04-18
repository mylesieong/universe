package com.myles.demo.service.showallstudents;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import com.myles.demo.model.entity.Student;
import com.myles.demo.repository.student.StudentRepository;

@Service
public class ShowAllStudentsServiceImpl implements ShowAllStudentsService{

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public List<Student> getAllStudents(){
        return studentRepository.getAllStudents();
    }

}
