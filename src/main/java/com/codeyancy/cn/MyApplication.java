package com.codeyancy.cn;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author Zjy
 * @date 2021/4/12 12:49
 */
@SpringBootApplication
@MapperScan(basePackages = "com.codeyancy.cn.mapper")
@EnableTransactionManagement //开启事务
@EnableAsync //开启异步任务
public class MyApplication {

    public static void main(String[] args) {
        SpringApplication.run(MyApplication.class);
    }
}
