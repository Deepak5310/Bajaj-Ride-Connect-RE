package com.google.android.libraries.navigation.internal.jk;

import com.facebook.common.util.UriUtil;
import com.google.android.libraries.navigation.internal.nc.ah;
import com.google.android.libraries.navigation.internal.nc.aj;
import com.google.android.libraries.navigation.internal.qy.h;
import com.google.android.libraries.navigation.internal.qz.g;
import com.google.android.libraries.navigation.internal.qz.k;
import com.google.android.libraries.navigation.internal.se.b;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class a {
    public static final String a = "a";

    private a() {
    }

    public static int a(b bVar) {
        int i = bVar.b.J;
        int i2 = bVar.j;
        if (i2 == -1 || i2 > i) {
            i2 = 0;
        }
        return i - i2;
    }

    public static ah b(k kVar) {
        ah ahVarF = kVar == null ? null : kVar.f();
        return ahVarF == null ? aj.c() : ahVarF;
    }

    public static String d(String str) {
        if (str == null) {
            return null;
        }
        return str.startsWith(UriUtil.HTTP_SCHEME) ? str : "https:".concat(str);
    }

    public static ah c(String str, h hVar, g gVar) {
        return b(str == null ? null : hVar.d(str, a, gVar));
    }
}
