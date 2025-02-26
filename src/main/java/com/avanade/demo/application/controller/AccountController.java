package com.avanade.demo.application.controller;

import com.avanade.demo.application.dto.AccountDTO;
import com.avanade.demo.application.dto.CreateAccountDTO;
import com.avanade.demo.application.dto.CreateTransferDTO;
import com.avanade.demo.application.dto.TransferDTO;
import com.avanade.demo.domain.service.CreateAccountService;
import com.avanade.demo.domain.service.GetAccountService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AccountController {

    private static final Logger logger = LogManager.getLogger(AccountController.class);

    @Autowired
    private CreateAccountService createAccountService;

    @Autowired
    private GetAccountService getAccountService;

    @PostMapping("/account")
    public AccountDTO createAccount(@RequestBody @Validated CreateAccountDTO account) {
        AccountDTO createdTransfer = createAccountService.createAccount(account);
        logger.info("Created account with number: " + account.accountNumber());
        return createdTransfer;
    }

    @GetMapping("/account/{id}")
    public List<AccountDTO> listAccountsByCustomerId(@PathVariable long id) {
        List<AccountDTO> accounts = getAccountService.listAccountsByCustomerId(id);
        logger.info("Found all accounts from customer with id: " + id);
        return accounts;
    }

    @GetMapping("/account/number/{accountNumber}")
    public AccountDTO getAccountByNumber(@PathVariable String accountNumber) {
        AccountDTO account = getAccountService.getAccountByNumber(accountNumber);
        logger.info("Found all sent transfers from customer with account number: " + accountNumber);
        return account;
    }
}
