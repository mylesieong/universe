package com.myles.demo.ui.students;

import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.TextField;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.Button;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.GridLayout;
import com.vaadin.ui.Component;
import com.vaadin.ui.themes.ValoTheme;

import com.vaadin.data.fieldgroup.BeanFieldGroup;

import com.myles.demo.model.entity.Student;
import com.myles.demo.utils.Gender;
import com.myles.demo.utils.StudentsStringUtils;

@org.springframework.stereotype.Component
public class AddStudentMainLayoutFactory{

    private class AddStudentMainLayout extends VerticalLayout{
        /* UI component */
        private TextField firstName;
        private TextField lastName;
        private TextField age;
        private ComboBox gender;
        private Button saveButton;
        private Button clearButton;
        /* Model related field */
        private BeanFieldGroup<Student> fieldGroup;
        private Student student;

        public AddStudentMainLayout init(){

            fieldGroup = new BeanFieldGroup<Student>(Student.class);
            student = new Student();

            firstName = new TextField(StudentsStringUtils.FIRST_NAME.getString());
            lastName = new TextField(StudentsStringUtils.LAST_NAME.getString());
            age = new TextField(StudentsStringUtils.AGE.getString());
            gender = new ComboBox(StudentsStringUtils.GENDER.getString());

            saveButton = new Button(StudentsStringUtils.SAVE_BUTTON.getString());
            clearButton = new Button(StudentsStringUtils.CLEAR_BUTTON.getString());

            saveButton.setStyleName(ValoTheme.BUTTON_FRIENDLY);
            clearButton.setStyleName(ValoTheme.BUTTON_PRIMARY);

            gender.addItem(Gender.GENDER_MALE.getString());
            gender.addItem(Gender.GENDER_FEMALE.getString());

            firstName.setNullRepresentation("");
            lastName.setNullRepresentation("");
            age.setNullRepresentation("");

            return this;
        }

        public AddStudentMainLayout bind(){
            fieldGroup.bindMemberFields(this);
            fieldGroup.setItemDataSource(student);
            return this;
        }

        public Component layout(){

            this.setMargin(true);

            GridLayout gridLayout = new GridLayout(2,3);
            gridLayout.setSizeUndefined();
            gridLayout.setSpacing(true);

            //First row element adding
            gridLayout.addComponent(firstName, 0, 0);
            gridLayout.addComponent(lastName, 1, 0);
            //Second row element adding
            gridLayout.addComponent(age, 0, 1);
            gridLayout.addComponent(gender, 1, 1);
            //Thirdrow element adding
            gridLayout.addComponent(new HorizontalLayout(saveButton, clearButton), 0, 2);

            return gridLayout;
        }
    }

    public Component createComponent(){
        return new AddStudentMainLayout().init().bind().layout();
    }

}
