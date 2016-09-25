package com.myschool.configuration;

import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.core.io.ClassPathResource;

@Import({RepositoryConfiguration.class})
@Configuration
public class SpringConfiguration {

/*	@Autowired
	@Bean(name="userDao")
	public UserDao getUserDao(SessionFactory sessionFactory){
		return new UserDaoImpl(sessionFactory);
	}
	
	@Bean
	public UserService getUserService(){
		return new UserServiceImpl();
	}*/
	
	@Bean
	public PropertyPlaceholderConfigurer getPropertyPlaceHolderConfigurer(){

		PropertyPlaceholderConfigurer propertyConfigurer = new PropertyPlaceholderConfigurer();
		propertyConfigurer.setLocation(new ClassPathResource("project.properties"));
		propertyConfigurer.setIgnoreUnresolvablePlaceholders(true);
		return propertyConfigurer;
	}

}
