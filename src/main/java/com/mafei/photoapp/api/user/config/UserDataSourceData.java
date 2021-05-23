package com.mafei.photoapp.api.user.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/*
  @Author kalhara@bowsin
  @Created 5/23/2021 5:40 AM  
*/
@ConfigurationProperties(prefix = "db.user.spring.datasource")
@Component
@Data
public class UserDataSourceData {
    private String url;
    private String username;
    private String password;
    private String driverClassName;
    private String jpaHibernateDdlAuto;
}
