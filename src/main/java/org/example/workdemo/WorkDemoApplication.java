package org.example.workdemo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("org.example.workdemo.persistence")
public class WorkDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(WorkDemoApplication.class, args);
	}

}
