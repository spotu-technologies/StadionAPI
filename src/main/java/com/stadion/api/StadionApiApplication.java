package com.stadion.api;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


//@Configuration
//@EnableAutoConfiguration(exclude = { DataSourceTransactionManagerAutoConfiguration.class, DataSourceAutoConfiguration.class })
//@ComponentScan(basePackages = "com.stadion.api")
//@MapperScan (basePackages = "com.stadion.api.mapper") 
@SpringBootApplication
public class StadionApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(StadionApiApplication.class, args);
	}

}
