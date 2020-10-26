package com.dark.mode.aop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy
public class AopApplication {

    public static void main(String[] args) {
        var run = SpringApplication.run(AopApplication.class, args);

        var accountDAO = run.getBean("accountDAO", AccountDAO.class);
        accountDAO.findAccounts().forEach(System.out::println);
    }
}
