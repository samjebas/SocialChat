package com.niit.config;
import java.util.Properties;
import javax.sql.DataSource;

import org.hibernate.SessionFactory;

import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;

public class HibernateConfig {
	
	public DataSource getDataSource() {
	
	DriverManagerDataSource dataSource = new DriverManagerDataSource();
	dataSource.setDriverClassName("oracle.jdbc.driver.OracleDriver");
	dataSource.setUrl("jdbc:oracle:thin:@localhost:1521/XE");
	dataSource.setUsername("hr");
	dataSource.setPassword("password");
	return dataSource;
}
@Bean(name = "sessionfactory")
public SessionFactory getSessionFactory() {
	Properties hibernateProp = new Properties();

	hibernateProp.put("hibernate.dialect", "org.hibernate.dialect.Oracle10gDialect");
	hibernateProp.put("hibernate.hbm2ddl.auto", "update");
	hibernateProp.put("hibernate.show_sql", "true");
	
	LocalSessionFactoryBuilder sessionFactoryBuiler = new LocalSessionFactoryBuilder(getDataSource());
	sessionFactoryBuiler.addProperties(hibernateProp);
	sessionFactoryBuiler.scanPackages("com.niit");
	return sessionFactoryBuiler.buildSessionFactory();
}
	
	
	
	@Bean(name="txmanager")
	public HibernateTransactionManager getHibernateTransactionManager(SessionFactory sessionFactory) {
		HibernateTransactionManager transactionManager = new HibernateTransactionManager(sessionFactory);
		return transactionManager;
	}
}

	