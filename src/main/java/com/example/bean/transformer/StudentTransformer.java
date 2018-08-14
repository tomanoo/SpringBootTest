package com.example.bean.transformer;

import com.example.bean.StudentBean;
import com.example.student.Student;
import org.springframework.stereotype.Component;

@Component
public class StudentTransformer extends AbstractTransformer<StudentBean, Student> {

    @Override
    public StudentBean transformToBean(Student student){
        StudentBean studentBean = new StudentBean();
        studentBean.setId(student.getId());
        studentBean.setName(student.getName());
        studentBean.setPassportNumber(student.getPassportNumber());
        return studentBean;
    }

    @Override
    public Student transformFromBean(StudentBean bean){
        Student student = new Student();
        if(bean.getId() != null){
            student.setId(bean.getId());
        }
        student.setName(bean.getName());
        student.setPassportNumber(bean.getPassportNumber());
        return student;
    }

}
