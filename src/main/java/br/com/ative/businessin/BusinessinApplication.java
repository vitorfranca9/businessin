package br.com.ative.businessin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.web.DispatcherServletAutoConfiguration;
import org.springframework.boot.autoconfigure.web.WebMvcAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableAutoConfiguration(exclude={WebMvcAutoConfiguration.class, DispatcherServletAutoConfiguration.class })
@ComponentScan(basePackages={""})
//@Configuration
@EntityScan
public class BusinessinApplication {

	public static void main(String[] args) {
		SpringApplication.run(BusinessinApplication.class, args);
	}
}
