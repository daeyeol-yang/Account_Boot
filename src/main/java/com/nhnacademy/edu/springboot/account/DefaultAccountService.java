package com.nhnacademy.edu.springboot.account;

import java.util.List;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DefaultAccountService implements AccountService{

  private final AccountRepository accountRepository;

    public DefaultAccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }


    @Override
    @Transactional(readOnly=true)
    public List<Account> getAccounts() {
        return accountRepository.findAll();
    }

    @Override
    @Transactional()
    public Account createAccount(Account account) {
        boolean present = accountRepository.findById(account.getNumber()).isPresent();
        if(present){
            throw new IllegalStateException("Aleady exist");
        }
        return accountRepository.save(account);
    }

    @Override
    @Transactional(readOnly=true)
    public Account getAcount(Long id) {
        return accountRepository.findById(id).orElseThrow();
    }

    @Override
    @Transactional(readOnly=true)
    public void deleteAccount(Long id) {
        accountRepository.deleteById(id);
    }
}
