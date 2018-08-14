package com.example.service;


import com.example.bean.StudentBean;
import com.example.bean.transformer.AbstractTransfomer;
import com.example.student.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransformerProvider {

    @Autowired
    AbstractTransfomer<StudentBean, Student> studentTransfomer;

    public StudentBean setStudentFromModel(Student model){
        StudentBean studentBean = studentTransfomer.transformToBean(model);
        return studentBean;
    }

    public Student setStudentFromBean(StudentBean bean){
        return studentTransfomer.transformFromBean(bean);
    }
}
