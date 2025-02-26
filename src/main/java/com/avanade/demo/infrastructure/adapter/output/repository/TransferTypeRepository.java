package com.avanade.demo.infrastructure.adapter.output.repository;

import com.avanade.demo.domain.model.TransferType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TransferTypeRepository extends JpaRepository<TransferType, Long> {

    Optional<TransferType> findByName(String name);

}