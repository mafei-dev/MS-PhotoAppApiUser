package com.mafei.photoapp.api.user.config;

import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;
import java.util.HashMap;

import static com.mafei.photoapp.api.user.config.UserDatabaseConfig.TX_MANAGER_USER;
import static com.mafei.photoapp.api.user.config.UserDatabaseConfig.USER_ENTITY_MANAGER;

/*
  @Author kalhara@bowsin
  @Created 5/23/2021 5:31 AM  
*/
@Configuration
@EnableJpaRepositories(
        basePackages = "com.mafei.photoapp.api.user.repository",
        entityManagerFactoryRef = USER_ENTITY_MANAGER,
        transactionManagerRef = TX_MANAGER_USER
)
public class UserDatabaseConfig {
    public static final String TX_MANAGER_USER = "TX_MANAGER_USER";
    public static final String USER_ENTITY_MANAGER = "USER_ENTITY_MANAGER";

    @Autowired
    private UserDataSourceData userDataSourceData;

    @Primary
    @Bean(name = USER_ENTITY_MANAGER)
    public LocalContainerEntityManagerFactoryBean userEntityManager() {
        LocalContainerEntityManagerFactoryBean em
                = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(userDataSource());
        em.setPackagesToScan("com.mafei.photoapp.api.user.entity");
        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        em.setJpaVendorAdapter(vendorAdapter);
        HashMap<String, Object> properties = new HashMap<>();
        properties.put("hibernate.hbm2ddl.auto", userDataSourceData.getJpaHibernateDdlAuto());
        em.setJpaPropertyMap(properties);
        return em;
    }


    @Primary
    @Bean
    public DataSource userDataSource() {
        DriverManagerDataSource dataSource
                = new DriverManagerDataSource();
        dataSource.setDriverClassName(
                userDataSourceData.getDriverClassName());
        dataSource.setUrl(userDataSourceData.getUrl());
        dataSource.setUsername(userDataSourceData.getUsername());
        dataSource.setPassword(userDataSourceData.getPassword());
        return dataSource;
    }


    @Primary
    @Bean(name = TX_MANAGER_USER)
    public PlatformTransactionManager userTransactionManager() {
        JpaTransactionManager transactionManager
                = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(
                userEntityManager().getObject());
        return transactionManager;
    }
}
