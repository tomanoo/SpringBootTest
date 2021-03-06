package com.example.bean;

public class StudentBean {

    private Long id;
    private String name;
    private String passportNumber;
    private TeacherBean teacherBean;

    public StudentBean(){}

    public StudentBean(Long id, String name, String passportNumber) {
        this.id = id;
        this.name = name;
        this.passportNumber = passportNumber;
    }

    public StudentBean(Long id, String name, String passportNumber, TeacherBean teacherBean) {
        this.id = id;
        this.name = name;
        this.passportNumber = passportNumber;
        this.teacherBean = teacherBean;
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

    public TeacherBean getTeacherBean() {
        return teacherBean;
    }

    public void setTeacherBean(TeacherBean teacherBean) {
        this.teacherBean = teacherBean;
    }
}

