package com.avanade.demo.domain.service;

import com.avanade.demo.application.dto.CreateTransferDTO;
import com.avanade.demo.application.dto.TransferDTO;
import com.avanade.demo.application.port.input.CreateTransferUseCase;
import com.avanade.demo.application.port.output.TransferOutput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateTransferService implements CreateTransferUseCase {

    @Autowired
    private TransferOutput transferOutput;

    @Override
    public TransferDTO createTransfer(CreateTransferDTO transfer) {return transferOutput.createTransfer(transfer);}
}
