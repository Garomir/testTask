package com.ramich.testTask.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
            .antMatchers("/auth/**").authenticated()
            .and()
            .formLogin()
            .and()
            .logout().logoutSuccessUrl("/");
    }

    @Bean
    public UserDetailsService users(){
        UserDetails user = User.builder()
            .username("user")
            .password("{bcrypt}$2a$12$81.D5SeII3lJke7M32FBYe.2IS3PVJRi1svAmzGAAf6h0NltVmCKi")
            .roles("USER")
            .build();

        UserDetails admin = User.builder()
            .username("admin")
            .password("{bcrypt}$2a$12$QXMk7.Bi43rH2LFQdXK9JuQ0cNczT0J32umRnILZDnibabgIJ/gLW")
            .roles("ADMIN", "USER")
            .build();

        return new InMemoryUserDetailsManager(user, admin);
    }
}