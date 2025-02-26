package com.avanade.demo.application.port.input;

import com.avanade.demo.application.dto.AccountDTO;
import com.avanade.demo.application.dto.CreateAccountDTO;

public interface CreateAccountUseCase {

    AccountDTO createAccount(CreateAccountDTO account);

}
