package com.example;

import com.example.student.Student;
//import com.example.student.StudentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.context.ApplicationContext;

import java.util.Arrays;


@SpringBootApplication
public class Example{// implements CommandLineRunner{

    private Logger logger = LoggerFactory.getLogger(this.getClass());

   // @Autowired
   // StudentRepository repository;

    public static void main(String[] args){
        ApplicationContext ctx = SpringApplication.run(Example.class, args);

        System.out.println("Let's inspect the beans provided by Spring Boot!");

        String[] beanNames = ctx.getBeanDefinitionNames();
        Arrays.sort(beanNames);
        for(String beanName : beanNames)
            System.out.println(beanName);
    }
/*
    @Override
    public void run(String... args) throws Exception {

        logger.info("Student id 2 -> {}", repository.findById(2L));

        logger.info("All users 1 -> {}", repository.findAll());

        //Insert
    //    logger.info("Inserting -> {}", repository.save(new Student("John", "AZX123467")));

        //Update
        logger.info("Update 10001 -> {}", repository.save(new Student(10001L, "Name-Updated", "New-Passport")));

    //    repository.deleteById(2L);

        logger.info("All users 2 -> {}", repository.findAll());
    }*/

}
