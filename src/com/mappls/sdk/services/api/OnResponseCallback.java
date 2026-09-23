package com.mappls.sdk.services.api;

/* JADX INFO: loaded from: classes4.dex */
public interface OnResponseCallback<T> {
    void onError(int i, String str);

    void onSuccess(T t);
}
