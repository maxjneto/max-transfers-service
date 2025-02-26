package com.avanade.demo.domain.service;

import com.avanade.demo.application.dto.AccountDepositDTO;
import com.avanade.demo.application.dto.AccountWithdrawalDTO;
import com.avanade.demo.application.port.input.GetDepositWithdrawalUseCase;
import com.avanade.demo.application.port.output.DepositWithdrawalOutput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetDepositWithdrawalService implements GetDepositWithdrawalUseCase {

    @Autowired
    private DepositWithdrawalOutput depositWithdrawalOutput;

    @Override
    public List<AccountWithdrawalDTO> listWithdrawalsByAccountNumber(String accountNumber) {
        return depositWithdrawalOutput.listWithdrawalsByAccountNumber(accountNumber);
    }

    @Override
    public List<AccountDepositDTO> listDepositsByAccountNumber(String accountNumber) {
        return depositWithdrawalOutput.listDepositsByAccountNumber(accountNumber);
    }

}
