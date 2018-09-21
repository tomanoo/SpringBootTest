package com.example.bean;

public class StudentBean {

    private Long id;
    private String name;
    private String passportNumber;
    private Long teacherBeanId;

    public StudentBean(){}

    public StudentBean(Long id, String name, String passportNumber) {
        this.id = id;
        this.name = name;
        this.passportNumber = passportNumber;
    }

    public StudentBean(Long id, String name, String passportNumber, Long teacherBeanId) {
        this.id = id;
        this.name = name;
        this.passportNumber = passportNumber;
        this.teacherBeanId = teacherBeanId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassportNumber() {
        return passportNumber;
    }

    public void setPassportNumber(String passportNumber) {
        this.passportNumber = passportNumber;
    }

    public Long getTeacherBeanId() {
        return teacherBeanId;
    }

    public void setTeacherBeanId(Long teacherBeanId) {
        this.teacherBeanId = teacherBeanId;
    }
}

