package com.oozeander.spring;

import java.util.Map;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.hibernate.cfg.Environment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan(basePackages = {"com.oozeander.service", "com.oozeander.dao"})
@EnableTransactionManagement
@PropertySource("classpath:db.properties")
public class HibernateConfig {
    @Autowired 
    private ConfigurableEnvironment env;

    @Bean DataSource dataSource() {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName(env.getRequiredProperty("db.driver"));
        dataSource.setUrl(env.getRequiredProperty("db.url"));
        dataSource.setUsername(env.getRequiredProperty("db.user"));
        dataSource.setPassword(env.getRequiredProperty("db.pass"));
        return dataSource;
    }

    @Bean LocalSessionFactoryBean sessionFactory() {
        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
        sessionFactory.setPackagesToScan("com.oozeander.model"/*, "..", ".."*/);
        sessionFactory.setDataSource(dataSource());
        sessionFactory.setHibernateProperties(hibernateProperties());
        return sessionFactory;
    }

    private Properties hibernateProperties() {
        Properties hibernateProperties = new Properties();
        hibernateProperties.putAll(
            Map.of(Environment.DIALECT, env.getRequiredProperty("db.dialect"),
                    Environment.HBM2DDL_AUTO, env.getRequiredProperty("db.hbm2ddl_auto"),
                    Environment.SHOW_SQL, env.getRequiredProperty("db.show_sql"),
                    Environment.FORMAT_SQL, env.getRequiredProperty("db.format_sql"),
                    Environment.ENABLE_LAZY_LOAD_NO_TRANS, env.getRequiredProperty("db.enable_lazy_load_no_trans"))
        );
        return hibernateProperties;
    }

    @Bean HibernateTransactionManager transactionManager() {
        return new HibernateTransactionManager(sessionFactory().getObject());
    }
}