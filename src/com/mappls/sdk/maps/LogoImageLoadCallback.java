package com.mappls.sdk.maps;

import android.graphics.Bitmap;

/* JADX INFO: loaded from: classes4.dex */
public interface LogoImageLoadCallback {
    void onFailure();

    void onSuccess(Bitmap bitmap);
}
