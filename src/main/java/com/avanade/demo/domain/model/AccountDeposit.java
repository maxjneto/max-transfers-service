package com.avanade.demo.domain.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "account_deposit")
public class AccountDeposit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Double amount;

    @ManyToOne
    @JoinColumn(name = "account_id", nullable = false)
    private Account account;

    @Column(name="deposit_date",nullable = false)
    private Date depositDate;

    public AccountDeposit(){}

    public AccountDeposit(Double amount, Account account, Date depositDate) {
        this.amount = amount;
        this.account = account;
        this.depositDate = depositDate;
    }

    public Long getId() {return id;}

    public Double getAmount() {return amount;}

    public void setAmount(Double amount) {this.amount = amount;}

    public Account getAccount() {return account;}

    public void setAccount(Account account) {this.account = account;}

    public Date getDepositDate() {return depositDate;}

    public void setDepositDate(Date depositDate) {this.depositDate = depositDate;}
}
