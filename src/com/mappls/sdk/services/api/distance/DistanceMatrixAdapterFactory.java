package com.mappls.sdk.services.api.distance;

import com.google.gson.TypeAdapterFactory;

/* JADX INFO: loaded from: classes4.dex */
public abstract class DistanceMatrixAdapterFactory implements TypeAdapterFactory {
    public static TypeAdapterFactory create() {
        return new AutoValueGson_DistanceMatrixAdapterFactory();
    }
}
