package com.myles.demo.model.entity;

public class Student {

    private Integer id;
    private String firstName;
    private String lastName;
    private Integer age;
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
