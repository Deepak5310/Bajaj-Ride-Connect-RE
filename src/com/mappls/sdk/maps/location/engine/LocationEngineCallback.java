package com.mappls.sdk.maps.location.engine;

/* JADX INFO: loaded from: classes4.dex */
public interface LocationEngineCallback<T> {
    void onFailure(Exception exc);

    void onSuccess(T t);
}
