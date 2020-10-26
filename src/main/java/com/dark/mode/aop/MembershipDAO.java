package com.dark.mode.aop;

import org.springframework.stereotype.Component;

@Component
public class MembershipDAO {

    public void addMembership() {
        System.out.println(getClass() + " adding account");
    }
}
