package com.virtualBank.investment.mutualFund.service;

import com.virtualBank.investment.mutualFund.domain.Transaction;

import java.util.List;

public interface TransactionService {
    public Transaction saveTransaction(Transaction transaction);
    public String deleteTransaction(Transaction transaction);
    public String updateTransaction(Transaction transaction);
    public Transaction findByOrderReferenceNumber(int orderReferenceNumber);
    public List<Transaction> findByCustomerNo(String CustomerNo);
}
