package com.avanade.demo.domain.service;

import com.avanade.demo.application.dto.AccountDTO;
import com.avanade.demo.application.port.input.GetAccountUseCase;
import com.avanade.demo.application.port.output.AccountOutput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetAccountService implements GetAccountUseCase {

    @Autowired
    private AccountOutput accountOutput;


    @Override
    public List<AccountDTO> listAccountsByCustomerId(Long id) {return accountOutput.listAccountsByCustomerId(id);}

    @Override
    public AccountDTO getAccountByNumber(String accountNumber) {return accountOutput.getAccountByNumber(accountNumber);}
}
