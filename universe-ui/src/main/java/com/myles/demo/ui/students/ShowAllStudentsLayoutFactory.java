package com.myles.demo.ui.students;

import java.util.List;

import com.vaadin.ui.Component;
import com.vaadin.ui.Grid;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.data.util.BeanItemContainer;

import org.springframework.beans.factory.annotation.Autowired;

import com.myles.demo.model.entity.Student;
import com.myles.demo.ui.commons.UIComponentBuilder;
import com.myles.demo.service.showallstudents.ShowAllStudentsService;

@org.springframework.stereotype.Component
public class ShowAllStudentsLayoutFactory implements UIComponentBuilder {

    private List<Student> students;
    private BeanItemContainer<Student> container;

    private class ShowAllStudentsLayout extends VerticalLayout {

        private Grid studentsTable;

        public ShowAllStudentsLayout init(){

            this.setMargin(true);

            container = new BeanItemContainer<Student>(Student.class, students);

            studentsTable = new Grid(container);
            studentsTable.setColumnOrder("firstName", "lastName", "age", "gender");
            studentsTable.removeColumn("id");
            studentsTable.setImmediate(true);

            return this;

        }

        public ShowAllStudentsLayout load(){
            students = showAllStudentsService.getAllStudents();
            return this;
        }

        public ShowAllStudentsLayout layout(){
            this.addComponent(studentsTable);
            return this;
        }

    }

    @Autowired
    private ShowAllStudentsService showAllStudentsService;

    public Component createComponent(){
        return new ShowAllStudentsLayout().load().init().layout();
    }

}
