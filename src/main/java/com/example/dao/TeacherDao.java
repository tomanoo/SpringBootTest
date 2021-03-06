package com.example.dao;

import com.example.model.Student;
import com.example.model.Teacher;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TeacherDao extends CrudRepository<Teacher, Long> {
    List<Teacher> findByNameIgnoreCase(String name);
    List<Teacher> findByNameContainingIgnoreCase(String name);
    List<Teacher> findBySubjectIgnoreCase(String subject);
    List<Teacher> findBySubjectContainingIgnoreCase(String subject);
    @Query(value = "SELECT Student.id FROM Student INNER JOIN Teacher ON Student.teacher_id = :tid", nativeQuery = true)
    List<Long> findStudentsById(@Param("tid") Long id);
}
