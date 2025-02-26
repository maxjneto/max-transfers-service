package com.avanade.demo.application.port.input;

import com.avanade.demo.application.dto.CreateTransferDTO;
import com.avanade.demo.application.dto.TransferDTO;

public interface CreateTransferUseCase {

    TransferDTO createTransfer(CreateTransferDTO transfer);

}
