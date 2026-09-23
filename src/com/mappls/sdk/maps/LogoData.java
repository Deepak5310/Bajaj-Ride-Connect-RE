package com.mappls.sdk.maps;

import com.google.android.gms.common.internal.ImagesContract;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes4.dex */
public class LogoData {

    @SerializedName("logoId")
    @Expose
    private String logoId;

    @SerializedName(ImagesContract.URL)
    @Expose
    private String logoUrl;

    @SerializedName("modified")
    @Expose
    private Long modified;

    public String getLogoId() {
        return this.logoId;
    }

    public void setLogoId(String str) {
        this.logoId = str;
    }

    public String getLogoUrl() {
        return this.logoUrl;
    }

    public void setLogoUrl(String str) {
        this.logoUrl = str;
    }

    public Long getModified() {
        return this.modified;
    }

    public void setModified(Long l) {
        this.modified = l;
    }
}
