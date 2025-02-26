package com.avanade.demo.domain.service;

import com.avanade.demo.application.dto.AccountDTO;
import com.avanade.demo.application.dto.CreateAccountDTO;
import com.avanade.demo.application.port.input.CreateAccountUseCase;
import com.avanade.demo.application.port.output.AccountOutput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateAccountService implements CreateAccountUseCase {

    @Autowired
    private AccountOutput accountOutput;

    @Override
    public AccountDTO createAccount(CreateAccountDTO account) {return accountOutput.createAccount(account);}
}