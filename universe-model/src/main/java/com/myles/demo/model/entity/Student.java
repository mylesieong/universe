package com.myles.demo.model.entity;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.Column;

@Entity
@Table(name="STUDENT")
public class Student {

    @Id
    @GeneratedValue
    @Column(name="id")
    private Integer id;

    @NotNull(message="You have to specify first name")
    @Column(name="first_name")
    private String firstName;

    @NotNull(message="You have to specify last name")
    @Column(name="last_name")
    private String lastName;

    @NotNull(message="You have to specify age")
    @Min(value=0, message="Minimum value is 0")
    @Max(value=100, message="Maximum value is 100")
    @Column(name="age")
    private Integer age;

    @NotNull(message="Gender must be set.")
    @Column(name="gender")
    private String gender;

    public Student(){}

    public Integer getId(){return this.id;}
    public void setId(Integer id){this.id = id;}

    public String getFirstName(){return this.firstName;}
    public void setFirstName(String firstName){this.firstName = firstName;}

    public String getLastName(){return this.lastName;}
    public void setLastName(String lastName){this.lastName = lastName;}

    public Integer getAge(){return this.age;}
    public void setAge(Integer age){this.age = age;}

    public String getGender(){return this.gender;}
    public void setGender(String gender){this.gender = gender;}

    @Override 
    public String toString(){
        return this.firstName + "-" + this.lastName + "-" + this.age;
    }
}
