package com.mappls.sdk.maps;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
class CoordinateResponse {

    @SerializedName("results")
    @Expose
    private List<CoordinateResult> results = null;

    CoordinateResponse() {
    }

    public List<CoordinateResult> getResults() {
        return this.results;
    }

    public void setResults(List<CoordinateResult> list) {
        this.results = list;
    }
}
