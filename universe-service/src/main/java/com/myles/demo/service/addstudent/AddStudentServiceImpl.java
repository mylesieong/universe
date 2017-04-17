package com.myles.demo.service.addstudent;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import com.myles.demo.model.entity.Student;
import com.myles.demo.repository.student.StudentRepository;

@Service
public class AddStudentServiceImpl implements AddStudentService {

    @Autowired
    private StudentRepository studentRepository;
    @Override
    public void saveStudent(Student studentDAO){

        Student student = new Student();
        student.setFirstName(studentDAO.getFirstName());
        student.setLastName(studentDAO.getLastName());
        student.setAge(studentDAO.getAge());
        student.setGender(studentDAO.getGender());

        studentRepository.save(student);

    }
}
