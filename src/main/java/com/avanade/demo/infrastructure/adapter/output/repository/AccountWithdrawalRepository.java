package com.avanade.demo.infrastructure.adapter.output.repository;

import com.avanade.demo.domain.model.Account;
import com.avanade.demo.domain.model.AccountWithdrawal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountWithdrawalRepository extends JpaRepository<AccountWithdrawal, Long> {

    List<AccountWithdrawal> findByAccount(Account account);

}
