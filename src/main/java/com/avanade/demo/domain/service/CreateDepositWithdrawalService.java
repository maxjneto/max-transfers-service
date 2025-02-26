package com.avanade.demo.domain.service;

import com.avanade.demo.application.dto.AccountDepositDTO;
import com.avanade.demo.application.dto.AccountWithdrawalDTO;
import com.avanade.demo.application.dto.DepositOrWithdrawalDTO;
import com.avanade.demo.application.port.input.CreateDepositWithdrawalUseCase;
import com.avanade.demo.application.port.output.DepositWithdrawalOutput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateDepositWithdrawalService implements CreateDepositWithdrawalUseCase {

    @Autowired
    private DepositWithdrawalOutput depositWithdrawalOutput;

    @Override
    public AccountWithdrawalDTO createAccountWithdrawal(DepositOrWithdrawalDTO withdrawal) {
        return depositWithdrawalOutput.createAccountWithdrawal(withdrawal);
    }

    @Override
    public AccountDepositDTO createAccountDeposit(DepositOrWithdrawalDTO deposit) {
        return depositWithdrawalOutput.createAccountDeposit(deposit);
    }
}
