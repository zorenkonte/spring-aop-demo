package com.dark.mode.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(3)
public class DemoAPIAspect {

    @Before("com.dark.mode.aop.DemoConfigAspect.logAddedAccount()")
    public void logAddedAccount() {
        System.out.println("=====> api logging add account.");
    }
}
