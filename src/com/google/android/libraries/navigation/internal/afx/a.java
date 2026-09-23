package com.google.android.libraries.navigation.internal.afx;

import java.util.IdentityHashMap;
import java.util.Map;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class a {
    public c a;
    public IdentityHashMap b;

    public a(c cVar) {
        this.a = cVar;
    }

    public final c a() {
        if (this.b != null) {
            c cVar = this.a;
            c cVar2 = c.a;
            for (Map.Entry entry : cVar.b.entrySet()) {
                if (!this.b.containsKey(entry.getKey())) {
                    this.b.put((b) entry.getKey(), entry.getValue());
                }
            }
            this.a = new c(this.b);
            this.b = null;
        }
        return this.a;
    }

    public final void b(b bVar, Object obj) {
        if (this.b == null) {
            this.b = new IdentityHashMap(1);
        }
        this.b.put(bVar, obj);
    }
}
