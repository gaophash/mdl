package com.jiasu.mdl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
public class MdlApplication  {

    public static void main(String[] args) {
        SpringApplication.run(MdlApplication.class, args);
    }

}
