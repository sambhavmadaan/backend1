package com.niit.config;
import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
//import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.niit.modal.Category;
import com.niit.modal.Product;
import com.niit.modal.Supplier;
import com.niit.modal.UserDetail;
@EnableTransactionManagement
@Configuration
public class DBConfig {
	@Bean
	
public DataSource getH2DataSource() {
	DriverManagerDataSource datasrc=new DriverManagerDataSource();
	datasrc.setDriverClassName("org.h2.Driver");
	datasrc.setUrl("jdbc:h2:tcp://localhost/~/Database");
	datasrc.setUsername("sa");
	datasrc.setPassword("");
	System.out.println("Data source created");
	return datasrc;	
}
@Bean (name="sessionfactory")
public SessionFactory getSessionFactory() {
	Properties prop =new Properties();
	prop.put("hibernate.hbm2ddl.auto", "update");
	prop.put("hibernate.dialect","org.hibernate.dialect.H2Dialect" );
	
	LocalSessionFactoryBuilder sessionfactbuild=new LocalSessionFactoryBuilder(getH2DataSource());  
	sessionfactbuild.addProperties(prop);
	sessionfactbuild.addAnnotatedClass(Category.class);
	sessionfactbuild.addAnnotatedClass(Product.class);
	sessionfactbuild.addAnnotatedClass(Supplier.class);
	sessionfactbuild.addAnnotatedClass(UserDetail.class);
	SessionFactory sessfact= sessionfactbuild.buildSessionFactory();
	System.out.println("SessionFactory object created");
	return sessfact;
}
@Bean
public HibernateTransactionManager getHibernateTransactionManager(SessionFactory sessfact) {
	System.out.println("Hibernate Transaction Object Created");
	return new HibernateTransactionManager(sessfact);
}
}