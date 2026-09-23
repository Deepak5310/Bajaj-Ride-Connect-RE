package com.mappls.sdk.services.api.directionsrefresh.models;

import com.google.gson.TypeAdapterFactory;

/* JADX INFO: loaded from: classes4.dex */
public abstract class DirectionsRefreshAdapterFactory implements TypeAdapterFactory {
    public static TypeAdapterFactory create() {
        return new AutoValueGson_DirectionsRefreshAdapterFactory();
    }
}
