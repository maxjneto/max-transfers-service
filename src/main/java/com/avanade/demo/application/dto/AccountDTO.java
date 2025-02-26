package com.avanade.demo.application.dto;

import java.util.List;

public record AccountDTO(Long id, Long customerId, String accountNumber, Double balance) {
}