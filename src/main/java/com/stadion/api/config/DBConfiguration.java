package com.stadion.api.config;

import org.apache.ibatis.session.SqlSessionFactory; 
import org.mybatis.spring.SqlSessionFactoryBean; 
import org.mybatis.spring.SqlSessionTemplate; 
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.beans.factory.annotation.Value; 
import org.springframework.context.ApplicationContext; 
import org.springframework.context.annotation.Bean; 
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import java.io.IOException;

import javax.sql.DataSource;


@Configuration
@MapperScan(basePackages = {"com.stadion.api"})
public class DBConfiguration {

	@Value("${spring.datasource.driverClassName}")  //driver-class-name}")
	private String driverClassName;
	
	@Value("${spring.datasource.url}")
	private String url;
	
	@Value("${spring.datasource.username}")
	private String username;
	
	@Value("${spring.datasource.password}")
	private String password;

	@Autowired
	ApplicationContext applicationContext;
	
	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName(driverClassName);
		dataSource.setUrl(url);
		dataSource.setUsername(username);
		dataSource.setPassword(password);

		return dataSource;
	}

    @Bean
    public SqlSessionFactoryBean sqlSessionFactory(DataSource dataSource) throws IOException {
        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
        
        factoryBean.setDataSource(dataSource);
      //  factoryBean.setConfigLocation(applicationContext.getResource("classpath:/mybatis/mybatis-config.xml"));
        factoryBean.setMapperLocations(applicationContext.getResources("classpath:mapper/**/*.xml"));
        return factoryBean;
    }

    @Bean
    public SqlSessionTemplate sqlSession(SqlSessionFactory sqlSessionFactory) {
        return new SqlSessionTemplate(sqlSessionFactory);
    }

}

