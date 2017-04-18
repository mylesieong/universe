package com.myles.demo.ui.students;

import java.util.List;

import com.vaadin.ui.Component;
import com.vaadin.ui.Grid;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.data.util.BeanItemContainer;

import com.myles.demo.model.entity.Student;
import com.myles.demo.ui.commons.UIComponentBuilder;

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
            studentsTable.setColomnuOrder("firstName", "lastName", "age", "gender");
            studentsTable.removeColomn("id");
            studentsTable.setImmediate(true);

            return this;

        }

        public ShowAllStudentsLayout load(){
            return this;
        }

        public ShowAllStudentsLayout layout(){
            this.addComponent(studentsTable);
            return this;
        }

    }

    public Component createComponent(){
        return new ShowAllStudentsLayout().init().load().layout();
    }

}
