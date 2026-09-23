package com.google.android.libraries.navigation.internal.qu;

import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public class ce {
    private static final com.google.android.libraries.navigation.internal.zb.j f = com.google.android.libraries.navigation.internal.zb.j.e("com.google.android.libraries.navigation.internal.qu.ce");
    public final com.google.android.libraries.navigation.internal.adi.an a;
    public final com.google.android.libraries.navigation.internal.qv.g b;
    public final com.google.android.libraries.navigation.internal.qv.d c;
    public final com.google.android.libraries.navigation.internal.qv.d d;
    public int e = cd.a;
    private final long g;
    private final com.google.android.libraries.navigation.internal.aac.bn h;

    public ce(com.google.android.libraries.navigation.internal.adi.an anVar, com.google.android.libraries.navigation.internal.qv.g gVar, com.google.android.libraries.navigation.internal.qv.d dVar, com.google.android.libraries.navigation.internal.qv.d dVar2, com.google.android.libraries.navigation.internal.aac.bn bnVar) {
        this.a = anVar;
        this.b = gVar;
        this.d = dVar2;
        this.c = dVar;
        this.g = anVar == com.google.android.libraries.navigation.internal.adi.an.GMM_SATELLITE ? 1000L : 3000L;
        this.h = bnVar;
    }

    public final synchronized void a(boolean z) {
        int i;
        int i2;
        int i3;
        try {
            if (z) {
                if (this.e != cd.a && (i2 = this.e) != cd.b) {
                    if (i2 != cd.c && i2 != (i3 = cd.e) && i2 == cd.d) {
                        this.e = i3;
                        return;
                    }
                }
                this.e = cd.c;
                this.h.execute(new cc(this));
                return;
            }
            if (this.e == cd.a) {
                this.e = cd.b;
                com.google.android.libraries.navigation.internal.hx.n.a(this.h.schedule(new cc(this), this.g, TimeUnit.MILLISECONDS), this.h);
                return;
            }
            int i4 = this.e;
            if (i4 != cd.b && i4 != cd.c && i4 != (i = cd.e) && i4 == cd.d) {
                this.e = i;
            }
        } catch (Throwable th) {
            throw th;
        }
    }
}
