package com.google.android.libraries.navigation.internal.jd;

import android.content.Context;
import com.google.android.libraries.navigation.internal.jb.c;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class a {
    public static String a(Context context) {
        long jA = com.google.android.libraries.navigation.internal.je.a.a(context);
        Long lValueOf = Long.valueOf(jA);
        lValueOf.getClass();
        return jA == 0 ? "1" : lValueOf.toString();
    }

    public static String b(c cVar) {
        return cVar.a().toString() + "-NavAPI-6.1.0";
    }
}
