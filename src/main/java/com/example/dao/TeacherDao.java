package com.example.dao;

import com.example.model.Teacher;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TeacherDao extends CrudRepository<Teacher, Long> {
    List<Teacher> findByNameIgnoreCase(String name);
    List<Teacher> findByNameContainingIgnoreCase(String name);
    List<Teacher> findBySubjectIgnoreCase(String subject);
    List<Teacher> findBySubjectContainingIgnoreCase(String subject);
}