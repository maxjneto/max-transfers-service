package com.avanade.demo.infrastructure.adapter.output;

import com.avanade.demo.application.dto.AccountDTO;
import com.avanade.demo.application.dto.CreateAccountDTO;
import com.avanade.demo.application.port.output.AccountOutput;
import com.avanade.demo.domain.exception.EntityNotFoundException;
import com.avanade.demo.domain.model.Account;
import com.avanade.demo.infrastructure.adapter.output.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class AccountPersistenceAdapter implements AccountOutput {

    @Autowired
    private AccountRepository accountRepository;

    @Override
    public AccountDTO getAccountByNumber(String accountNumber) {
        final Account acc = accountRepository.findByAccountNumber(accountNumber).orElseThrow(() ->
                new EntityNotFoundException("Conta não encontrada"));

        return toAccountDTO(acc);
    }

    @Override
    public AccountDTO createAccount(CreateAccountDTO account) {
        final Account acc = accountRepository.save(new Account(account.customerId(),account.accountNumber(),
                account.accountPassword(),0d));

        return toAccountDTO(acc);
    }

    @Override
    public List<AccountDTO> listAccountsByCustomerId(Long id) {
        List<Account> accounts = accountRepository.findByCustomerId(id);

        return accounts.stream().map(this::toAccountDTO).toList();
    }

    private AccountDTO toAccountDTO(Account account){
        return new AccountDTO(account.getId(),account.getCustomerId(),account.getAccountNumber(),
                account.getBalance());
    }

}