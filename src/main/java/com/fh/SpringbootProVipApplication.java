package com.fh;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.fh.dao")
public class SpringbootProVipApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootProVipApplication.class, args);
    }

}
