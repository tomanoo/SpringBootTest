package com.example.service;


import com.example.bean.StudentBean;
import com.example.bean.TeacherBean;
import com.example.bean.transformer.AbstractTransformer;
import com.example.model.Student;
import com.example.model.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransformerProvider {

    @Autowired
    AbstractTransformer<StudentBean, Student> studentTransfomer;

    @Autowired
    AbstractTransformer<TeacherBean, Teacher> teacherTransformer;

    public StudentBean setStudentFromModel(Student model){
        StudentBean studentBean = studentTransfomer.transformToBean(model);
        return studentBean;
    }

    public Student setStudentFromBean(StudentBean bean){
        return studentTransfomer.transformFromBean(bean);
    }

    public TeacherBean setTeacherFromModel(Teacher model){
        TeacherBean teacherBean = teacherTransformer.transformToBean(model);
        return teacherBean;
    }

    public Teacher setTeacherFromBean(TeacherBean bean){
        return teacherTransformer.transformFromBean(bean);
    }
}
