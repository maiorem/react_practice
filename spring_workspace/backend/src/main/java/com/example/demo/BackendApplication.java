package com.example.demo;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

@SpringBootApplication
public class BackendApplication  extends SpringBootServletInitializer{

	
 
	public static void main(String[] args) {
		SpringApplication.run(BackendApplication.class, args);
		
	}
	 
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		System.out.println("DDDDDDDDDD");
		return builder.sources(BackendApplication.class);
	}

	@Bean
    public SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception {
        final SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(dataSource);
        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        Resource configLocation = (Resource)new PathMatchingResourcePatternResolver().getResource("classpath:mybatis-config.xml");
 
        sessionFactory.setConfigLocation(configLocation);
        //sessionFactory.setMapperLocations(resolver.getResources("classpath:mappers/*.xml"));
        return sessionFactory.getObject();
    }
    
	@Bean
	public SqlSessionTemplate sqlSession(SqlSessionFactory sqlSessionFactory) {
		return new SqlSessionTemplate(sqlSessionFactory);
	}	
}
