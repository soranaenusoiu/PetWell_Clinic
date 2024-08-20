package org.example.petwell_clinic.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.sql.DataSource;

@Configuration
public class SecurityConfig {

   // add support for JDBC and no more hardcoded users
    @Bean
    public UserDetailsManager usersDetailsManager(DataSource dataSource) {
        return new JdbcUserDetailsManager(dataSource);
    }


    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http.authorizeHttpRequests(configurer ->
                        configurer
//                        .requestMatchers(HttpMethod.GET, "/veterinary", "/pet", "/owner", "/appointment", "/schedule").hasRole("USER")
                                .requestMatchers(HttpMethod.GET, "/veterinary/**", "/pet/**", "/owner/**", "/appointment/**", "/schedule/**").hasRole("USER")
                                .requestMatchers(HttpMethod.POST, "/pet/**", "/owner/**", "/appointment/**").hasRole("USER")
                                .requestMatchers(HttpMethod.PUT, "/pet/**", "/owner/**", "/appointment/**").hasRole("USER")
                                .requestMatchers(HttpMethod.DELETE,"/pet/**", "/owner/**", "/appointment/**").hasRole("USER")

                                .requestMatchers(HttpMethod.POST, "/veterinary/add", "/schedule/add").hasRole("ADMINISTRATOR")
                                .requestMatchers(HttpMethod.PUT, "/veterinary/update", "/schedule/update").hasRole("ADMINISTRATOR")
                                .requestMatchers(HttpMethod.DELETE,"/veterinary/deleteById/*", "/schedule/deleteById/*").hasRole("ADMINISTRATOR")
        );
        // use HTTP Basic authentication
        http.httpBasic(Customizer.withDefaults());
        // disable Cross Site Request Forgery (CSRF)
        // in general not required for stateless REST APIs that use POST, PUT, DELETE and/or PATCH
        http.csrf(csrf -> csrf.disable());
        return http.build();

    }

     /*
    @Bean
    public InMemoryUserDetailsManager userDetailsManager() {

        UserDetails baciu = User.builder()
                .username("Baciu")
                .password("{noop}test123")
                .roles("USER")
                .build();

        UserDetails popescu = User.builder()
                .username("Popescu")
                .password("{noop}test123")
                .roles("USER")
                .build();

        UserDetails admin = User.builder()
                .username("admin")
                .password("{noop}test123")
                .roles("USER", "ADMINISTRATOR")
                .build();
        return new InMemoryUserDetailsManager(baciu, popescu, admin);

    }
    */

}
