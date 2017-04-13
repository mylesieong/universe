package com.myles.demo.model.entity;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class Student {

    private Integer id;

    @NotNull(message="You have to specify first name")
    private String firstName;

    @NotNull(message="You have to specify last name")
    private String lastName;

    @NotNull(message="You have to specify age")
    @Min(value=0, message="Minimum value is 0")
    @Max(value=100, message="Maximum value is 100")
    private Integer age;

    @NotNull(message="Gender must be set.")
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
