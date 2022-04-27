package com.aldente.dev;

import java.util.Collections;

import com.aldente.dev.JwtFilter.JwtFilter;
import com.aldente.dev.repo.AppointmentRepo;
import com.aldente.dev.service.AppointmentManager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
// @EnableSwagger2
public class AlDenteApp {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(AlDenteApp.class, args);

		AppointmentRepo appointmentRepo = context.getBean(AppointmentRepo.class);
		AppointmentManager appointmentManager = new AppointmentManager(appointmentRepo);

	}

	@Bean
	public FilterRegistrationBean<JwtFilter> filterRegistrationBean() {
		FilterRegistrationBean<JwtFilter> filterRegistrationBean = new FilterRegistrationBean<>();
		filterRegistrationBean.setFilter(new JwtFilter());

		filterRegistrationBean.setUrlPatterns(Collections.singleton("/api/categories/*"));

		return filterRegistrationBean;
	}

	// @Bean
	// public Docket productApi() {
	// 	return new Docket(DocumentationType.SWAGGER_2).select()
	// 			.apis(RequestHandlerSelectors.basePackage("com.tutorialspoint.swaggerdemo")).build();
	// }

}
