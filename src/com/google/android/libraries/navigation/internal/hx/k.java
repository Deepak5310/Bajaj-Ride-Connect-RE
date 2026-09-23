package com.google.android.libraries.navigation.internal.hx;

import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class k {
    public static final /* synthetic */ int a = 0;
    private static final Charset b = Charset.forName("UTF-8");
    private static final Map c = new HashMap();
    private static j[] d = new j[0];
    private static final StringBuilder e = new StringBuilder();

    public static synchronized void a(String str, String str2) {
        b(str, str2);
    }

    public static synchronized void b(String str, String str2) {
        try {
            if (str2 == null) {
                if (c.remove(str) == null) {
                }
                Map map = c;
                d = (j[]) map.values().toArray(new j[map.size()]);
                c();
            }
            Map map2 = c;
            j jVar = (j) map2.get(str);
            if (jVar == null || !jVar.b.equals(str2)) {
                map2.put(str, new j(str, str2));
                Map map3 = c;
                d = (j[]) map3.values().toArray(new j[map3.size()]);
                c();
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    private static synchronized void c() {
        e.setLength(0);
        for (j jVar : d) {
            StringBuilder sb = e;
            sb.append("{");
            sb.append(jVar.a);
            sb.append(": ");
            sb.append(jVar.b);
            sb.append("} ");
        }
    }
}
