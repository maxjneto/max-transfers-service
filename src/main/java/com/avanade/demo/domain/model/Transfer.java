package com.avanade.demo.domain.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "transfer")
public class Transfer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "sender_id", nullable = false)
    private Account sender;

    @ManyToOne
    @JoinColumn(name = "receiver_id", nullable = false)
    private Account receiver;

    @Column(nullable = false)
    private Double amount;

    @Column(name="transfer_date",nullable = false)
    private Date transferDate;

    @ManyToOne
    @JoinColumn(name = "transfer_type_id", nullable = false)
    private TransferType transferType;

    public Transfer(){}

    public Transfer(Account sender, Account receiver, Double amount, Date transferDate, TransferType transferType) {
        this.sender = sender;
        this.receiver = receiver;
        this.amount = amount;
        this.transferDate = transferDate;
        this.transferType = transferType;
    }

    public Long getId() {
        return id;
    }

    public Account getSender() {return sender;}

    public void setSender(Account sender) {this.sender = sender;}

    public Account getReceiver() {return receiver;}

    public void setReceiver(Account receiver) {this.receiver = receiver;}

    public Double getAmount() {return amount;}

    public void setAmount(Double amount) {this.amount = amount;}

    public Date getTransferDate() {return transferDate;}

    public void setTransferDate(Date transferDate) {this.transferDate = transferDate;}

    public TransferType getTransferType() {return transferType;}

    public void setTransferType(TransferType transferType) {this.transferType = transferType;}
}