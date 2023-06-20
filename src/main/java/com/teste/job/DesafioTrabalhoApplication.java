package com.teste.job;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.ComponentScans;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
public class DesafioTrabalhoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DesafioTrabalhoApplication.class, args);
	}

}
