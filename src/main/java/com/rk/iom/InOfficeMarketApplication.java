package com.rk.iom;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.ulisesbocchio.jasyptspringboot.annotation.EnableEncryptableProperties;

@SpringBootApplication
@EnableEncryptableProperties 
public class InOfficeMarketApplication {

	public static void main(String[] args) {
		SpringApplication.run(InOfficeMarketApplication.class, args);
	}

}
