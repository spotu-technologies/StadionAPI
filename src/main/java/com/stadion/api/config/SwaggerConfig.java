package com.stadion.api.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;



@Configuration
@EnableWebMvc
//@EnableSwagger2
public class SwaggerConfig {
	private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Stadion Spring Boot REST API Demo-2")
                .version("1.0.0")
                .description("Stadion swagger api")
                .build();
    }
	
    @Bean
    public Docket restAPI() {
        return new Docket(DocumentationType.SWAGGER_2)
        		//.groupName("example")
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.any())
                //.apis(RequestHandlerSelectors.basePackage("com.stadion.api"))
                .paths(PathSelectors.any())
                //.paths(PathSelectors.ant("/**"))
                .build();
    }

    
}