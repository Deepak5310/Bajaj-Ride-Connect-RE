package com.google.android.libraries.navigation.environment;

import android.content.Context;
import android.net.Uri;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes2.dex */
public final class dj {
    static com.google.android.libraries.navigation.internal.yh.k a(Context context, com.google.android.libraries.navigation.internal.yh.p pVar) {
        if (!com.google.android.libraries.navigation.internal.afw.j.c()) {
            return null;
        }
        Pattern pattern = com.google.android.libraries.navigation.internal.xz.g.a;
        com.google.android.libraries.navigation.internal.xz.f fVar = new com.google.android.libraries.navigation.internal.xz.f(context);
        fVar.b("navsdk");
        fVar.c("quota_cache.pb");
        Uri uriA = fVar.a();
        com.google.android.libraries.navigation.internal.yh.l lVarH = com.google.android.libraries.navigation.internal.yh.m.h();
        lVarH.d(uriA);
        lVarH.c(com.google.android.libraries.navigation.internal.xi.b.a);
        return pVar.a(lVarH.a());
    }
}
