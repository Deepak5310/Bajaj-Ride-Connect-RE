package com.google.android.libraries.navigation.internal.abf;

import android.content.Context;
import com.google.android.libraries.navigation.internal.ael.cc;
import com.google.android.libraries.navigation.internal.ael.cy;
import com.google.android.libraries.navigation.internal.ael.dg;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class h {
    private final String a;
    private final dg b;
    private final g c;

    public h(Context context, String str, dg dgVar) {
        g gVar = new g(context);
        this.a = str;
        this.b = dgVar;
        this.c = gVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v4, types: [com.google.android.libraries.navigation.internal.ael.cy] */
    /* JADX WARN: Type inference failed for: r1v5 */
    /* JADX WARN: Type inference failed for: r1v6 */
    public final synchronized cy a() {
        ?? G;
        byte[] bArrB = this.c.b(this.a);
        G = 0;
        G = 0;
        if (bArrB != null) {
            try {
                G = this.b.g(bArrB);
            } catch (cc unused) {
                this.c.a(this.a, null);
            }
        }
        return G;
    }

    public final synchronized void b(cy cyVar) {
        try {
            if (cyVar == null) {
                this.c.a(this.a, null);
            } else {
                this.c.a(this.a, cyVar.m());
            }
        } catch (Throwable th) {
            throw th;
        }
    }
}
