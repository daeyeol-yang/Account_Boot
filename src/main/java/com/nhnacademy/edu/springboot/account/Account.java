package com.nhnacademy.edu.springboot.account;


import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode
public class Account {
    private  String number;
    private Integer balance;

    public Account(String number, Integer balance) {
        this.number = number;
        this.balance = balance;
    }
}
