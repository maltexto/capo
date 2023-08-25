package dev.maltexto.capo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.HttpStatusEntryPoint;

@EnableWebSecurity
@Configuration
public class SecurityConfig {

        @Bean
        public UserDetailsService userDetailsService(BCryptPasswordEncoder bCryptPasswordEncoder) {
                InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();

                manager.createUser(User.withUsername("manager")
                                .password(bCryptPasswordEncoder.encode("manager"))
                                .roles("MANAGER")
                                .build());

                manager.createUser(User.withUsername("operator")
                                .password(bCryptPasswordEncoder.encode("operator"))
                                .roles("OPERATOR")
                                .build());
                return manager;
        }

        @Bean
        public BCryptPasswordEncoder bCryptPasswordEncoder() {
                return new BCryptPasswordEncoder();
        }

        @Bean
        public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
                http
                                .authorizeHttpRequests(authorizeRequests -> authorizeRequests
                                                .antMatchers("/h2console/**").permitAll()
                                                .anyRequest().authenticated())

                                .csrf(csrf -> csrf.disable())
                                .headers(headers -> headers.frameOptions().disable())
                                .sessionManagement(
                                                sessionManagement -> sessionManagement
                                                                .sessionCreationPolicy(SessionCreationPolicy.STATELESS))

                                .httpBasic()
                                .authenticationEntryPoint(new HttpStatusEntryPoint(HttpStatus.UNAUTHORIZED));

                return http.build();
        }
}