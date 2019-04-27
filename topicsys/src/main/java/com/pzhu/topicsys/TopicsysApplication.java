package com.pzhu.topicsys;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * Desc： Appication入口
 *
 */
@SpringBootApplication
@ComponentScan({ "com.pzhu.topicsys" })
public class TopicsysApplication {
    public static void main(String[] args) {
        SpringApplication.run(TopicsysApplication.class, args);
    }
}
