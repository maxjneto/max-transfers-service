package com.avanade.demo.infrastructure.adapter.output;

import com.avanade.demo.application.dto.CreateTransferDTO;
import com.avanade.demo.application.dto.SimpleAccountDTO;
import com.avanade.demo.application.dto.TransferDTO;
import com.avanade.demo.application.port.output.TransferOutput;
import com.avanade.demo.domain.exception.EntityNotFoundException;
import com.avanade.demo.domain.exception.InsufficientBalanceValueException;
import com.avanade.demo.domain.model.Account;
import com.avanade.demo.domain.model.AccountWithdrawal;
import com.avanade.demo.domain.model.Transfer;
import com.avanade.demo.domain.model.TransferType;
import com.avanade.demo.infrastructure.adapter.output.repository.AccountRepository;
import com.avanade.demo.infrastructure.adapter.output.repository.TransferRepository;
import com.avanade.demo.infrastructure.adapter.output.repository.TransferTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

@Component
public class TransferPersistenceAdapter implements TransferOutput {

    @Autowired
    private TransferRepository transferRepository;

    @Autowired
    private TransferTypeRepository transferTypeRepository;

    @Autowired
    private AccountRepository accountRepository;

    @Override
    public List<TransferDTO> listAllTransfersByAccountId(Long id) {
        List<Transfer> transfers = transferRepository.findAllTransfersById(id);
        return transfers.stream().map(this::toTransferDTO).toList();
    }

    @Override
    public List<TransferDTO> listSentTransfersByAccountId(Long id) {
        List<Transfer> transfers = transferRepository.findSentTransfersById(id);
        return transfers.stream().map(this::toTransferDTO).toList();
    }

    @Override
    public List<TransferDTO> listReceivedTransfersByAccountId(Long id) {
        List<Transfer> transfers = transferRepository.findReceivedTransfersById(id);
        return transfers.stream().map(this::toTransferDTO).toList();
    }

    @Override
    public TransferDTO createTransfer(CreateTransferDTO transfer) {
        TransferType transferType = transferTypeRepository.findByName(transfer.transferType()).orElseThrow(() ->
                new EntityNotFoundException("Tipo de transferencia inválido."));

        Account sender = accountRepository.findByAccountNumberAndAccountPassword(transfer.senderAccountNumber(),
                transfer.senderAccountPassword()).orElseThrow(() -> new EntityNotFoundException("Credenciais inválidas"));

        Account receiver = accountRepository.findByAccountNumber(transfer.receiverAccountNumber()).orElseThrow(() ->
                new EntityNotFoundException("Conta de destino não encontrada"));

        if(sender.getBalance() >= transfer.amount()){
            sender.setBalance(sender.getBalance() - transfer.amount());
            accountRepository.save(sender);

            receiver.setBalance(receiver.getBalance() + transfer.amount());
            accountRepository.save(receiver);

            final Transfer tran = transferRepository.save(new Transfer(sender,receiver,transfer.amount(),new Date(),transferType));

            return toTransferDTO(tran);
        }else{
            throw new InsufficientBalanceValueException("Saldo insuficiente");
        }
    }

    private TransferDTO toTransferDTO(Transfer transfer){
        return new TransferDTO(transfer.getTransferDate(), toSimpleAccountDTO(transfer.getSender()),
                toSimpleAccountDTO(transfer.getReceiver()), transfer.getAmount(), transfer.getTransferType().getName());
    }

    private SimpleAccountDTO toSimpleAccountDTO(Account account){
        return new SimpleAccountDTO(account.getId(), account.getAccountNumber());
    }

}
