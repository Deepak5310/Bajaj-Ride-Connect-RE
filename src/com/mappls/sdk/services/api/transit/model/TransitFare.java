package com.mappls.sdk.services.api.transit.model;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes4.dex */
public class TransitFare {

    @SerializedName("rupees")
    private Integer amount;

    @SerializedName(FirebaseAnalytics.Param.CURRENCY)
    private TransitCurrency currency;

    public TransitCurrency getCurrency() {
        return this.currency;
    }

    public void setCurrency(TransitCurrency transitCurrency) {
        this.currency = transitCurrency;
    }

    public Integer getAmount() {
        return this.amount;
    }

    public void setAmount(Integer num) {
        this.amount = num;
    }
}
