package edu.eci.arsw.dinoni;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"edu.eci.arsw.dinoni"})
public class DinoniApplication {

	public static void main(String[] args) {
		SpringApplication.run(DinoniApplication.class, args);
	}
}
