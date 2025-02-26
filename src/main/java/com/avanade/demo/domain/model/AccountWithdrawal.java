package com.avanade.demo.domain.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "account_withdrawal")
public class AccountWithdrawal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Double amount;

    @ManyToOne
    @JoinColumn(name = "account_id", nullable = false)
    private Account account;

    @Column(name="withdrawal_date",nullable = false)
    private Date withdrawalDate;

    public AccountWithdrawal(){}

    public AccountWithdrawal(Double amount, Account account, Date withdrawalDate) {
        this.amount = amount;
        this.account = account;
        this.withdrawalDate = withdrawalDate;
    }

    public Long getId() {return id;}

    public Double getAmount() {return amount;}

    public void setAmount(Double amount) {this.amount = amount;}

    public Account getAccount() {return account;}

    public void setAccount(Account account) {this.account = account;}

    public Date getWithdrawalDate() {return withdrawalDate;}

    public void setWithdrawalDate(Date withdrawalDate) {this.withdrawalDate = withdrawalDate;}

}
