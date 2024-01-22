package com.nhnacademy.edu.springboot.account;

import java.util.List;
import org.springframework.stereotype.Component;

@Component
public class DummyAccountRepository implements AccountRepository{
    @Override
    public List<Account> findAll() {
        return List.of(new Account("100", 10000), new Account("101", 20000));
    }
}
