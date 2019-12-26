package com.virtualBank.investment.mutualFund.constant;

import ch.qos.logback.core.net.SyslogOutputStream;

public class Test {
    public static void main(String[] args) {
        String prefix = "0000000" + "789";
        String orderReferenceNumber = prefix.substring(prefix.length() - 7);
        System.out.println(orderReferenceNumber);
    }
}
