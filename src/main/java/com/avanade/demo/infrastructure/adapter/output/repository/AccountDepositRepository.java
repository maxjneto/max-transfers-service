package com.avanade.demo.infrastructure.adapter.output.repository;

import com.avanade.demo.domain.model.Account;
import com.avanade.demo.domain.model.AccountDeposit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountDepositRepository extends JpaRepository<AccountDeposit, Long> {

    List<AccountDeposit> findByAccount(Account account);

}
