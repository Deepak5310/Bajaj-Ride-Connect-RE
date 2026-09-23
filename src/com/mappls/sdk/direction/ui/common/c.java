package com.mappls.sdk.direction.ui.common;

import com.google.maps.android.BuildConfig;

/* JADX INFO: loaded from: classes6.dex */
public final /* synthetic */ class c {
    public static /* synthetic */ String a(int i) {
        if (i == 1) {
            return "SUCCESS";
        }
        if (i == 2) {
            return "ERROR";
        }
        return i == 3 ? "LOADING" : BuildConfig.TRAVIS;
    }
}
