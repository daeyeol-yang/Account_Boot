package com.nhnacademy.edu.springboot.account;

import java.util.List;

public interface AccountRepository {
    List<Account> findAll();
}
