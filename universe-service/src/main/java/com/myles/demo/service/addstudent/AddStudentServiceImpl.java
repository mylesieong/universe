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

        /* Reason to use new object is that if not, then everytime
         * method is invoked, the input studentDAO reference is 
         * actually pointing to the same object. So the save action
         * will be performed in an update manner instead of insert
         * (which is actually what we want)
         */
        Student student = new Student(); 
        student.setFirstName(studentDAO.getFirstName());
        student.setLastName(studentDAO.getLastName());
        student.setAge(studentDAO.getAge());
        student.setGender(studentDAO.getGender());

        studentRepository.save(student);

    }
}
