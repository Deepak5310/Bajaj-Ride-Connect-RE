package com.google.android.libraries.navigation.internal.wx;

import android.content.Context;
import android.content.SharedPreferences;
import com.google.android.libraries.navigation.internal.aac.az;
import com.google.android.libraries.navigation.internal.aac.bj;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class b implements c {
    private final SharedPreferences a;

    public b(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.a = context.getSharedPreferences("com.google.geo_sdk.PREFERENCES_FILE", 0);
    }

    @Override // com.google.android.libraries.navigation.internal.wx.c
    public final bj a() {
        String string = this.a.getString("zb", "");
        bj bjVarH = az.h(string != null ? string : "");
        Intrinsics.checkNotNullExpressionValue(bjVarH, "immediateFuture(...)");
        return bjVarH;
    }

    @Override // com.google.android.libraries.navigation.internal.wx.c
    public final void b(String zwiebackCookie) {
        Intrinsics.checkNotNullParameter(zwiebackCookie, "zwiebackCookie");
        this.a.edit().putString("zb", zwiebackCookie).apply();
    }
}
