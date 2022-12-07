package com.etiya.ecommercedemopair6;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class EcommerceDemoPair6Application {

	public static void main(String[] args) {
		SpringApplication.run(EcommerceDemoPair6Application.class, args);
	}

	@Bean
	public ModelMapper getModelMapper (){
		return new ModelMapper();

	}
}
