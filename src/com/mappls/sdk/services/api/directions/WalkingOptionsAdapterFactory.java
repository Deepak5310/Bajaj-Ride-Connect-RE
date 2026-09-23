package com.mappls.sdk.services.api.directions;

import com.google.gson.TypeAdapterFactory;

/* JADX INFO: loaded from: classes4.dex */
public abstract class WalkingOptionsAdapterFactory implements TypeAdapterFactory {
    public static TypeAdapterFactory create() {
        return new AutoValueGson_WalkingOptionsAdapterFactory();
    }
}
