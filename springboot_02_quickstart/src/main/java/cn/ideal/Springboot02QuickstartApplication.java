package cn.ideal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
//@SpringBootConfiguration
//@EnableAutoConfiguration
public class Springboot02QuickstartApplication {
    public static void main(String[] args) {
        SpringApplication.run(Springboot02QuickstartApplication.class, args);
    }
}
