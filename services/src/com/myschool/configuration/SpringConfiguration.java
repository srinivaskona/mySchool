package com.myschool.configuration;

import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.core.io.ClassPathResource;

import com.myschool.dao.UserDao;
import com.myschool.dao.impl.UserDaoImpl;
import com.myschool.services.UserService;
import com.myschool.services.impl.UserServiceImpl;

@Import({RepositoryConfiguration.class})
@Configuration
public class SpringConfiguration {

	@Bean
	public UserDao getUserDao(){
		return new UserDaoImpl();
	}
	
	@Bean
	public UserService getUserService(){
		return new UserServiceImpl();
	}
	
	@Bean
	public PropertyPlaceholderConfigurer getPropertyPlaceHolderConfigurer(){

		PropertyPlaceholderConfigurer propertyConfigurer = new PropertyPlaceholderConfigurer();
		propertyConfigurer.setLocation(new ClassPathResource("project.properties"));
		propertyConfigurer.setIgnoreUnresolvablePlaceholders(true);
		return propertyConfigurer;
	}

}
