package com.sdxmxy.bookmanage;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.sdxmxy.bookmanage")
public class BookManageApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookManageApplication.class, args);
	}

}

