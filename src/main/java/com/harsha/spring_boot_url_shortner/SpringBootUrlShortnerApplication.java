package com.harsha.spring_boot_url_shortner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@SpringBootApplication
@ConfigurationPropertiesScan
public class SpringBootUrlShortnerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootUrlShortnerApplication.class, args);
	}

}
