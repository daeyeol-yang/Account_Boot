package com.nhnacademy.edu.springboot.account.controller;

import com.nhnacademy.edu.springboot.account.config.AccountVersionProperties;
import com.nhnacademy.edu.springboot.account.model.VersionResposnse;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.system.SystemProperties;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class SystemController {

    private final AccountVersionProperties accountVersionProperties;

    @GetMapping("/system/version")
    public String getSystemVersion(){
    return accountVersionProperties.getVersion();
    }
}
