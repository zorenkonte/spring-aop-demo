package com.dark.mode.aop;

import org.springframework.stereotype.Component;

import java.util.List;

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

    public List<Person> findAccounts() {
        return List.of(
                new Person("Bringino", "Renzo"),
                new Person("Bringino", "Ralph"),
                new Person("Tamonan", "Hazel"),
                new Person("Dela Cruz", "Juan")
        );
    }
}
