package com.dark.mode.aop;

import org.springframework.stereotype.Component;

@Component
public class AccountDAO {

    public void addAccount() {
        System.out.println(getClass() + " adding account");
    }

    public void addAccountAnother(String name, int age, boolean isFucked) {
        System.out.println(getClass() + " adding account another");
    }

    public void addAccountAnother(Person person) {
        System.out.println(getClass() + " " + person);
    }
}
