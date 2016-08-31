package br.com.ative.businessin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EnableAutoConfiguration
//@ComponentScan
//@Configuration
@EntityScan
public class BusinessinApplication {

	public static void main(String[] args) {
		SpringApplication.run(BusinessinApplication.class, args);
	}
}
