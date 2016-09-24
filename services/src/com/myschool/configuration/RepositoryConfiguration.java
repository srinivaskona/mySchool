package com.myschool.configuration;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
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
		DriverManagerDataSource datasource = new DriverManagerDataSource();
		datasource.setDriverClassName(driverClassName);
		datasource.setUrl(url);
		datasource.setUsername(username);
		datasource.setPassword(password);
		return datasource;
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
//		hibernateTemplate.getSessionFactory().getCurrentSession().setFlushMode(FlushMode.AUTO);
//      If i remove the abv line then i will get you have read only permission
		return hibernateTemplate;
	}

	@Bean
	public LocalSessionFactoryBean getSessionFactory(){
		
		LocalSessionFactoryBean localSessionFactoryBean = new LocalSessionFactoryBean();
		localSessionFactoryBean.setDataSource(getDataSource());
		localSessionFactoryBean.setHibernateProperties(getHibernateProperties());
		localSessionFactoryBean.setPackagesToScan(new String[]{"com.myschool"});
		return localSessionFactoryBean;
	}
	
	@Bean
	public Properties getHibernateProperties(){
		
		Properties properties = new Properties();
		
		properties.put("hibernate.dialect", hibernateDialect);
        properties.put("hibernate.show_sql", hibernateShowSql);
        properties.put("hibernate.hbm2ddl.auto", hibernateHbm2ddlAuto);
        
        return properties;
		
	}
}
