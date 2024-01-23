package com.nhnacademy.edu.springboot.account;

import com.nhnacademy.edu.springboot.account.model.DeleteResoponse;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountController {
    private final AccountService accountService;



    public AccountController(AccountService accountService) {
        this.accountService = accountService;

    }




    @GetMapping("/accounts")
    public List<Account> getAccounts(){
        return accountService.getAccounts();
    }

    @GetMapping("/accounts/{id}")
    public Account getAccount(@PathVariable("id") Long id){
        return accountService.getAcount(id);
    }

    @PostMapping("/accounts")
    @ResponseStatus(HttpStatus.CREATED)
    public Account createAccount(@RequestBody Account account){
        return accountService.createAccount(account);
    }

    @DeleteMapping("/accounts/{id}")
    public DeleteResoponse deleteResoponse(@PathVariable("id") Long id){
        accountService.deleteAccount(id);
        return new DeleteResoponse("OK");
    }
}
