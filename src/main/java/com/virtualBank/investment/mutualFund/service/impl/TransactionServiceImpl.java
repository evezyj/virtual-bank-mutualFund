package com.virtualBank.investment.mutualFund.service.impl;

import com.virtualBank.investment.mutualFund.domain.Transaction;
import com.virtualBank.investment.mutualFund.repository.TransactionRepository;
import com.virtualBank.investment.mutualFund.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TransactionServiceImpl implements TransactionService {
    @Autowired
    TransactionRepository transactionRepository;

    public Transaction saveTransaction(Transaction transaction) {
        return transactionRepository.save(transaction);
    }

    public String deleteTransaction(Transaction transaction) {
        try {
            transactionRepository.delete(transaction);
            return "success";
        } catch (Exception e) {
            return "failure";
        }
    }

    public String updateTransaction(Transaction transaction) {
        int quantity = transaction.getQuantity();
        int orderReferenceNo = transaction.getOrderReferenceNumber();
        int rowNumber = transactionRepository.updateTransaction(quantity, orderReferenceNo);
        System.out.println("--------" + rowNumber + "--------");
        return "success";
    }

    @Override
    public Transaction findByOrderReferenceNumber(int orderReferenceNumber) {
        return transactionRepository.findByOrderReferenceNumber(orderReferenceNumber);
    }

    public List<Transaction> findByCustomerNo(String CustomerNo) {
        return transactionRepository.findByCustomerNo(CustomerNo);
    }
}
