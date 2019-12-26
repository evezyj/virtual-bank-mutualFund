package com.virtualBank.investment.mutualFund.repository;

import com.virtualBank.investment.mutualFund.domain.Transaction;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;
import java.util.List;

public interface TransactionRepository extends CrudRepository<Transaction, String> {

    @Modifying
    @Transactional
    @Query("update Transaction t set t.quantity = ?1 where t.orderReferenceNumber = ?2")
    public int updateTransaction(int quantity, int orderReferenceNumber);

    public Transaction findByOrderReferenceNumber(int orderReferenceNumber);

    public List<Transaction> findByCustomerNo(String CustomerNo);
}
