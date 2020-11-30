package com.dark.mode;

import com.dark.mode.service.TrafficFortuneService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import java.util.logging.Logger;

@SpringBootApplication
@EnableAspectJAutoProxy
public class AopApplication {

    private static final Logger logger = Logger.getLogger(AopApplication.class.getName());

    public static void main(String[] args) {
        var run = SpringApplication.run(AopApplication.class, args);
        var fortuneService = run.getBean("trafficFortuneService", TrafficFortuneService.class);

        logger.info("Calling fortune service...");
        logger.info(fortuneService.getFortune());
        logger.info("Finish");
    }
}
