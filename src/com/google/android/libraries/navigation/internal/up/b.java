package com.google.android.libraries.navigation.internal.up;

import com.google.android.libraries.navigation.internal.zb.j;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class b {
    private static final j a = j.e("com.google.android.libraries.navigation.internal.up.b");

    public static int a(com.google.android.libraries.navigation.internal.tj.j jVar) {
        if (jVar.f()) {
            return (jVar.c || !jVar.e) ? com.google.android.libraries.navigation.internal.dw.h.l : com.google.android.libraries.navigation.internal.dw.h.b;
        }
        if (c(jVar)) {
            return com.google.android.libraries.navigation.internal.du.d.b;
        }
        if (jVar.g) {
            return com.google.android.libraries.navigation.internal.dw.h.l;
        }
        ((com.google.android.libraries.navigation.internal.zb.h) a.d(com.google.android.libraries.navigation.internal.nl.a.a).F((char) 1904)).p("Calling getMessageId() when there is no message to display");
        return -1;
    }

    public static boolean b(com.google.android.libraries.navigation.internal.tj.j jVar) {
        return jVar.g || jVar.f() || c(jVar);
    }

    private static boolean c(com.google.android.libraries.navigation.internal.tj.j jVar) {
        if (jVar.d || !jVar.c().b.k) {
            return (jVar.h || jVar.c().c != null || jVar.f) ? false : true;
        }
        return true;
    }
}
