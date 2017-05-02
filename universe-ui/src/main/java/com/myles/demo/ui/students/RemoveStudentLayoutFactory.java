package com.myles.demo.ui.students;

import com.vaadin.spring.annotation.SpringView;
import com.vaadin.navigator.View;
import com.vaadin.ui.Grid;
import com.vaadin.ui.Button;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import com.myles.demo.model.entity.Student;

@SpringView(name=RemoveStudentLayoutFactory.NAME, ui=UniverseMainUI.class)
public class RemoveStudentLayoutFactory implements View, Button.ClickListener {

    public static final String NAME = "removestudent";

    private Grid removeStudentTable;
    private Button removeStudentButton;
    private List<Student> students;

    private void addLayout(){
    }

    private void loadStudents(){
    }

    @Override
    public void enter(ViewChangeEvent event){
        if ( removeStudentTable != null ) return ;

        loadStudents();
        addLayout();
    }

    @Override
    public void buttonClick(ClickEvent event){
    }

}

