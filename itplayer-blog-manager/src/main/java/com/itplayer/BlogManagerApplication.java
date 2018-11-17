package com.itplayer;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author caijun.yang
 * @date 2018/10/26
 */
@SpringBootApplication
@MapperScan("com.itplayer.**.mapper")
public class BlogManagerApplication {
    public static void main(String[] args) {
        SpringApplication springApplication = new SpringApplication(BlogManagerApplication.class);
        springApplication.run(args);
    }
}
