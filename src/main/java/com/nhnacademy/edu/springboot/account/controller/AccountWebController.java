package com.nhnacademy.edu.springboot.account.controller;

import com.nhnacademy.edu.springboot.account.Account;
import com.nhnacademy.edu.springboot.account.AccountRepository;
import com.nhnacademy.edu.springboot.account.config.AccountVersionProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller

public class AccountWebController {



    @GetMapping("/web/accounts/{id}")
    public String getAccount(@PathVariable Long id, Model model){

        model.addAttribute("account", new Account(1L, 1000));

        return "account";
    }


}
