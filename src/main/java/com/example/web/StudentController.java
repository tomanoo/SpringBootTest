package com.example.web;


import com.example.bean.StudentBean;
import com.example.bean.TeacherBean;
import com.example.model.Teacher;
import com.example.service.StudentService;
import com.example.service.TeacherService;
import com.example.service.TransformerProvider;
import com.example.model.Student;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@CrossOrigin
public class StudentController {

    private Logger logger = LoggerFactory.getLogger(StudentController.class);

    @Autowired
    StudentService studentService;

    @Autowired
    TeacherService teacherService;

    @Autowired
    TeacherController teacherController;

    @Autowired
    TransformerProvider transformerProvider;

    @RequestMapping(value = "/web/student/{id}", method = RequestMethod.GET)
    public StudentBean getStudentById(@PathVariable Long id){
        Optional<Student> student = studentService.getStudentById(id);
        //return transformerProvider.setStudentFromModel(studentService.getStudentById(id));
        return student.map(s -> transformerProvider.setStudentFromModel(s)).orElse(new StudentBean());
    }

    @RequestMapping(value = "/web/student/{id}", method = RequestMethod.DELETE)
    public void removeStudent(@PathVariable Long id) throws Exception{
        studentService.removeStudent(id);
    }

    @RequestMapping(value = "/web/student", method = RequestMethod.GET)
    public List<StudentBean> getStudentsByName(@RequestParam(name = "name") String name){
        return studentService.getStudentsByName(name).stream().map(s -> transformerProvider.setStudentFromModel(s)).collect(Collectors.toList());
    }

    @RequestMapping(value = "/web/student/name-containing/{value}", method = RequestMethod.GET)
    public List<StudentBean> getStudentsByNameContaining(@PathVariable String value){
        return studentService.getStudentsByNameContaining(value).stream().map(s -> transformerProvider.setStudentFromModel(s)).collect(Collectors.toList());
    }

    @RequestMapping(value = "/web/student/passport_number", method = RequestMethod.GET)
    public StudentBean getStudentByPassportNumber(@RequestParam(name = "passport_number") String passportNumber){
        return transformerProvider.setStudentFromModel(studentService.getStudentByPassportNumber(passportNumber));
    }

    @RequestMapping(value = "web/student/passport_number-containing/{value}", method = RequestMethod.GET)
    public List<StudentBean> getStudentsByPassportNumberContaining(@PathVariable String value){
        return studentService.getStudentsByPassportNumberContaining(value).stream().map(s -> transformerProvider.setStudentFromModel(s)).collect(Collectors.toList());
    }

    @RequestMapping(value = "web/student/teacher_id/{id}", method = RequestMethod.GET)
    public List<StudentBean> getStudentsByTeacher(@RequestParam(name = "teacher_id") Teacher teacher){
        return studentService.getStudentsByTeacher(teacher).stream().map(s -> transformerProvider.setStudentFromModel(s)).collect(Collectors.toList());
    }

    @RequestMapping(value = "/web/students", method = RequestMethod.GET)
    public List<StudentBean> getAllStudents(){
        return studentService.getAllStudents().stream().map(s -> transformerProvider.setStudentFromModel(s)).collect(Collectors.toList());
    }

    @RequestMapping(value = "/web/student", method = RequestMethod.POST)
    public Long addStudent(@RequestParam(name="name") String name,
                           @RequestParam(name="passportNumber") String passportNumber,
                           @RequestParam(name = "teacher_id") Long teacherBean){
        StudentBean studentBean = new StudentBean();
        TeacherBean teacherBean1 = teacherController.getTeacherById(teacherBean);
        studentBean.setName(name);
        studentBean.setPassportNumber(passportNumber);
        studentBean.setTeacherBean(teacherBean1);
        return studentService.addStudent(transformerProvider.setStudentFromBean(studentBean));
    }

    @RequestMapping(value = "web/student", method = {RequestMethod.PUT, RequestMethod.PATCH})
    public void updateStudent(@RequestParam(name = "id") Long id,
                              @RequestParam(name = "name") String name,
                              @RequestParam(name = "passportNumber") String passportNumber,
                              @RequestParam(name = "teacher_id") Long teacherBean){
        StudentBean studentBean = new StudentBean();
        TeacherBean teacherBean1 = teacherController.getTeacherById(teacherBean);
        studentBean.setId(id);
        studentBean.setName(name);
        studentBean.setPassportNumber(passportNumber);
        studentBean.setTeacherBean(teacherBean1);
        }
}
