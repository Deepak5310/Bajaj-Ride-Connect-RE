package com.mappls.sdk.services.api.transit.model;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes4.dex */
public class TransitCurrency {

    @SerializedName(FirebaseAnalytics.Param.CURRENCY)
    private String currency;

    @SerializedName("currencyCode")
    private String currencyCode;

    @SerializedName("defaultFractionDigits")
    private Integer defaultFractionDigits;

    @SerializedName("symbol")
    private String symbol;

    public String getSymbol() {
        return this.symbol;
    }

    public void setSymbol(String str) {
        this.symbol = str;
    }

    public String getCurrency() {
        return this.currency;
    }

    public void setCurrency(String str) {
        this.currency = str;
    }

    public Integer getDefaultFractionDigits() {
        return this.defaultFractionDigits;
    }

    public void setDefaultFractionDigits(Integer num) {
        this.defaultFractionDigits = num;
    }

    public String getCurrencyCode() {
        return this.currencyCode;
    }

    public void setCurrencyCode(String str) {
        this.currencyCode = str;
    }
}
