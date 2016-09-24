package configuration;

import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.core.io.ClassPathResource;

import dao.UserDao;
import dao.impl.UserDaoImpl;

@Import({RepositoryConfiguration.class})
@Configuration
public class SpringConfiguration {

	@Bean
	public UserDao getUserDao(){
		return new UserDaoImpl();
	}

	@Bean
	public PropertyPlaceholderConfigurer getPropertyPlaceHolderConfigurer(){

		PropertyPlaceholderConfigurer propertyConfigurer = new PropertyPlaceholderConfigurer();
		propertyConfigurer.setLocation(new ClassPathResource("project.properties"));
		propertyConfigurer.setIgnoreUnresolvablePlaceholders(true);
		return propertyConfigurer;
	}

}
