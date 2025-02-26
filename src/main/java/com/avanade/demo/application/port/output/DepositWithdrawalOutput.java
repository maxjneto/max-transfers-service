package com.avanade.demo.application.port.output;

import com.avanade.demo.application.dto.AccountDTO;
import com.avanade.demo.application.dto.AccountDepositDTO;
import com.avanade.demo.application.dto.AccountWithdrawalDTO;
import com.avanade.demo.application.dto.DepositOrWithdrawalDTO;

import java.util.List;

public interface DepositWithdrawalOutput {

    AccountWithdrawalDTO createAccountWithdrawal(DepositOrWithdrawalDTO withdrawal);

    AccountDepositDTO createAccountDeposit(DepositOrWithdrawalDTO deposit);

    List<AccountWithdrawalDTO> listWithdrawalsByAccountNumber(String accountNumber);

    List<AccountDepositDTO> listDepositsByAccountNumber(String accountNumber);

}
