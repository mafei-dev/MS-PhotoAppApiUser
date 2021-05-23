package com.mafei.photoapp.api.user.resource;

import com.mafei.photoapp.api.user.config.UserDatabaseConfig;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.transaction.ChainedTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;

/*
  @Author kalhara@bowsin
  @Created 5/23/2021 5:24 PM  
*/
@Configuration
public class TxManager {

    public static final String TX_MANAGER_GLOBAL = "TX_MANAGER_GLOBAL";

    @Bean(name = TX_MANAGER_GLOBAL)
    public ChainedTransactionManager transactionManager(@Qualifier(UserDatabaseConfig.TX_MANAGER_USER) PlatformTransactionManager userTransactionManager) {
        return new ChainedTransactionManager(userTransactionManager);
    }
}
