package com.avanade.demo.application.dto;

import java.util.Date;

public record CreateTransferDTO(String senderAccountNumber, String senderAccountPassword, String receiverAccountNumber, Double amount,
                                String transferType) {
}
