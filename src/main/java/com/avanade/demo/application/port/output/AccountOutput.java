package com.avanade.demo.application.port.output;

import com.avanade.demo.application.dto.AccountDTO;
import com.avanade.demo.application.dto.CreateAccountDTO;

import java.util.List;

public interface AccountOutput {

    List<AccountDTO> listAccountsByCustomerId(Long id);

    AccountDTO getAccountByNumber(String accountNumber);

    AccountDTO createAccount(CreateAccountDTO account);

}
