package com.avanade.demo.infrastructure.adapter.output.repository;

import com.avanade.demo.domain.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {

    Optional<Account> findByAccountNumber(String accountNumber);
    Optional<Account> findByAccountNumberAndAccountPassword(String accountNumber,String accountPassword);
    List<Account> findByCustomerId(Long customerId);

}