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
                    auth.requestMatchers("users/register/alsr").permitAll();
                    auth.requestMatchers("users/register/tenant").permitAll();
                    auth.requestMatchers("users/register/maintenance").permitAll();
                    auth.requestMatchers("/login/alsr").permitAll();
                    auth.requestMatchers("/login/tenant").permitAll();
                    auth.requestMatchers("/login/maintenance").permitAll();
                    auth.requestMatchers("/tenant/**").authenticated();
                    auth.requestMatchers("/tenant/**").hasRole("TENANT");
                    auth.requestMatchers("/maintenance/**").authenticated();
                    auth.requestMatchers("/maintenance/**").hasRole("MAINTENANCE");
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
