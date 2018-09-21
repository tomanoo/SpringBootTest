package com.example.model;

import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name= "student")
@DynamicUpdate
public class Student implements Serializable {

    private static final long serialVersionUID = 3509071389208277005L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private Long id;
    @Column(name="name")
    private String name;
    @Column(name="passport_number")
    private String passportNumber;

    @ManyToOne(targetEntity = Student.class, fetch = FetchType.EAGER)
    @JoinColumn(name = "teacher_id")
    private Long teacherId;

    public Student() {
        super();
    }
    public Student(String name, String passportNumber) {
        super();
        this.name = name;
        this.passportNumber = passportNumber;
    }

    public Student(Long id, String name, String passportNumber) {
        super();
        this.id = id;
        this.name = name;
        this.passportNumber = passportNumber;
    }

    public Student(Long id, String name, String passportNumber, Long teacherId) {
        super();
        this.id = id;
        this.name = name;
        this.passportNumber = passportNumber;
        this.teacherId = teacherId;
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

    public Long getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(Long teacherId) {
        this.teacherId = teacherId;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", passportNumber='" + passportNumber + '\'' +
                ", teacherId=" + teacherId +
                '}';
    }
}

