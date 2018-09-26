package com.example.bean;


import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

public class TeacherBean {

    private Long id;
    private String name;
    private String subject;
    //private List<StudentBean> students;
    private List<Long> students;

    public TeacherBean() {
        super();
    }

    public TeacherBean(String name, String subject, List<Long> students) {
        super();
        this.name = name;
        this.subject = subject;
        this.students = students;
    }

    public TeacherBean(Long id, String name, String subject, List<Long> students) {
        super();
        this.id = id;
        this.name = name;
        this.subject = subject;
        this.students = students;
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

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    //public List<StudentBean> getStudents() {
    public List<Long> getStudents(){
        if (CollectionUtils.isEmpty(students)) {
            students = new ArrayList<>();
        }
        return students;
    }

    public void setStudents(List<Long> students) {//StudentBean> students) {
        this.students = students;
    }

    public void addStudentToTeacher(Long studentId) {//StudentBean studentBean){
        students.add(studentId);//studentBean);
    }
}
