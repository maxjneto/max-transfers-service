package com.avanade.demo.infrastructure.adapter.output;

import com.avanade.demo.application.dto.*;
import com.avanade.demo.application.port.output.DepositWithdrawalOutput;
import com.avanade.demo.domain.exception.EntityNotFoundException;
import com.avanade.demo.domain.exception.InsufficientBalanceValueException;
import com.avanade.demo.domain.model.Account;
import com.avanade.demo.domain.model.AccountDeposit;
import com.avanade.demo.domain.model.AccountWithdrawal;
import com.avanade.demo.infrastructure.adapter.output.repository.AccountDepositRepository;
import com.avanade.demo.infrastructure.adapter.output.repository.AccountRepository;
import com.avanade.demo.infrastructure.adapter.output.repository.AccountWithdrawalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
public class DepositWithdrawalPersistenceAdapter implements DepositWithdrawalOutput {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private AccountDepositRepository accountDepositRepository;

    @Autowired
    private AccountWithdrawalRepository accountWithdrawalRepository;

    @Override
    public AccountWithdrawalDTO createAccountWithdrawal(DepositOrWithdrawalDTO withdrawal) {
        final Account account = accountRepository.findByAccountNumberAndAccountPassword(withdrawal.accountNumber(),
                        withdrawal.accountPassword()).orElseThrow(() ->
                new EntityNotFoundException("Credenciais inválidas"));

        if(account.getBalance() >= withdrawal.amount()) {
            account.setBalance(account.getBalance() - withdrawal.amount());
            accountRepository.save(account);

            final AccountWithdrawal withd = accountWithdrawalRepository.save(new AccountWithdrawal
                    (withdrawal.amount(),account,new Date()));

            return toAccountWithdrawalDTO(withd);
        }else{
            throw new InsufficientBalanceValueException("Saldo insuficiente");
        }
    }

    @Override
    public AccountDepositDTO createAccountDeposit(DepositOrWithdrawalDTO deposit) {
        final Account account = accountRepository.findByAccountNumberAndAccountPassword(deposit.accountNumber(),
                deposit.accountPassword()).orElseThrow(() ->
                new EntityNotFoundException("Credenciais inválidas"));

        account.setBalance(account.getBalance() + deposit.amount());
        accountRepository.save(account);

        final AccountDeposit depo = accountDepositRepository.save(new AccountDeposit
                (deposit.amount(),account,new Date()));

        return toAccountDepositDTO(depo);
    }

    @Override
    public List<AccountWithdrawalDTO> listWithdrawalsByAccountNumber(String accountNumber) {
        final Account account = accountRepository.findByAccountNumber(accountNumber).orElseThrow(()
                -> new EntityNotFoundException("Credenciais inválidas"));

        List<AccountWithdrawal> withdrawals = accountWithdrawalRepository.findByAccount(account);

        return withdrawals.stream().map(this::toAccountWithdrawalDTO).toList();
    }

    @Override
    public List<AccountDepositDTO> listDepositsByAccountNumber(String accountNumber) {
        final Account account = accountRepository.findByAccountNumber(accountNumber).orElseThrow(()
                -> new EntityNotFoundException("Credenciais inválidas"));

        List<AccountDeposit> deposits = accountDepositRepository.findByAccount(account);

        return deposits.stream().map(this::toAccountDepositDTO).toList();
    }

    private AccountDepositDTO toAccountDepositDTO(AccountDeposit deposit){
        return new AccountDepositDTO(deposit.getAmount(),deposit.getDepositDate());
    }

    private AccountWithdrawalDTO toAccountWithdrawalDTO(AccountWithdrawal withdrawal){
        return new AccountWithdrawalDTO(withdrawal.getAmount(),withdrawal.getWithdrawalDate());
    }


}
