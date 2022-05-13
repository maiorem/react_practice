package com.woori.hello.config;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

@Configuration
@PropertySource("classpath:/application.properties")
public class DatabaseConfig {

	 //xml파일에서 <beans > ~ <bean> 
	 @Bean
	 public SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception {
		System.out.println("****************************************"); 
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




