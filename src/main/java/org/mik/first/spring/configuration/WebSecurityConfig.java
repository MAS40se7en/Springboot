package org.mik.first.spring.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.annotation.web.configurers.HeadersConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import static org.springframework.security.web.util.matcher.AntPathRequestMatcher.antMatcher;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
       return http
               .csrf(AbstractHttpConfigurer::disable)
               .authorizeHttpRequests(a->
                       a.requestMatchers(
                               antMatcher("/h2/**"),
                               antMatcher("/users/**"),
                               antMatcher("/**") //TODO remove later

                       ).permitAll()
                               .anyRequest().authenticated()
               )
               .headers(h -> h.frameOptions(HeadersConfigurer.FrameOptionsConfig::sameOrigin))
               .httpBasic(Customizer.withDefaults())
               .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .build();
    }
}
