package com.mappls.sdk.navigation;

import android.content.Context;

/* JADX INFO: loaded from: classes4.dex */
public final class y {
    private static y b;
    private final String a;

    private y(Context context) {
        this.a = context.getString(R.string.mappls_shared_string_navigation);
    }

    public static String a(Context context) {
        if (b == null) {
            b = new y(context);
        }
        return b.a;
    }
}
