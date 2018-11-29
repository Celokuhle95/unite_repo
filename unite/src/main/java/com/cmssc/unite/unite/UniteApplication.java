package com.cmssc.unite.unite;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class UniteApplication {

	public static void main(String[] args) {
		SpringApplication.run(UniteApplication.class, args);
	}

	@Bean
	public Docket getDocket() {
		Docket docket  = new Docket(DocumentationType.SWAGGER_2);
		docket.select().apis(RequestHandlerSelectors.basePackage("com.cmssc.unite.unite.controller")).build();
		return docket;
	}

	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurerAdapter() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**").allowedOrigins("http://localhost:4200/**", "http://localhost:4200");
			}
		};
	}
}