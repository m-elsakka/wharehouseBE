/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wharehouse.wharehouseBE.security.config;


import com.wharehouse.wharehouseBE.model.ConstantStrings;
import com.wharehouse.wharehouseBE.security.filters.AuthSuccessHandler;
import com.wharehouse.wharehouseBE.security.filters.AuthUnsuccessHandler;
import com.wharehouse.wharehouseBE.security.filters.JWTAuthenticationFilter;
import com.wharehouse.wharehouseBE.security.filters.JWTAuthenticationMobileFilter;
import com.wharehouse.wharehouseBE.security.filters.JWTAuthorizationFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.session.HttpSessionEventPublisher;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 *
 * @author mohamed.abd-elwadod
 */
@EnableWebSecurity
public class webSecConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private AuthSuccessHandler authSuccessHandler;

    @Autowired
    private AuthUnsuccessHandler authUnsuccessHandler;

    private UserDetailsService userDetailsService;

    public webSecConfig(UserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        JWTAuthenticationFilter authenticationFilter = new JWTAuthenticationFilter(authenticationManager());
        authenticationFilter.setAuthenticationSuccessHandler(authSuccessHandler);
        authenticationFilter.setAuthenticationFailureHandler(authUnsuccessHandler);
        JWTAuthenticationMobileFilter authenticationMobileFilter = new JWTAuthenticationMobileFilter(authenticationManager());
        authenticationMobileFilter.setAuthenticationSuccessHandler(authSuccessHandler);
        authenticationMobileFilter.setAuthenticationFailureHandler(authUnsuccessHandler);
        //JWTAuthorizationFilter authorizationFilter = new JWTAuthorizationFilter(authenticationManager());
        JWTAuthorizationFilter authorizationFilter = new JWTAuthorizationFilter(authenticationManager(), getApplicationContext());
        
        
        http.cors().and()
                .csrf().disable().sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and().authorizeRequests()
                .antMatchers(HttpMethod.POST, ConstantStrings.LOGIN_WEB_URL).permitAll()
                .antMatchers(HttpMethod.POST, ConstantStrings.LOGIN_MOBILE_URL).permitAll()
                .antMatchers(HttpMethod.DELETE,ConstantStrings.LOGOUT_MOBILE_URL).permitAll()
                .antMatchers(HttpMethod.DELETE,ConstantStrings.LOGOUT_WEB_URL).permitAll()
                //<editor-fold defaultstate="collapsed" desc="Roles Access Services">
                .antMatchers("/masterdata/**").hasAnyRole("ADMIN", "MASTERDATA", "USERMANAGEMENT", "REPORTS")
                .antMatchers("/transactions/**").hasAnyRole("ADMIN", "MASTERDATA")
                .antMatchers("/mobile/**").hasAnyRole("ADMIN", "SALES_FORCE")
                .antMatchers("/usermanagement/**").hasAnyRole("ADMIN", "USERMANAGEMENT")
                .antMatchers("/reports/**").hasAnyRole("ADMIN", "REPORTS", "MASTERDATA")
                .antMatchers("/onepager/transactions/**").hasAnyRole("ADMIN", "MASTERDATA")
                .antMatchers("/onepager/mobile/**").hasAnyRole("ADMIN", "SALES_FORCE")
                //</editor-fold>
                .anyRequest().authenticated()           
                .and()
                .addFilter(authenticationFilter)
                .addFilter(authenticationMobileFilter)
                .addFilter(authorizationFilter);
    }

    @Bean
    public BCryptPasswordEncoder encoder() {
        return new BCryptPasswordEncoder();
    }

    //https://spring.io/blog/2015/06/08/cors-support-in-spring-framework
    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurerAdapter() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**").allowedMethods(HttpMethod.GET.name(),
                        HttpMethod.POST.name(),
                        HttpMethod.PUT.name(),
                        HttpMethod.DELETE.name());
            }

        };
    }
    
    @Bean
    public static ServletListenerRegistrationBean httpSessionEventPublisher() {
        return new ServletListenerRegistrationBean(new HttpSessionEventPublisher());
    }
}
