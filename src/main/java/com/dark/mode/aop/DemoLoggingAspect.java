package com.dark.mode.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;

@Aspect
@Component
@Order(2)
public class DemoLoggingAspect {

    @Before("com.dark.mode.aop.DemoConfigAspect.logAddedAccount()")
    public void logAddedAccount(JoinPoint joinPoint) {
        System.out.println(joinPoint.getSignature());

        for (Object obj : joinPoint.getArgs()) {
            if (obj instanceof Person) {
                System.out.println(((Person) obj).getFirstName());
                System.out.println(((Person) obj).getLastName());
            } else {
                System.out.println(obj);
            }
        }
        System.out.println("=====> logging add account.");
    }

    @AfterReturning(
            pointcut = "com.dark.mode.aop.DemoConfigAspect.findAdvice()",
            returning = "persons"
    )
    public void afterReturningFind(JoinPoint joinPoint, List<Person> persons) {
        System.out.println(joinPoint.getSignature().toShortString());
        System.out.println(persons);
    }
}
