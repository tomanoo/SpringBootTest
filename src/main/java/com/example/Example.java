package com.example;

import com.example.student.Student;
import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import com.example.student.StudentRepository;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class Example {
    //Student student1 = new Student();

   /* @RequestMapping("/")
    String home(){
        return "Killer!" + "<p>" +Instant.now() + "</p>" + Math.PI + student1.getName();
    }*/



    public static void main(String[] args) throws Exception{
        SpringApplication.run(Example.class, args);
    }

   /* @Bean
    CommandLineRunner runner(StudentRepository repository){
        return args -> {
            repository.save(new Student(1L, "Kek", "AXC247256"));

        };
    }*/
}
