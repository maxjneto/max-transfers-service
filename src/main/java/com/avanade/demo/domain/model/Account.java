package com.avanade.demo.domain.model;

import jakarta.persistence.*;

@Entity
@Table(name = "account")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="customer_id",nullable = false)
    private Long customerId;

    @Column(name="account_number",nullable = false)
    private String accountNumber;

    @Column(name="account_password",nullable = false)
    private String accountPassword;

    @Column(nullable = false)
    private Double balance;

    public Account(){}

    public Account(Long customerId, String accountNumber, String accountPassword, Double balance) {
        this.customerId = customerId;
        this.accountNumber = accountNumber;
        this.accountPassword = accountPassword;
        this.balance = balance;
    }

    public Long getId() {return id;}

    public Long getCustomerId() {return customerId;}

    public void setCustomerId(Long customerId) {this.customerId = customerId;}

    public String getAccountNumber() {return accountNumber;}

    public void setAccountNumber(String accountNumber) {this.accountNumber = accountNumber;}

    public String getAccountPassword() {return accountPassword;}

    public void setAccountPassword(String accountPassword) {this.accountPassword = accountPassword;}

    public Double getBalance() {return balance;}

    public void setBalance(Double balance) {this.balance = balance;}

}