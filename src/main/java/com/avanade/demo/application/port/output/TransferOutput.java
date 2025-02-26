package com.avanade.demo.application.port.output;

import com.avanade.demo.application.dto.TransferDTO;
import com.avanade.demo.application.dto.CreateTransferDTO;

import java.util.List;

public interface TransferOutput {

    List<TransferDTO> listAllTransfersByAccountId(Long id);

    List<TransferDTO> listSentTransfersByAccountId(Long id);

    List<TransferDTO> listReceivedTransfersByAccountId(Long id);

    TransferDTO createTransfer(CreateTransferDTO transfer);

}
