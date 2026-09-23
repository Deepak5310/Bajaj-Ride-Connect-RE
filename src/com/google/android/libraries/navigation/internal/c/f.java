package com.google.android.libraries.navigation.internal.c;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class f {
    long a;
    final String b;
    final String c;
    final long d;
    final long e;
    final long f;
    final long g;
    final List h;

    public f(String str, String str2, long j, long j2, long j3, long j4, List list) {
        this.b = str;
        this.c = true == "".equals(str2) ? null : str2;
        this.d = j;
        this.e = j2;
        this.f = j3;
        this.g = j4;
        this.h = list;
    }

    static f a(g gVar) throws IOException {
        if (h.e(gVar) != 538247942) {
            throw new IOException();
        }
        String strH = h.h(gVar);
        String strH2 = h.h(gVar);
        long jF = h.f(gVar);
        long jF2 = h.f(gVar);
        long jF3 = h.f(gVar);
        long jF4 = h.f(gVar);
        int iE = h.e(gVar);
        if (iE < 0) {
            throw new IOException(com.google.android.libraries.navigation.internal.b.b.b(iE, "readHeaderList size="));
        }
        List listEmptyList = iE == 0 ? Collections.emptyList() : new ArrayList();
        for (int i = 0; i < iE; i++) {
            listEmptyList.add(new com.google.android.libraries.navigation.internal.b.k(h.h(gVar).intern(), h.h(gVar).intern()));
        }
        return new f(strH, strH2, jF, jF2, jF3, jF4, listEmptyList);
    }
}
