package com.avanade.demo.application.controller;

import com.avanade.demo.application.dto.AccountDepositDTO;
import com.avanade.demo.application.dto.AccountWithdrawalDTO;
import com.avanade.demo.application.dto.DepositOrWithdrawalDTO;
import com.avanade.demo.domain.service.CreateDepositWithdrawalService;
import com.avanade.demo.domain.service.GetDepositWithdrawalService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DepositController {

    private static final Logger logger = LogManager.getLogger(DepositController.class);

    @Autowired
    private CreateDepositWithdrawalService createDepositWithdrawalService;

    @Autowired
    private GetDepositWithdrawalService getDepositWithdrawalService;

    @PostMapping("/deposit")
    public AccountDepositDTO createAccountDeposit(@RequestBody @Validated DepositOrWithdrawalDTO deposit) {
        AccountDepositDTO createdDeposit = createDepositWithdrawalService.createAccountDeposit(deposit);
        logger.info("Created deposits with value: " + deposit.amount() + " from " + deposit.accountNumber());
        return createdDeposit;
    }

    @GetMapping("/deposit/{accountNumber}")
    public List<AccountDepositDTO> listDepositByAccountNumber(@PathVariable String accountNumber) {
        List<AccountDepositDTO> deposits = getDepositWithdrawalService.listDepositsByAccountNumber(accountNumber);
        logger.info("Found all deposits from customer with account number: " + accountNumber);
        return deposits;
    }

}
