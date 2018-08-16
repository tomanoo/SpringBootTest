package com.example.service;

import com.example.dao.StudentDao;
import com.example.student.Student;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class StudentService {

    private Logger logger = LoggerFactory.getLogger(StudentService.class);

    @Autowired
    private StudentDao studentDao;

    public Optional<Student> getStudentById(Long id){
     //   return studentDao.findByStudentId(id);
        return studentDao.findById(id);
    }

    public List<Student> getStudentsByName(String name){
        return studentDao.findByNameIgnoreCase(name);
    }

    public List<Student> getStudentsByNameContaining(String name){
        return studentDao.findByNameContainingIgnoreCase(name);
    }

    public Student getStudentByPassportNumber(String passportNumber){
        return studentDao.findByPassportNumberIgnoreCase(passportNumber);
    }

    public List<Student> getStudentsByPassportNumberContaining(String passportNumber){
        return studentDao.findByPassportNumberContainingIgnoreCase(passportNumber);
    }

    public List<Student> getAllStudents(){
        Iterable<Student> students = studentDao.findAll();
        return StreamSupport.stream(students.spliterator(), false).collect(Collectors.toList());
    }

    public Long addStudent(Student student){
        studentDao.save(student);
        return student.getId();
    }

    public void removeStudent(Student student) throws Exception{
        if(!studentDao.existsById(student.getId())){
            throw new Exception("Student: " + student.toString() +" doesn't exist!");
        }
        studentDao.delete(student);
    }

    public void removeStudent(Long id) throws Exception{
        if(!studentDao.existsById(id)){
            throw new Exception("Student with id: " + id + "doesn't exist!");
        }
        studentDao.deleteById(id);
    }

}
