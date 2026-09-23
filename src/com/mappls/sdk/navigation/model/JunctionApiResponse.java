package com.mappls.sdk.navigation.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class JunctionApiResponse {

    @SerializedName("data")
    @Expose
    public List<Junction> data;

    @SerializedName("imageBaseUrl")
    @Expose
    public String imageBaseUrl;
}
