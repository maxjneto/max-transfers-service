package com.avanade.demo.application.controller;

import com.avanade.demo.application.dto.CreateTransferDTO;
import com.avanade.demo.application.dto.TransferDTO;
import com.avanade.demo.domain.service.CreateTransferService;
import com.avanade.demo.domain.service.GetTransferService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TransferController {

    private static final Logger logger = LogManager.getLogger(TransferController.class);

    @Autowired
    private CreateTransferService createTransferService;

    @Autowired
    private GetTransferService getTransferService;

    @PostMapping("/transfer")
    public TransferDTO createCustomer(@RequestBody @Validated CreateTransferDTO transfer) {
        TransferDTO createdTransfer = createTransferService.createTransfer(transfer);
        logger.info("Created transfer with value: " + transfer.amount() +
                " from " + transfer.senderAccountNumber() + " to " + transfer.receiverAccountNumber());
        return createdTransfer;
    }

    @GetMapping("/transfer/all/{id}")
    public List<TransferDTO> listAllTransfersByAccountId(@PathVariable long id) {
        List<TransferDTO> transfers = getTransferService.listAllTransfersByAccountId(id);
        logger.info("Found all transfers from customer with id: " + id);
        return transfers;
    }

    @GetMapping("/transfer/sent/{id}")
    public List<TransferDTO> listSentTransfersByAccountId(@PathVariable long id) {
        List<TransferDTO> transfers = getTransferService.listSentTransfersByAccountId(id);
        logger.info("Found all sent transfers from customer with id: " + id);
        return transfers;
    }

    @GetMapping("/transfer/received/{id}")
    public List<TransferDTO> listReceivedTransfersByAccountId(@PathVariable long id) {
        List<TransferDTO> transfers = getTransferService.listReceivedTransfersByAccountId(id);
        logger.info("Found all received transfers from customer with id: " + id);
        return transfers;
    }

}