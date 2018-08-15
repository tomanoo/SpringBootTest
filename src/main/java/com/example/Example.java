package com.example;

import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.context.ApplicationContext;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Arrays;

@SpringBootApplication
public class Example{

    public static void main(String[] args){
        ApplicationContext ctx = SpringApplication.run(Example.class, args);

        System.out.println("Let's inspect the beans provided by Spring Boot!");

        String[] beanNames = ctx.getBeanDefinitionNames();
        Arrays.sort(beanNames);
        for(String beanName : beanNames)
            System.out.println(beanName);
    }

}
