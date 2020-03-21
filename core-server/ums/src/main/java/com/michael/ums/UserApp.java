package com.michael.ums;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.SpringCloudApplication;

@SpringBootApplication
public class UserApp {

    public static void main(String[] args) {

        SpringApplication.run(UserApp.class,args);


    }
}
