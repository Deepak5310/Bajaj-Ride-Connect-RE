package com.mappls.sdk.navigation.iface;

import android.graphics.Bitmap;

/* JADX INFO: loaded from: classes4.dex */
public interface JunctionViewImageLoadedListener {
    void onFailure();

    void onSuccess(Bitmap bitmap);
}
