package com.myles.demo.ui.students;

import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.TextField;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.GridLayout;
import com.vaadin.ui.Component;
import com.vaadin.ui.themes.ValoTheme;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Notification.Type;

import com.vaadin.data.fieldgroup.BeanFieldGroup;
import com.vaadin.data.fieldgroup.FieldGroup.CommitException;
import com.vaadin.data.fieldgroup.PropertyId;

import org.springframework.beans.factory.annotation.Autowired;

import com.myles.demo.model.entity.Student;
import com.myles.demo.utils.Gender;
import com.myles.demo.utils.StudentsStringUtils;
import com.myles.demo.utils.NotificationMessage;
import com.myles.demo.service.addstudent.AddStudentService;
import com.myles.demo.ui.commons.UIComponentBuilder;

@org.springframework.stereotype.Component
public class AddStudentMainLayoutFactory {

    private class AddStudentMainLayout extends VerticalLayout implements Button.ClickListener{
        /* UI component */
        @PropertyId("firstName")        //Note if is mFirstName, then setter shd name setMFirst...
        private TextField firstName;
        @PropertyId("lastName")         //in fact this is optional if name is same
        private TextField lastName;
        private TextField age;
        private ComboBox gender;
        private Button saveButton;
        private Button clearButton;
        /* Model related field */
        private BeanFieldGroup<Student> fieldGroup;
        private Student student;

        @Autowired
        private StudentSavedListener studentSavedListener;

        public AddStudentMainLayout(StudentSavedListener listener){
            this.studentSavedListener = listener;
        }

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

            saveButton.addClickListener(this);
            clearButton.addClickListener(this);

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

        @Override
        public void buttonClick(ClickEvent event){
            if (event.getSource() == this.saveButton){
                save();
            }else if (event.getSource() == this.clearButton){
                clearField();
            }
        }

        private void save(){
            try{
                fieldGroup.commit();
            }catch (CommitException e){
                Notification.show(NotificationMessage.STUDENT_SAVE_VALIDATION_ERROR_TITLE.getString(), NotificationMessage.STUDENT_SAVE_VALIDATION_ERROR_RESTRICTION.getString(), Type.ERROR_MESSAGE);
                return;
                //e.printStackTrace();
            }
            //System.out.println(student);  
            addStudentService.saveStudent(student);

            this.studentSavedListener.studentSaved();

            clearField();
            Notification.show(NotificationMessage.STUDENT_SAVE_SUCCESS_TITLE.getString(), NotificationMessage.STUDENT_SAVE_SUCCESS_DESCRIPTION.getString(), Type.ERROR_MESSAGE);
        }

        private void clearField(){
            firstName.setValue(null);
            lastName.setValue(null);
            gender.setValue(null);
            age.setValue(null);
        }
    }

    @Autowired
    private AddStudentService addStudentService;

    public Component createComponent(StudentSavedListener listener){
        return new AddStudentMainLayout(listener).init().bind().layout();
    }

}
