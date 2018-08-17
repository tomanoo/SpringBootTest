package com.example.dao;

import com.example.model.Student;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface StudentDao extends CrudRepository<Student, Long> {
    //Student findByStudentId(Long id);
    List<Student> findByNameIgnoreCase(String name);
    List<Student> findByNameContainingIgnoreCase(String name);
    Student findByPassportNumberIgnoreCase(String name);
    List<Student> findByPassportNumberContainingIgnoreCase(String name);
}
