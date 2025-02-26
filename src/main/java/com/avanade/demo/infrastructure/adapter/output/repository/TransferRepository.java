package com.avanade.demo.infrastructure.adapter.output.repository;

import com.avanade.demo.domain.model.Transfer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransferRepository extends JpaRepository<Transfer, Long> {

    @Query("SELECT t from Transfer t where t.sender.id = :id OR t.receiver.id = :id")
    List<Transfer> findAllTransfersById(Long id);

    @Query("SELECT t from Transfer t where t.sender.id = :id")
    List<Transfer> findSentTransfersById(Long id);

    @Query("SELECT t from Transfer t where t.receiver.id = :id")
    List<Transfer> findReceivedTransfersById(Long id);

}