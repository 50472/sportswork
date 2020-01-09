package com.sportswork.sportswork;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
@MapperScan("com.sportswork.sportswork.core.mapper")
public class SportsworkApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(SportsworkApplication.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        builder.sources(this.getClass());
        return builder.sources(SportsworkApplication.class);
    }
}
