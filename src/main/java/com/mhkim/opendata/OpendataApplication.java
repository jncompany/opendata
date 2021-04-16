package com.mhkim.opendata;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableBatchProcessing
@SpringBootApplication
public class OpendataApplication {

	public static void main(String[] args) {
		SpringApplication.run(OpendataApplication.class, args);
	}

}
