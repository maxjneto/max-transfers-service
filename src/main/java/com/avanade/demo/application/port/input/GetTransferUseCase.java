package com.avanade.demo.application.port.input;

import com.avanade.demo.application.dto.TransferDTO;

import java.util.List;

public interface GetTransferUseCase {

    List<TransferDTO> listAllTransfersByAccountId(Long id);

    List<TransferDTO> listSentTransfersByAccountId(Long id);

    List<TransferDTO> listReceivedTransfersByAccountId(Long id);

}
