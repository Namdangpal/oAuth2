package com.sk.dep.staff.oauth2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import springfox.documentation.swagger2.annotations.EnableSwagger2;
@EnableSwagger2
@SpringBootApplication
public class ServiceStaffOauth2Application {

	public static void main(String[] args) {
		SpringApplication.run(ServiceStaffOauth2Application.class, args);
	}
	
	/*@Bean
    public InternalResourceViewResolver setupViewResolver() { 
        InternalResourceViewResolver resolver = new InternalResourceViewResolver(); 
        resolver.setPrefix("/WEB-INF/views/");
        resolver.setSuffix(".jsp");
        return resolver;
    }*/
 
}
