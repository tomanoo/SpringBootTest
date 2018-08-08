package com.example.dao;

import com.example.student.Student;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface StudentDao extends CrudRepository<Student, Long> {
    List<Student> findByStudentId(Long id);
    List<Student> findByNameIgnoreCase(String name);
    List<Student> findByPassportNumberIgnoreCase(String name);
}
