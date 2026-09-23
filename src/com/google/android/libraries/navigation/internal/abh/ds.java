package com.google.android.libraries.navigation.internal.abh;

import android.content.Context;
import java.util.List;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class ds {
    public static final com.google.android.libraries.navigation.internal.mj.a a = new com.google.android.libraries.navigation.internal.mk.b();

    static com.google.android.libraries.navigation.internal.ky.o a(Context context, String str) {
        com.google.android.libraries.navigation.internal.lc.h hVar = com.google.android.libraries.navigation.internal.lc.h.a;
        if (com.google.android.libraries.navigation.internal.lc.ak.a(context) < 7300000) {
            return null;
        }
        List list = com.google.android.libraries.navigation.internal.ky.o.o;
        com.google.android.libraries.navigation.internal.ky.l lVar = new com.google.android.libraries.navigation.internal.ky.l(context, str);
        lVar.f = eo.a;
        return lVar.d();
    }
}
