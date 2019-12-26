package com.virtualBank.investment.mutualFund.utils;

import com.virtualBank.investment.mutualFund.vo.Response;

public class Util {
    public static Response generateSuccessResponse(Object object){
        Response response = new Response();
        response.setResponseCode(0);
        response.setData(object);

        return  response;
    }
}
