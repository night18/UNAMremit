package com.wvuhci.unamremit.core;

/**
 * To restore the information of how to pay the remittance
 */

public class PaymentInfo {
    private int payMethod;
    private String routingNumber;
    private String accountNumber;
    private String addr1;
    private String addr2;
    private String city;
    private String state;
    private String zipCode;


    public int getPayMethod() {
        return payMethod;
    }

    /**
     * Set payment method
     * @param payMethod 0:bank account, 1:debit card, 2:credit card
     */
    public void setPayMethod(int payMethod) {
        this.payMethod = payMethod;
    }

    public String getRoutingNumber() {
        return routingNumber;
    }

    public void setRoutingNumber(String routingNumber) {
        this.routingNumber = routingNumber;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getAddr1() {
        return addr1;
    }

    public void setAddr1(String addr1) {
        this.addr1 = addr1;
    }

    public String getAddr2() {
        return addr2;
    }

    public void setAddr2(String addr2) {
        this.addr2 = addr2;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }
}
