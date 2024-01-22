package com.nhnacademy.edu.springboot.account;



import java.util.Optional;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
class AccountRepositoryTest {

    @Autowired
    AccountRepository accountRepository;

    @Test
    void testAccountRepository(){

        Account account = new Account(100L,10000);
        accountRepository.save(account);

        Optional<Account> actual = accountRepository.findById(100L);


        Assertions.assertThat(actual).isPresent();
        Assertions.assertThat(actual.get()).isEqualTo(account);
    }

}