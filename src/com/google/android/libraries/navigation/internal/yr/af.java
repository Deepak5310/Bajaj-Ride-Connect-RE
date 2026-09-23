package com.google.android.libraries.navigation.internal.yr;

import android.os.Trace;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class af {
    public static void a(ag agVar) {
        String strB = agVar.b();
        int i = i.a;
        if (strB.length() > 127) {
            strB = strB.substring(0, 127);
        }
        Trace.beginSection(strB);
    }

    static void b(ag agVar) {
        if (d(agVar)) {
            Trace.beginSection("<propagated>");
            a(agVar);
        } else {
            if (agVar.a() != null) {
                b(agVar.a());
            }
            a(agVar);
        }
    }

    static void c(ag agVar) {
        if (d(agVar)) {
            Trace.endSection();
            Trace.endSection();
        } else {
            Trace.endSection();
            if (agVar.a() != null) {
                c(agVar.a());
            }
        }
    }

    public static boolean d(ag agVar) {
        return agVar.c() != Thread.currentThread();
    }
}
