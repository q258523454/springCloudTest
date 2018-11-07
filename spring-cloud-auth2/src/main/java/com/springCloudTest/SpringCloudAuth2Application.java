package com.springCloudTest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JdbcTokenStore;

import javax.sql.DataSource;
import java.util.Arrays;


/**
 * 参考博文
 * https://blog.csdn.net/neosmith/article/details/52539927#reply
 * localhost:8080/oauth/authorize?client_id=zhang&response_type=code&redirect_uri=http://www.baidu.com
 * http://zhang:secret@localhost:8080/oauth/token
 */

@SpringBootApplication
@EnableAuthorizationServer
public class SpringCloudAuth2Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudAuth2Application.class, args);
    }

    @Autowired
    private AuthenticationProvider authenticationProvider;

    @Bean
    public AuthenticationManager authenticationManager() {
        return new ProviderManager(Arrays.asList(authenticationProvider));
    }



}
