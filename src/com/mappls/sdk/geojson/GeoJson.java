package com.mappls.sdk.geojson;

import java.io.Serializable;

/* JADX INFO: loaded from: classes6.dex */
public interface GeoJson extends Serializable {
    BoundingBox bbox();

    String toJson();

    String type();
}
