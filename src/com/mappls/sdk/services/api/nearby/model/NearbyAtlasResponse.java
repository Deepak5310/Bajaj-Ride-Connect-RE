package com.mappls.sdk.services.api.nearby.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.mappls.sdk.services.api.autosuggest.model.AtlasExplaination;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes4.dex */
public class NearbyAtlasResponse {

    @SerializedName("pageInfo")
    @Expose
    private PageInfo pageInfo;

    @SerializedName("suggestedLocations")
    @Expose
    private ArrayList<NearbyAtlasResult> suggestedLocations = null;

    @SerializedName("explanation")
    @Expose
    private AtlasExplaination explaintion = null;

    public ArrayList<NearbyAtlasResult> getSuggestedLocations() {
        return this.suggestedLocations;
    }

    public void setSuggestedLocations(ArrayList<NearbyAtlasResult> arrayList) {
        this.suggestedLocations = arrayList;
    }

    public AtlasExplaination getExplaintion() {
        return this.explaintion;
    }

    public void setExplaintion(AtlasExplaination atlasExplaination) {
        this.explaintion = atlasExplaination;
    }

    public PageInfo getPageInfo() {
        return this.pageInfo;
    }

    public void setPageInfo(PageInfo pageInfo) {
        this.pageInfo = pageInfo;
    }
}
