package com.google.android.libraries.navigation.internal.qj;

import com.google.android.libraries.navigation.internal.ia.e;
import com.google.android.libraries.navigation.internal.pi.d;
import com.google.android.libraries.navigation.internal.zt.as;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class a {
    private final Map a = new HashMap();
    private final com.google.android.libraries.navigation.internal.mj.a b;
    private final e c;

    public a(com.google.android.libraries.navigation.internal.mj.a aVar, e eVar) {
        this.b = aVar;
        this.c = eVar;
    }

    public final void a(as asVar, float f) {
        b(asVar, 0, f);
    }

    public final void b(as asVar, int i, float f) {
        synchronized (this.a) {
            long jA = this.b.a();
            boolean z = true;
            if (this.a.get(asVar) != null && jA - ((Long) this.a.get(asVar)).longValue() < 500) {
                z = false;
            }
            this.a.put(asVar, Long.valueOf(jA));
            if (z) {
                this.c.a(new d());
            }
        }
    }
}
