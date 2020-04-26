package com.swagger2.demo;

import com.swagger2.demo.model.ProgrammingLanguage;
import com.swagger2.demo.repository.IProgrammingLanguageRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    /*Loading initial data in database*/
    @Bean
    public CommandLineRunner initData(IProgrammingLanguageRepository repository) {
        return args -> {
            repository.save(new ProgrammingLanguage("Java"));
            repository.save(new ProgrammingLanguage("Ruby"));
            repository.save(new ProgrammingLanguage("Python"));
            repository.save(new ProgrammingLanguage("Go"));
            repository.save(new ProgrammingLanguage("C++"));
        };
    }

}
