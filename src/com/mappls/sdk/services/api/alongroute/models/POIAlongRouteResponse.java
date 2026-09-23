package com.mappls.sdk.services.api.alongroute.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.mappls.sdk.services.api.nearby.model.PageInfo;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class POIAlongRouteResponse {

    @SerializedName("pageInfo")
    @Expose
    private PageInfo pageInfo;

    @SerializedName("suggestedPOIs")
    @Expose
    private List<SuggestedPOI> suggestedPOIs = null;

    public List<SuggestedPOI> getSuggestedPOIs() {
        return this.suggestedPOIs;
    }

    public void setSuggestedPOIs(List<SuggestedPOI> list) {
        this.suggestedPOIs = list;
    }

    public PageInfo getPageInfo() {
        return this.pageInfo;
    }

    public void setPageInfo(PageInfo pageInfo) {
        this.pageInfo = pageInfo;
    }
}
