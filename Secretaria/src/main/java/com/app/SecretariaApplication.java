package com.app;

import java.util.TimeZone;

import javax.annotation.PostConstruct;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;

import com.app.response.FileStorageProperties;


@SpringBootApplication
@EntityScan(basePackageClasses = { 
		SecretariaApplication.class,
		Jsr310JpaConverters.class 
})
@EnableConfigurationProperties({
    FileStorageProperties.class
})
public class SecretariaApplication {
	
	@PostConstruct
	void init() {
		TimeZone.setDefault(TimeZone.getTimeZone("America/Guayaquil"));
	}

	public static void main(String[] args) {
		SpringApplication.run(SecretariaApplication.class, args);
	}

}

