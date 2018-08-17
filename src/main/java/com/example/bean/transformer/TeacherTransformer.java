package com.example.bean.transformer;

import com.example.bean.TeacherBean;
import com.example.model.Teacher;
import org.springframework.stereotype.Component;

@Component
public class TeacherTransformer extends AbstractTransformer<TeacherBean, Teacher> {

    @Override
    public TeacherBean transformToBean(Teacher teacher){
        TeacherBean teacherBean = new TeacherBean();
        teacherBean.setId(teacher.getId());
        teacherBean.setName(teacher.getName());
        teacherBean.setSubject(teacher.getSubject());
        return teacherBean;
    }

    @Override
    public Teacher transformFromBean(TeacherBean bean){
        Teacher teacher = new Teacher();
        if(bean.getId()!=null){
            teacher.setId(bean.getId());
        }
        teacher.setName(bean.getName());
        teacher.setSubject(bean.getSubject());
        return teacher;
    }
}
