package com.example.service;

import com.example.bean.StudentBean;
import com.example.dao.StudentDao;
import com.example.dao.TeacherDao;
import com.example.model.Student;
import com.example.model.Teacher;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class TeacherService {

    private Logger logger = LoggerFactory.getLogger(TeacherService.class);

    @Autowired
    TeacherDao teacherDao;

    @Autowired
    StudentDao studentDao;

    public Optional<Teacher> getTeacherById(Long id){
        return teacherDao.findById(id);
    }

    public List<Teacher> getTeachersByName(String name){
        return teacherDao.findByNameIgnoreCase(name);
    }

    public List<Teacher> getTeachersByNameContaining(String name){
        return teacherDao.findByNameContainingIgnoreCase(name);
    }

    public List<Teacher> getTeachersBySubject(String subject){
        return teacherDao.findBySubjectIgnoreCase(subject);
    }

    public List<Teacher> getTeachersBySubjectContaining(String subject){
        return teacherDao.findBySubjectContainingIgnoreCase(subject);
    }

    public List<Teacher> getAllTeachers(){
        Iterable<Teacher> teachers = teacherDao.findAll();
        return StreamSupport.stream(teachers.spliterator(), false).collect(Collectors.toList());
    }

    public Long addTeacher(Teacher teacher){
        teacherDao.save(teacher);
        return teacher.getId();
    }

    public void removeTeacher(Teacher teacher) throws Exception{
        if(!teacherDao.existsById(teacher.getId())){
            throw new Exception("Teacher: " + teacher.toString() + "doesn't exist!");
        }
        teacherDao.delete(teacher);
    }

    public void removeTeacher(Long id) throws Exception{
        if(!teacherDao.existsById(id)){
            throw new Exception("Teacher with id: " + id + "doesn't exist!");
        }
        teacherDao.deleteById(id);
    }

    public List<Long> getAllStudentsFromTeacher(Long id){
        return teacherDao.findAllStudentsFromTeacher(id);
    }
}
