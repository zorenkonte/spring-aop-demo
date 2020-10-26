package com.dark.mode.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(1)
public class DemoCloudAspect {

    @Before("com.dark.mode.aop.DemoConfigAspect.logAddedAccount()")
    public void logAddedAccount() {
        System.out.println("=====> cloud logging add account.");
    }
}
