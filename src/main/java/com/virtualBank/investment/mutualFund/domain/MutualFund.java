package com.virtualBank.investment.mutualFund.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "mutualFund")
public class MutualFund {
    @Id
    private String code;
    private String fundCurrency;
    private String fundName;
    private String fundType;
    private String unitPrice;
    private String riskLevel;

    @ManyToOne
    private MutualFundHouse fundHouse;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getFundCurrency() {
        return fundCurrency;
    }

    public void setFundCurrency(String fundCurrency) {
        this.fundCurrency = fundCurrency;
    }

    public String getFundName() {
        return fundName;
    }

    public void setFundName(String fundName) {
        this.fundName = fundName;
    }

    public String getFundType() {
        return fundType;
    }

    public void setFundType(String fundType) {
        this.fundType = fundType;
    }

    public String getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(String unitPrice) {
        this.unitPrice = unitPrice;
    }

    public String getRiskLevel() {
        return riskLevel;
    }

    public void setRiskLevel(String riskLevel) {
        this.riskLevel = riskLevel;
    }

    public MutualFundHouse getFundHouse() {
        return fundHouse;
    }

    public void setFundHouse(MutualFundHouse fundHouse) {
        this.fundHouse = fundHouse;
    }
}
