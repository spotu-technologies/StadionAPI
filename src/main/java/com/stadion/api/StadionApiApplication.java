package com.stadion.api;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;


@SpringBootApplication
public class StadionApiApplication extends SpringBootServletInitializer  {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(StadionApiApplication.class);
	}
	
	public static void main(String[] args) {
		 String javaVersion = System.getProperty("java.version");
		    System.out.format("JavaVersion = '%s'\n", javaVersion);
		    if (javaVersion.startsWith("1.8")) {
		        System.out.format("Version 1.8\n");
		    } else {
		        System.out.format("Version is not 1.8\n");
		    }
		SpringApplication.run(StadionApiApplication.class, args);
	}
	
    @Bean
    public ViewResolver viewResolver() {
         final InternalResourceViewResolver r = new InternalResourceViewResolver();
         r.setPrefix("/WEB-INF/jsp/");
         r.setSuffix(".jsp");
         return r;
    }

}
