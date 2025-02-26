package com.avanade.demo.application.port.input;

import com.avanade.demo.application.dto.AccountDTO;

import java.util.List;

public interface GetAccountUseCase {

    List<AccountDTO> listAccountsByCustomerId(Long id);

    AccountDTO getAccountByNumber(String accountNumber);

}