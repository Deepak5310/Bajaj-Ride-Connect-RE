package com.mappls.sdk.services.api.geolocation.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.mappls.sdk.maps.style.layers.Property;

/* JADX INFO: loaded from: classes4.dex */
public class Accuracy {

    @SerializedName(Property.RASTER_RESAMPLING_NEAREST)
    @Expose
    private Integer nearest;

    public Integer getNearest() {
        return this.nearest;
    }

    public void setNearest(Integer num) {
        this.nearest = num;
    }
}
