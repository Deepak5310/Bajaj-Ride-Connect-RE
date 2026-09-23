package com.spotify.protocol.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes4.dex */
@JsonIgnoreProperties(ignoreUnknown = true)
public class GetRecommendedContentItemsRequest {

    @SerializedName("type")
    @JsonProperty("type")
    public final String type;

    public GetRecommendedContentItemsRequest() {
        this("");
    }

    public GetRecommendedContentItemsRequest(String str) {
        this.type = str;
    }
}
