package com.packt.microservices.calculator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import static springfox.documentation.builders.PathSelectors.regex;

/***
 * 
 * This is main configuration class for spring boot application.
 */
@Configuration
@SpringBootApplication
@EnableSwagger2
public class CalculatorApplication {

	/***
	 * Swagger configuration
	 * @return
	 */
    @Bean
    public Docket SwaggerDocumentationApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.packt.microservices.calculator"))
                .paths(regex("/.*"))
                .build()
                .apiInfo(metaData());
    }
    
    private ApiInfo metaData() {
        ApiInfo apiInfo = new ApiInfo(
                "Microservices Example REST API",
                "Spring Boot based REST API for Calculator",
                "1.0",
                "Terms of service- NA",
                new Contact("Packt Team", "https://packt.com", "admin@packt.com"),
                "Apache License Version 2.0",
                "https://www.apache.org/licenses/LICENSE-2.0");
        return apiInfo;
    }
    
    /***
     * Main method to initialize spring boot application. 
     * @param args
     */
	public static void main(String[] args) {
		SpringApplication.run(CalculatorApplication.class, args);
	}
}
