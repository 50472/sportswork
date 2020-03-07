package com.sportswork.sportswork.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import javax.annotation.Resource;


@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled=true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Resource
    private SecurityUserDetailService secrurityUserDetailService;

    @Resource
    private SecurityAuthenticationProvider provider;

//    @Bean
//    DefaultWebSecurityExpressionHandler webSecurityExpressionHandler() {
//        DefaultWebSecurityExpressionHandler handler = new DefaultWebSecurityExpressionHandler();
//        handler.setDefaultRolePrefix("");
//        return handler;
//    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .headers().frameOptions().disable()
                .and()
                .csrf().disable()
                .sessionManagement().invalidSessionUrl("/session/invalid")
                .and()
                .authorizeRequests()
                .antMatchers("/", "/home", "/index", "/register", "/login", "/logout", "/menu",
                        "/show", "/info", "/283/**", "/session/invalid","/images/**","/hg-layui-admin-ui/**").permitAll()
                .antMatchers("/admin/**").hasRole("admin")
                .antMatchers("/equipment_admin/**").hasRole("equipment_admin")
                .antMatchers("/student/**").hasRole("student")
                .antMatchers("/teacher/**").hasRole("teacher")
                .anyRequest().authenticated()
                .and()
                .formLogin().loginPage("/login").defaultSuccessUrl("/").permitAll()
                .and()
                .logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                .logoutSuccessUrl("/login").permitAll();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder builder) throws Exception {
        builder.authenticationProvider(provider);
//        builder.userDetailsService(myUserDetailService).passwordEncoder(new SecurityPasswordEncoder());
    }
}
