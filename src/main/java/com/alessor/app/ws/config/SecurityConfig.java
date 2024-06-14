package com.alessor.app.ws.config;

import com.alessor.app.ws.service.AlessorUserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    private AlessorUserDetailService userDetailsService;

    @Autowired
    public SecurityConfig(AlessorUserDetailService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
                .authorizeHttpRequests( auth -> {
                    auth.requestMatchers("/").permitAll();
                    auth.requestMatchers("/users/alsr/register").permitAll();
                    auth.requestMatchers("/users/tenant/register").permitAll();
                    auth.requestMatchers("/users/worker/register").permitAll();
                    auth.requestMatchers("/alsr/login").permitAll();
                    auth.requestMatchers("/tenant/login").permitAll();
                    auth.requestMatchers("/worker/login").permitAll();
                    auth.requestMatchers("/tenant/**").authenticated();
                    auth.requestMatchers("/tenant/**").hasRole("TENANT");
                    auth.requestMatchers("/worker/**").authenticated();
                    auth.requestMatchers("/worker/**").hasRole("MAINTENANCE");
                    auth.requestMatchers("/alsr/**").authenticated();
                    auth.requestMatchers("/alsr/**").hasRole("LESSOR");
                    auth.anyRequest().authenticated();
                    auth.anyRequest().hasRole("LESSOR");
                })
                .oauth2Login(Customizer.withDefaults())
                .formLogin(Customizer.withDefaults())
                .build();
    }

    @Bean
    public AuthenticationManager authManager(AuthenticationConfiguration authConfig) throws Exception {
        return authConfig.getAuthenticationManager();
    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
