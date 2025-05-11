package com.harshal.Notes_Taking_App.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.DefaultSecurityFilterChain;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Autowired
    private UserDetailsService userDetailsService;

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public DaoAuthenticationProvider daoAuthenticationProvider() {
        DaoAuthenticationProvider dap = new DaoAuthenticationProvider();

        dap.setUserDetailsService(userDetailsService);
        dap.setPasswordEncoder(passwordEncoder());

        return dap;
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http.csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(auth -> {
                    auth.requestMatchers("/user/**").hasRole("USER");
                    auth.requestMatchers("/**").permitAll();
                })
                .formLogin(form -> {
                    form.loginPage("/signin")
                            .loginProcessingUrl("/user-login")
                            .defaultSuccessUrl("/user/add-notes", true)
                            .permitAll();
                });


        DefaultSecurityFilterChain build = http.build();

        return build;
    }
}
