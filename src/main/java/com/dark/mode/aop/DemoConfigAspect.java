package com.dark.mode.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class DemoConfigAspect {
    @Pointcut("execution(public void com.dark.mode.aop.*.add*(..))")
    public void logAddedAccount() {
    }

    @Pointcut("execution(public * com.dark.mode.aop.*.find*())")
    public void findAdvice() {
    }
}
