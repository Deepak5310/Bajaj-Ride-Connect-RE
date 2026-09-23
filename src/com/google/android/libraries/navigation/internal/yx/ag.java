package com.google.android.libraries.navigation.internal.yx;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class ag {
    public final ah a;
    public final String b;

    public ag(ah ahVar, String str) {
        this.a = ahVar;
        ar.q(str);
        this.b = str;
    }

    public final String a(Map map) {
        Iterator it2 = map.entrySet().iterator();
        StringBuilder sb = new StringBuilder();
        try {
            if (it2.hasNext()) {
                Map.Entry entry = (Map.Entry) it2.next();
                sb.append(this.a.a(entry.getKey()));
                sb.append((CharSequence) this.b);
                sb.append(this.a.a(entry.getValue()));
                while (it2.hasNext()) {
                    sb.append((CharSequence) this.a.c);
                    Map.Entry entry2 = (Map.Entry) it2.next();
                    sb.append(this.a.a(entry2.getKey()));
                    sb.append((CharSequence) this.b);
                    sb.append(this.a.a(entry2.getValue()));
                }
            }
            return sb.toString();
        } catch (IOException e) {
            throw new AssertionError(e);
        }
    }
}
