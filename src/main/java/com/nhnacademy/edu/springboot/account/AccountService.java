package com.nhnacademy.edu.springboot.account;

import java.util.List;

public interface AccountService {
    List<Account> getAccounts();

    Account createAccount(Account account);

    Account getAcount(Long id);

    void deleteAccount(Long id);
}
