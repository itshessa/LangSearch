package com.example.demo.config;

import com.example.demo.service.MyUserDetailsService;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
@Configuration  
@EnableWebSecurity 
@EnableJpaRepositories("com.delivery.repository")

public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
	@Autowired
	private DataSource dataSource;
    @Bean
    public MyUserDetailsService userDetailsService() {
        return new MyUserDetailsService();
    }
     
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
     
    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userDetailsService());
        authProvider.setPasswordEncoder(passwordEncoder());
         
        return authProvider;
    }
 
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authenticationProvider());
    }
 



    
    public void configure(HttpSecurity http) throws Exception {        
        http.csrf().disable()
        .authorizeRequests()
        .antMatchers("/home","edit","profile").authenticated()
        .anyRequest().permitAll()
        .and()
        .formLogin()
        .loginPage("/login")
        .permitAll()
        .usernameParameter("email")
        .passwordParameter("password")
            .defaultSuccessUrl("/home")
        .and()
        .logout().logoutSuccessUrl("/").permitAll()
        .invalidateHttpSession(true)
        .deleteCookies("JSESSIONID")
        ;
        }
    
}
