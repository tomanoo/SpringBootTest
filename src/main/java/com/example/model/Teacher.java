package com.example.model;


import org.hibernate.annotations.DynamicUpdate;
import org.springframework.util.CollectionUtils;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="teacher")
@DynamicUpdate
public class Teacher implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private Long id;
    @Column(name="name")
    private String name;
    @Column(name="subject")
    private String subject;

    @OneToMany(mappedBy = "teacher",
                cascade = CascadeType.ALL,
                orphanRemoval = true)
    private List<Student> students;

    public Teacher() {
        super();
    }

    public Teacher(String name, List<Student> students) {
        super();
        this.name = name;
        this.students = students;
    }

    public Teacher(Long id, String name, List<Student> students) {
        super();
        this.id = id;
        this.name = name;
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

    public List<Student> getStudents() {
        if (CollectionUtils.isEmpty(students)) {
            students = new ArrayList<>();
        }
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }
}
