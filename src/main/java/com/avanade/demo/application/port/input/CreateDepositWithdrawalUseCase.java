package com.avanade.demo.application.port.input;

import com.avanade.demo.application.dto.AccountDepositDTO;
import com.avanade.demo.application.dto.AccountWithdrawalDTO;
import com.avanade.demo.application.dto.DepositOrWithdrawalDTO;

public interface CreateDepositWithdrawalUseCase {

    AccountWithdrawalDTO createAccountWithdrawal(DepositOrWithdrawalDTO withdrawal);

    AccountDepositDTO createAccountDeposit(DepositOrWithdrawalDTO deposit);

}
