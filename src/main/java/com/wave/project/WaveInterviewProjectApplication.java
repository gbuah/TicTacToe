package com.wave.project;

import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import controller.ResponseResource;
@ComponentScan(basePackageClasses=ResponseResource.class)
@SpringBootApplication
public class WaveInterviewProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(WaveInterviewProjectApplication.class, args);
	}
}
