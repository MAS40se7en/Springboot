package org.mik.first.spring.configuration;

import org.mik.first.spring.service.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class ApplicationConfig {

// move to another config file
// private final UserService userService;
//    public ApplicationConfig(UserService userService){
//        this.userService= userService;
//    }
//    @Bean
//    public UserDetailsService userDetailsService(){
//        return this.userService::loadUserByName;
//    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration conf) throws Exception{
        return conf.getAuthenticationManager();
    }

//    @Bean
//    public AuthenticationProvider authenticationProvider(){
//        DaoAuthenticationProvider dp = new DaoAuthenticationProvider();
//        dp.setUserDetailsService(userDetailsService());
//        dp.setPasswordEncoder(passwordEncoder());
//        return dp;
//    }
}
