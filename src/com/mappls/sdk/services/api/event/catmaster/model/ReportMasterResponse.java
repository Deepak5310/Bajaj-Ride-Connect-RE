package com.mappls.sdk.services.api.event.catmaster.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class ReportMasterResponse {

    @SerializedName("baseURLObj")
    @Expose
    private BaseUrl baseUrl;

    @SerializedName("parentCategories")
    @Expose
    private List<ParentCategory> parentCategories;

    public BaseUrl getBaseUrl() {
        return this.baseUrl;
    }

    public void setBaseUrl(BaseUrl baseUrl) {
        this.baseUrl = baseUrl;
    }

    public List<ParentCategory> getParentCategories() {
        return this.parentCategories;
    }

    public void setParentCategories(List<ParentCategory> list) {
        this.parentCategories = list;
    }
}
