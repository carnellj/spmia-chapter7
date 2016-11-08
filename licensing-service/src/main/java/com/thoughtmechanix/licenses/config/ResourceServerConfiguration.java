package com.thoughtmechanix.licenses.config;


import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;

@Configuration
public class ResourceServerConfiguration extends ResourceServerConfigurerAdapter{
    //    /**
//     * Authenticate every URL, except the login page. Add CSRF protection and configure form login
//     * instead of (the default) Basic Authentication.
//     */
    @Override
    public void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/v1/organizations/**").hasRole("ADMIN")
                .anyRequest().authenticated();
    }

}
