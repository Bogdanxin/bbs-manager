package com.softlab.bbsmanager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties({
        FileProperties.class
})
public class BbsManagerApplication {

    public static void main(String[] args) {
        SpringApplication.run(BbsManagerApplication.class, args);
    }

}
