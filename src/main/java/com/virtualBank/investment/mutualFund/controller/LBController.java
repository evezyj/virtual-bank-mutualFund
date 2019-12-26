package com.virtualBank.investment.mutualFund.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LBController {
    @GetMapping(value = "/")
    public String getServerName() {
       return "This is server: i-011dfec1261a849a4";
    }
}
