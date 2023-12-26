package com.mappingbasics.basesmapping.config;

import com.mappingbasics.basesmapping.controller.api.ApiConfig;
import com.mappingbasics.basesmapping.enums.AppRoles;
import io.swagger.annotations.Api;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class PlayerSecurityConfig {


    private CunstumPlayerDetailsService cunstumPlayerDetailsService;

    public PlayerSecurityConfig(CunstumPlayerDetailsService cunstumPlayerDetailsService) {
        this.cunstumPlayerDetailsService = cunstumPlayerDetailsService;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
                .csrf(crsf->crsf.disable())
                .sessionManagement(session->session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authorizeHttpRequests(auth->{
                    auth.requestMatchers(ApiConfig.APP_ROUTE+"/admin").hasRole(String.valueOf(AppRoles.ADMIN));
                    auth.requestMatchers(ApiConfig.APP_ROUTE+"/players").hasRole(String.valueOf(AppRoles.USER));
                    auth.anyRequest().authenticated();
                })
                .httpBasic(Customizer.withDefaults())
                .build();
    }

    @Bean
    public  AuthenticationManager authenticationManager(HttpSecurity http,BCryptPasswordEncoder bCryptPasswordEncoder) throws Exception {
        AuthenticationManagerBuilder authenticationManagerBuilder=http.getSharedObject(AuthenticationManagerBuilder.class);
        authenticationManagerBuilder.userDetailsService(cunstumPlayerDetailsService).passwordEncoder(bCryptPasswordEncoder);
        return authenticationManagerBuilder.build();
    }

   /* @Bean
    public UserDetailsService users(){
        UserDetails simpleUser= User.builder()
                .username("hamed")
                .password(bCryptPasswordEncoder().encode("1234"))
                .roles(String.valueOf(AppRoles.USER))
                .build();

        UserDetails admin=User.builder()
                .username("ali")
                .password(bCryptPasswordEncoder().encode("1234"))
                .roles(String.valueOf(AppRoles.ADMIN))
                .build();

        return new InMemoryUserDetailsManager(simpleUser,admin);
    }*/

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
