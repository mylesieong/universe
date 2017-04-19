package com.myles.demo.ui.students;

import com.vaadin.spring.annotation.SpringView;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.TabSheet;
import com.vaadin.ui.Component;

import org.springframework.beans.factory.annotation.Autowired;

import com.myles.demo.ui.commons.UniverseMainUI;
import com.myles.demo.utils.StudentsStringUtils;

@SpringView(name=StudentLayoutFactory.NAME, ui=UniverseMainUI.class)
public class StudentLayoutFactory extends VerticalLayout implements View, StudentSavedListener{

    public static final String NAME = "addstudent";

    @Autowired
    private AddStudentMainLayoutFactory mainLayoutFactory;

    @Autowired
    private ShowAllStudentsLayoutFactory showStudentsLayoutFactory;

    private TabSheet tabSheet;

    private void addLayout(){
        setMargin(true);

        this.tabSheet = new TabSheet();
        this.tabSheet.setWidth("100%");

        Component addStudentMainTab = mainLayoutFactory.createComponent(this);
        Component showStudentsTab = showStudentsLayoutFactory.createComponent();

        this.tabSheet.addTab(addStudentMainTab, StudentsStringUtils.MAIN_MENU.getString());
        this.tabSheet.addTab(showStudentsTab, StudentsStringUtils.SHOW_ALL_STUDENTS.getString());
        this.addComponent(this.tabSheet);

    }

    @Override
    public void studentSaved(){
        this.showStudentsLayoutFactory.refreshTable();
    }

    @Override
    public void enter(ViewChangeEvent event){
         removeAllComponents();
         addLayout();
    }

}
