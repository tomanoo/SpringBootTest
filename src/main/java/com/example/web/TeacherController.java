package com.example.web;

import com.example.bean.StudentBean;
import com.example.bean.TeacherBean;
import com.example.model.Teacher;
import com.example.service.TeacherService;
import com.example.service.TransformerProvider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@CrossOrigin
public class TeacherController {

    private Logger logger = LoggerFactory.getLogger(TeacherController.class);

    @Autowired
    TeacherService teacherService;

    @Autowired
    TransformerProvider transformerProvider;

    @RequestMapping(value = "web/teacher/{id}", method = RequestMethod.GET)
    public TeacherBean getTeacherById(@PathVariable Long id){
        Optional<Teacher> teacher = teacherService.getTeacherById(id);
        return teacher.map(t -> transformerProvider.setTeacherFromModel(t)).orElse(new TeacherBean());
    }

    @RequestMapping(value = "web/teacher/{id}", method = RequestMethod.DELETE)
    public void removeTeacher(@PathVariable Long id) throws Exception{
        teacherService.removeTeacher(id);
    }

    @RequestMapping(value = "web/teacher", method = RequestMethod.GET)
    public List<TeacherBean> getTeachersByName(@RequestParam(name = "name") String name){
        return teacherService.getTeachersByName(name).stream().map(t -> transformerProvider.setTeacherFromModel(t)).collect(Collectors.toList());
    }

    @RequestMapping(value = "web/teacher/name-containing/{value}", method = RequestMethod.GET)
    public List<TeacherBean> getTeachersByNameContaining(@PathVariable String value){
        return teacherService.getTeachersByNameContaining(value).stream().map(t -> transformerProvider.setTeacherFromModel(t)).collect(Collectors.toList());
    }

    @RequestMapping(value = "web/teacher/subject", method = RequestMethod.GET)
    public List<TeacherBean> getTeachersBySubject(@RequestParam(name = "subject") String subject){
        return teacherService.getTeachersBySubject(subject).stream().map(t -> transformerProvider.setTeacherFromModel(t)).collect(Collectors.toList());
    }

    @RequestMapping(value = "web/teacher/subject-containing/{value}", method = RequestMethod.GET)
    public List<TeacherBean> getTeachersBySubjectContaining(@PathVariable String value){
        return teacherService.getTeachersBySubjectContaining(value).stream().map(t -> transformerProvider.setTeacherFromModel(t)).collect(Collectors.toList());
    }

    @RequestMapping(value = "web/teachers", method = RequestMethod.GET)
    public List<TeacherBean> getAllTeachers(){
        return teacherService.getAllTeachers().stream().map(t -> transformerProvider.setTeacherFromModel(t)).collect(Collectors.toList());
    }

    @RequestMapping(value = "web/teacher/{id}/students", method = RequestMethod.GET)
    public List<StudentBean> getAllStudentsFromTeacher(@PathVariable Long id){
        //return getTeacherById(id).getStudents();
        return teacherService.getAllStudentsFromTeacher(id).stream().map(s -> transformerProvider.setStudentFromModel(s)).collect(Collectors.toList());
    }

    @RequestMapping(value = "web/teacher", method = RequestMethod.POST)
    public Long addTeacher(@RequestParam(name = "name") String name,
                           @RequestParam(name = "subject") String subject){
                         //  @RequestParam(name = "students") List<StudentBean> students){
        TeacherBean teacherBean = new TeacherBean();
        teacherBean.setName(name);
        teacherBean.setSubject(subject);
       // teacherBean.setStudents(students);
        return teacherService.addTeacher(transformerProvider.setTeacherFromBean(teacherBean));
    }
}