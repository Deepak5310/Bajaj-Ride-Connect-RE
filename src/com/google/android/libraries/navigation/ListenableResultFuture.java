package com.google.android.libraries.navigation;

import java.util.concurrent.Future;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes2.dex */
public interface ListenableResultFuture<T> extends Future<T> {

    /* JADX INFO: compiled from: PG */
    public interface OnResultListener<T> {
        void onResult(T t);
    }

    void setOnResultListener(OnResultListener<T> onResultListener);
}
