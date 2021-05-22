package com.jw9j.login;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * 主启动类.
 */
@SpringBootApplication
@EnableEurekaClient
public class LoginMain {
    public static void main(String[] args) {
        SpringApplication.run(LoginMain.class,args);
    }
}
