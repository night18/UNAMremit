package com.wvuhci.unamremit.core;

/**
 * To restore the information of the transaction of one time
 */

public class TransactionInfo {
    private double usdAmount;
    private double exchangeRate;
    private double fee;
    private double mxnAmount;

    public double getUsdAmount() {
        return usdAmount;
    }

    public void setUsdAmount(double usdAmount) {
        this.usdAmount = usdAmount;
    }

    public double getExchangeRate() {
        return exchangeRate;
    }

    public void setExchangeRate(double exchangeRate) {
        this.exchangeRate = exchangeRate;
    }

    public double getFee() {
        return fee;
    }

    public void setFee(double fee) {
        this.fee = fee;
    }

    public double getMxnAmount() {
        return mxnAmount;
    }

    public void setMxnAmount(double mxnAmount) {
        this.mxnAmount = mxnAmount;
    }
}
