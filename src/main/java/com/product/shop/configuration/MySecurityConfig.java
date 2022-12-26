package com.product.shop.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import javax.sql.DataSource;

@EnableWebSecurity
public class MySecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    DataSource dataSource;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {


        auth.jdbcAuthentication().dataSource(dataSource);
    }

        @Override
        protected void configure (HttpSecurity http) throws Exception {
            http.csrf().disable()
                    .httpBasic()
                    .and()
                    .authorizeRequests()
                    .antMatchers("/").hasAnyRole("SELLER", "BUYER")
                    .antMatchers(HttpMethod.GET,"/products/**").hasAnyRole("SELLER", "BUYER")
                    .antMatchers(HttpMethod.GET,"/products/{id}/**").hasAnyRole("SELLER", "BUYER")
                    .antMatchers(HttpMethod.POST,"/products/**").hasRole("SELLER")
                    .antMatchers(HttpMethod.PUT, "/products/**").hasRole("SELLER")
                    .antMatchers(HttpMethod.DELETE, "/products/{id}/**").hasRole("SELLER")
                    .and().formLogin();


        }
    }

