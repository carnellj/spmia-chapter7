package com.thoughtmechanix.organization.security;


import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;

@Configuration
public class ResourceServerConfiguration extends ResourceServerConfigurerAdapter {


//    @Override
//    public void configure_example(HttpSecurity http) throws Exception {
////       http.csrf().disable();
////       http.httpBasic().disable();
//
//        http
////                //.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)  //JWT
////               // .and()
//                .authorizeRequests()
////               // .antMatchers("/v1/organizations/**").hasRole("ADMIN")
//                .anyRequest().authenticated();
//    }

    @Override
    public void configure(HttpSecurity http) throws Exception{
        http.authorizeRequests().anyRequest().authenticated();
    }
}
