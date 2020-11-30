package com.dark.mode.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.logging.Logger;

@Aspect
@Component
@Order(2)
public class DemoLoggingAspect {

    private final Logger logger = Logger.getLogger(getClass().getName());
    //before method execute
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
    ) //success return
    public void afterReturningFind(JoinPoint joinPoint, List<Person> persons) {
        System.out.println(joinPoint.getSignature().toShortString());
        System.out.println(persons);

        //modify data change first name to uppercase
        if (!persons.isEmpty()) {
            persons.forEach(person -> person.setFirstName(person.getFirstName().toUpperCase()));
        }
    }

    //success or fail return
    @After("com.dark.mode.aop.DemoConfigAspect.successOrFail()")
    public void after(JoinPoint joinPoint) {
        System.out.println("Finally " + joinPoint.getSignature().toShortString());
    }

    // exception throw
    @AfterThrowing(
            pointcut = "com.dark.mode.aop.DemoConfigAspect.exception()",
            throwing = "re"
    )
    public void afterThrowing(JoinPoint joinPoint, RuntimeException re) {
        System.out.println(joinPoint.getSignature().toShortString());
        System.out.println(re.getMessage());
    }

    @Around("com.dark.mode.aop.DemoConfigAspect.fortuneService()")
    public Object aroundAdvice(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        String method = proceedingJoinPoint.getSignature().toShortString();
        logger.info(String.format("Executing method %s", method));

        long begin = System.currentTimeMillis();

        Object result = proceedingJoinPoint.proceed();

        long end = System.currentTimeMillis();

        long duration = end - begin;

        logger.info(String.format("Execution duration : %s seconds", duration / 1000.0));

        return result;
    }
}
