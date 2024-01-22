package com.nhnacademy.edu.springboot.account;

import java.util.List;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Service
public class DefaultAccountService implements AccountService{

  private final AccountRepository accountRepository;

    public DefaultAccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public List<Account> getAccount() {
        return accountRepository.findAll();
    }
}
