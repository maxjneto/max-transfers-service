package com.avanade.demo.domain.service;

import com.avanade.demo.application.dto.TransferDTO;
import com.avanade.demo.application.port.input.GetTransferUseCase;
import com.avanade.demo.application.port.output.TransferOutput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetTransferService implements GetTransferUseCase {

    @Autowired
    private TransferOutput transferOutput;

    @Override
    public List<TransferDTO> listAllTransfersByAccountId(Long id) {
        return transferOutput.listAllTransfersByAccountId(id);
    }

    @Override
    public List<TransferDTO> listSentTransfersByAccountId(Long id) {
        return transferOutput.listSentTransfersByAccountId(id);
    }

    @Override
    public List<TransferDTO> listReceivedTransfersByAccountId(Long id) {
        return transferOutput.listReceivedTransfersByAccountId(id);
    }
}
