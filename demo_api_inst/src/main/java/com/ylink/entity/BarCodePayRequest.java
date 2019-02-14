package com.ylink.entity;

/**
 * Created by Yang on 2017-6-30.
 */
public class BarCodePayRequest extends PayBasicRequest{
	private static final long serialVersionUID = 1L;
	
    private String authCode;

    public String getAuthCode() {
        return authCode;
    }

    public void setAuthCode(String authCode) {
        this.authCode = authCode;
    }

    @Override
    public String toString() {
        return "BarCodePayRequest{" +
                "authCode='" + authCode + '\'' +
                ", merchantAccessNo='" + merchantAccessNo + '\'' +
                ", orderNo='" + orderNo + '\'' +
                ", orderAmt='" + orderAmt + '\'' +
                ", subject='" + subject + '\'' +
                ", orderDesc='" + orderDesc + '\'' +
                ", currency='" + currency + '\'' +
                ", storeNo='" + storeNo + '\'' +
                ", terminalNo='" + terminalNo + '\'' +
                ", employeeNo='" + employeeNo + '\'' +
                ", bgRetUrl='" + bgRetUrl + '\'' +
                ", remark='" + remark + '\'' +
                '}';
    }
}
