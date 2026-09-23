package com.mappls.sdk.maps.promo.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes4.dex */
public class Promo {

    @SerializedName("content")
    @Expose
    private Object content;

    @SerializedName("contentType")
    @Expose
    private String contentType;

    @SerializedName("promoType")
    @Expose
    private String promoType;

    public String getPromoType() {
        return this.promoType;
    }

    public void setPromoType(String str) {
        this.promoType = str;
    }

    public String getContentType() {
        return this.contentType;
    }

    public void setContentType(String str) {
        this.contentType = str;
    }

    public Object getContent() {
        return this.content;
    }

    public void setContent(Object obj) {
        this.content = obj;
    }
}
