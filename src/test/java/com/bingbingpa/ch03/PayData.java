package com.bingbingpa.ch03;

import java.time.LocalDate;

public class PayData {

    private LocalDate firstBillingDate;
    private LocalDate billingDate;
    private int playAmount;

    private PayData() {
    }

    public PayData(LocalDate firstBillingDate, LocalDate billingDate, int playAmount) {
        this.firstBillingDate = firstBillingDate;
        this.billingDate = billingDate;
        this.playAmount = playAmount;
    }

    public static Builder builder() {
        return new Builder();
    }

    public LocalDate getBillingDate() {
        return billingDate;
    }

    public int getPlayAmount() {
        return playAmount;
    }

    public LocalDate getFirstBillingDate() {
        return firstBillingDate;
    }

    public static class Builder {
        private PayData data = new PayData();

        public Builder billingDate(LocalDate billingDate) {
            data.billingDate = billingDate;
            return this;
        }

        public Builder payAmount(int payAmount) {
            data.playAmount = payAmount;
            return this;
        }

        public Builder firstBillingDate(LocalDate firstBillingDate) {
            data.firstBillingDate = firstBillingDate;
            return this;
        }

        public PayData build() {
            return data;
        }
    }
}
