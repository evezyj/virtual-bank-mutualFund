package com.virtualBank.investment.mutualFund.service.impl;

import com.virtualBank.investment.mutualFund.domain.MutualFund;
import com.virtualBank.investment.mutualFund.repository.MutualFundRepository;
import com.virtualBank.investment.mutualFund.service.MutualFundService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class MutualFundServiceImpl implements MutualFundService {
    @Autowired
    MutualFundRepository mutualFundRepository;

    @Override
    public ArrayList<MutualFund> getAllMutualFunds() {
        ArrayList<MutualFund> mutualFunds = (ArrayList<MutualFund>) mutualFundRepository.findAll();
        return mutualFunds;
    }
}
