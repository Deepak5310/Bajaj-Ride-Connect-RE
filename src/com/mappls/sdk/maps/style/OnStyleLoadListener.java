package com.mappls.sdk.maps.style;

import com.mappls.sdk.maps.Style;

/* JADX INFO: loaded from: classes4.dex */
public interface OnStyleLoadListener {
    void onError(String str);

    void onStyleLoaded(Style style);
}
