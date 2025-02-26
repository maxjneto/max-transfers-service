package com.avanade.demo.application.port.input;

import com.avanade.demo.application.dto.AccountDepositDTO;
import com.avanade.demo.application.dto.AccountWithdrawalDTO;
import com.avanade.demo.application.dto.DepositOrWithdrawalDTO;

import java.util.List;

public interface GetDepositWithdrawalUseCase {

    List<AccountWithdrawalDTO> listWithdrawalsByAccountNumber(String accountNumber);

    List<AccountDepositDTO> listDepositsByAccountNumber(String accountNumber);
}
