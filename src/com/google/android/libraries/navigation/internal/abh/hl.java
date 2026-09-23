package com.google.android.libraries.navigation.internal.abh;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class hl {
    private static final String d = "hl";
    public final com.google.android.libraries.navigation.internal.abf.a a;
    public final com.google.android.libraries.navigation.internal.abf.z b;
    final Map c;
    private final gf e;

    public hl(gf gfVar, com.google.android.libraries.navigation.internal.abf.a aVar, com.google.android.libraries.navigation.internal.abf.z zVar) {
        this.e = gfVar;
        this.a = aVar;
        com.google.android.libraries.navigation.internal.abf.s.k(zVar, "threadChecker");
        this.b = zVar;
        this.c = new HashMap();
    }

    public final void a(String str) {
        this.b.a();
        if (c(str)) {
            this.e.b(com.google.android.libraries.navigation.internal.afm.d.STREETVIEW_CREATE_DYNAMIC, null, null);
            com.google.android.libraries.navigation.internal.abf.p.f(d, 3);
        } else {
            com.google.android.libraries.navigation.internal.abf.p.f(d, 3);
        }
        b();
    }

    final void b() {
        Iterator it2 = this.c.keySet().iterator();
        while (it2.hasNext()) {
            if (c((String) it2.next())) {
                it2.remove();
            }
        }
    }

    final boolean c(String str) {
        if (str == null) {
            return true;
        }
        Map map = this.c;
        long jCurrentTimeMillis = System.currentTimeMillis();
        Long l = (Long) map.get(str);
        return l == null || jCurrentTimeMillis - l.longValue() > 5000;
    }
}
