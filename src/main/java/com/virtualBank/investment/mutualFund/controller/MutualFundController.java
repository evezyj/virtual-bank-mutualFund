package com.virtualBank.investment.mutualFund.controller;

import com.mysql.cj.x.protobuf.MysqlxDatatypes;
import com.virtualBank.investment.mutualFund.domain.MutualFund;
import com.virtualBank.investment.mutualFund.domain.Transaction;
import com.virtualBank.investment.mutualFund.service.MutualFundService;
import com.virtualBank.investment.mutualFund.service.TransactionService;
import com.virtualBank.investment.mutualFund.utils.Util;
import com.virtualBank.investment.mutualFund.vo.MutualFundHolding;
import com.virtualBank.investment.mutualFund.vo.Response;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/private/v1/investments/mutualFunds")
@CrossOrigin
public class MutualFundController {
    @Autowired
    MutualFundService mutualFundService;

    @Autowired
    TransactionService transactionService;

    @ApiOperation("This is searching all mutualFunds.")
    @GetMapping(value = "/search")
    public Response searchMutualFunds() {
        List<MutualFund> mutualFunds = mutualFundService.getAllMutualFunds();
        Response response = Util.generateSuccessResponse(mutualFunds);
        return response;
    }

    @ApiOperation("This is searching mutualFund holdings by customer.")
    @GetMapping(value = "/{customerNo}/holdings")
    public Response searchCustomerHoldings(@PathVariable String customerNo) {
        List<Transaction> mutualFundHoldings = transactionService.findByCustomerNo(customerNo);
        Response response = Util.generateSuccessResponse(mutualFundHoldings);
        return response;
    }

    @ApiOperation("This api is used to buy a mutual fund.")
    @PostMapping(value = "/buy")
    public Response buyMutualFund(@RequestBody Transaction transaction) {
        int orderReferenceNumber = transaction.getOrderReferenceNumber();
        if (orderReferenceNumber != 0) {
            Transaction originTransaction = transactionService.findByOrderReferenceNumber(orderReferenceNumber);
            if(originTransaction!=null) {
                int originQuantity = originTransaction.getQuantity();
                int newQuantity = originQuantity + transaction.getQuantity();
                transaction.setQuantity(newQuantity);
            }
        }

        Transaction newTransaction = transactionService.saveTransaction(transaction);
        Response response = Util.generateSuccessResponse(newTransaction.getOrderReferenceNumber());
        return response;
    }

    @ApiOperation("This api is used to sell a mutual fund.")
    @PostMapping(value = "/sell")
    public Response sellMutualFund(@RequestBody Transaction transaction) {
        System.out.println("------- Entering sellMutualFund ------");
        int orderReferenceNumber = transaction.getOrderReferenceNumber();
        Transaction originTransaction = transactionService.findByOrderReferenceNumber(orderReferenceNumber);

        int originQuantity = originTransaction.getQuantity();
        int sellQuantity = transaction.getQuantity();
        int newQuantity = originQuantity - sellQuantity;
        if (newQuantity == 0) {
            transactionService.deleteTransaction(transaction);
        } else {
            transaction.setQuantity(newQuantity);
            transactionService.updateTransaction(transaction);
        }

        Response response = Util.generateSuccessResponse(orderReferenceNumber);
        return response;
    }
}
