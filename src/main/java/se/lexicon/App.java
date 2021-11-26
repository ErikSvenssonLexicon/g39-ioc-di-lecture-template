package se.lexicon;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import se.lexicon.config.ApplicationConfiguration;
import se.lexicon.dao.StudentDAO;
import se.lexicon.model.entity.Student;

import java.util.Arrays;

public class App
{
    public static void main( String[] args ) throws JsonProcessingException {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(ApplicationConfiguration.class);

        Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);

        StudentDAO studentDAO = context.getBean(StudentDAO.class);
        ObjectMapper objectMapper = context.getBean(ObjectMapper.class);

        Student student = studentDAO.save(new Student("Karmand Aziz"));
        System.out.println(objectMapper.writeValueAsString(student));

        context.close();
    }
}
