package com.avanade.demo.application.controller;

import com.avanade.demo.application.dto.AccountWithdrawalDTO;
import com.avanade.demo.application.dto.CreateTransferDTO;
import com.avanade.demo.application.dto.DepositOrWithdrawalDTO;
import com.avanade.demo.application.dto.TransferDTO;
import com.avanade.demo.domain.service.GetDepositWithdrawalService;
import com.avanade.demo.domain.service.CreateDepositWithdrawalService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class WithdrawalController {

    private static final Logger logger = LogManager.getLogger(WithdrawalController.class);

    @Autowired
    private CreateDepositWithdrawalService createDepositWithdrawalService;

    @Autowired
    private GetDepositWithdrawalService getDepositWithdrawalService;

    @PostMapping("/withdrawal")
    public AccountWithdrawalDTO createAccountWithdrawal(@RequestBody @Validated DepositOrWithdrawalDTO withdrawal) {
        AccountWithdrawalDTO createdWithdrawal = createDepositWithdrawalService.createAccountWithdrawal(withdrawal);
        logger.info("Created withdrawal with value: " + withdrawal.amount() + " from " + withdrawal.accountNumber());
        return createdWithdrawal;
    }

    @GetMapping("/withdrawal/{accountNumber}")
    public List<AccountWithdrawalDTO> listWithdrawalsByAccountNumber(@PathVariable String accountNumber) {
        List<AccountWithdrawalDTO> withdrawals = getDepositWithdrawalService.listWithdrawalsByAccountNumber(accountNumber);
        logger.info("Found all transfers from customer with account number: " + accountNumber);
        return withdrawals;
    }

}
