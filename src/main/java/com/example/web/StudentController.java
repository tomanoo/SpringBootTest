package com.example.web;


import com.example.bean.StudentBean;
import com.example.service.StudentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class StudentController {

    private Logger logger = LoggerFactory.getLogger(StudentController.class);

    @Autowired
    StudentService studentService;

    @RequestMapping(value = "/web/student/{id}", method = RequestMethod.GET)
    public StudentBean getStudentById(@PathVariable Long id){

    }
}
