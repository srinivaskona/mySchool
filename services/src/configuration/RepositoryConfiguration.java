package configuration;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.tomcat.dbcp.dbcp2.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;


@Configuration
public class RepositoryConfiguration {
	
	@Value("${jdbc.driverClassName}")
	private String driverClassName;
	@Value("${jdbc.url}")
	private String url;
	@Value("${jdbc.username}")
	private String username;
    @Value("${jdbc.password}")
    private String password;
    
    @Value("${hibernate.dialect}")         
    private String hibernateDialect;
    @Value("${hibernate.show_sql}")     
    private String hibernateShowSql;
    @Value("${hibernate.hbm2ddl.auto}") 
    private String hibernateHbm2ddlAuto;
    
	@Bean
	public DataSource getDataSource(){
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setDriverClassName(driverClassName);
		dataSource.setUrl(url);
		dataSource.setUsername(username);
		dataSource.setPassword(password);
		return dataSource;
	}
	
	@Bean
	@Autowired
	public HibernateTransactionManager transcationManager(SessionFactory sessionFactory){
		
		HibernateTransactionManager transcationManager = new HibernateTransactionManager();
		transcationManager.setSessionFactory(sessionFactory);
		return transcationManager;
		
	}
	
	@Bean
	@Autowired
	public HibernateTemplate getHibernateTemplate(SessionFactory sessionFactory){
		
		HibernateTemplate hibernateTemplate = new HibernateTemplate(sessionFactory);
		return hibernateTemplate;
	}

	
	public LocalSessionFactoryBean getSessionFactory(){
		
		LocalSessionFactoryBean localSessionFactoryBean = new LocalSessionFactoryBean();
		localSessionFactoryBean.setDataSource(getDataSource());
//		localSessionFactoryBean.setHibernateProperties(get);
		
		return localSessionFactoryBean;
	}
	
	public Properties getHibernateProperties(){
		
		Properties properties = new Properties();
		
		properties.put("hibernate.dialect", hibernateDialect);
        properties.put("hibernate.show_sql", hibernateShowSql);
        properties.put("hibernate.hbm2ddl.auto", hibernateHbm2ddlAuto);
        
        return properties;
		
	}
}
