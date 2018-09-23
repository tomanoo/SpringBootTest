package com.example.bean;

public class StudentBean {

    private Long id;
    private String name;
    private String passportNumber;
    private Long teacherBean;

    public StudentBean(){}

    public StudentBean(Long id, String name, String passportNumber) {
        this.id = id;
        this.name = name;
        this.passportNumber = passportNumber;
    }

    public StudentBean(Long id, String name, String passportNumber, Long teacherBean) {
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

    public Long getTeacherBean() {
        return teacherBean;
    }

    public void setTeacherBean(Long teacherBean) {
        this.teacherBean = teacherBean;
    }
}

