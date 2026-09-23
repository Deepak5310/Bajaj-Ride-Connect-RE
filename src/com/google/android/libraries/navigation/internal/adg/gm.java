package com.google.android.libraries.navigation.internal.adg;

import com.facebook.common.callercontext.ContextChain;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class gm extends com.google.android.libraries.navigation.internal.ael.bi implements com.google.android.libraries.navigation.internal.ael.cz {
    public static final gm a;
    private static volatile com.google.android.libraries.navigation.internal.ael.dg o;
    public int b;
    public int f;
    private byte p = 2;
    public com.google.android.libraries.navigation.internal.ael.x c = com.google.android.libraries.navigation.internal.ael.x.b;
    public com.google.android.libraries.navigation.internal.ael.bq d = com.google.android.libraries.navigation.internal.ael.bj.a;
    public com.google.android.libraries.navigation.internal.ael.bp e = com.google.android.libraries.navigation.internal.ael.ay.a;
    public com.google.android.libraries.navigation.internal.ael.bq g = com.google.android.libraries.navigation.internal.ael.bj.a;
    public int h = -1;
    public com.google.android.libraries.navigation.internal.ael.bq i = com.google.android.libraries.navigation.internal.ael.bj.a;
    public int j = -1;
    public com.google.android.libraries.navigation.internal.ael.x k = com.google.android.libraries.navigation.internal.ael.x.b;
    public com.google.android.libraries.navigation.internal.ael.bq l = com.google.android.libraries.navigation.internal.ael.bj.a;
    public com.google.android.libraries.navigation.internal.ael.x m = com.google.android.libraries.navigation.internal.ael.x.b;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public com.google.android.libraries.navigation.internal.ael.bq f200n = com.google.android.libraries.navigation.internal.ael.bj.a;

    static {
        gm gmVar = new gm();
        a = gmVar;
        com.google.android.libraries.navigation.internal.ael.bi.F(gm.class, gmVar);
    }

    private gm() {
        Object[] objArr = com.google.android.libraries.navigation.internal.ael.dj.a;
    }

    public static /* synthetic */ void d(gm gmVar) {
        gmVar.b |= 8;
        gmVar.j = 0;
    }

    public static /* synthetic */ void e(gm gmVar) {
        gmVar.b |= 4;
        gmVar.h = 0;
    }

    @Override // com.google.android.libraries.navigation.internal.ael.bi
    public final Object aH(int i, Object obj) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.p);
        }
        if (i2 == 2) {
            return new com.google.android.libraries.navigation.internal.ael.dk(a, "\u0001\f\u0000\u0001\u0001\f\f\u0000\u0006\u0000\u0001ည\u0000\u0002'\u0003'\u0004'\u0005င\u0001\u0006င\u0002\u0007င\u0003\bည\u0004\t'\nည\u0005\u000b'\f$", new Object[]{"b", "c", "g", ContextChain.TAG_INFRA, "d", "f", "h", "j", "k", "l", "m", "n", "e"});
        }
        if (i2 == 3) {
            return new gm();
        }
        if (i2 == 4) {
            return new gl();
        }
        if (i2 == 5) {
            return a;
        }
        if (i2 != 6) {
            this.p = obj == null ? (byte) 0 : (byte) 1;
            return null;
        }
        com.google.android.libraries.navigation.internal.ael.dg bcVar = o;
        if (bcVar == null) {
            synchronized (gm.class) {
                bcVar = o;
                if (bcVar == null) {
                    bcVar = new com.google.android.libraries.navigation.internal.ael.bc(a);
                    o = bcVar;
                }
            }
        }
        return bcVar;
    }

    public final void c() {
        com.google.android.libraries.navigation.internal.ael.bp bpVar = this.e;
        if (bpVar.c()) {
            return;
        }
        int size = bpVar.size();
        this.e = bpVar.e(size + size);
    }
}
