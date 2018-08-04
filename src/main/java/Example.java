import Student.Student;
import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.web.bind.annotation.*;


import java.time.Instant;


@RestController
@EnableAutoConfiguration
public class Example {
    Student student1 = new Student();

    @RequestMapping("/")
    String home(){
        return "Killer!" + "<p>" +Instant.now() + "</p>" + Math.PI + student1.getName();
    }

    public static void main(String[] args) throws Exception{
        SpringApplication.run(Example.class, args);
    }
}
