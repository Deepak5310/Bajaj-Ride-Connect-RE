package com.google.android.libraries.navigation.internal.adr;

import com.facebook.common.callercontext.ContextChain;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class by extends com.google.android.libraries.navigation.internal.ael.bi implements com.google.android.libraries.navigation.internal.ael.cz {
    public static final by a;
    private static volatile com.google.android.libraries.navigation.internal.ael.dg k;
    public int b;
    public boolean c;
    public boolean d;
    public iu e;
    public com.google.android.libraries.navigation.internal.ael.bz f = com.google.android.libraries.navigation.internal.ael.dj.b;
    public com.google.android.libraries.navigation.internal.ady.aj g;
    public com.google.android.libraries.navigation.internal.aap.j h;
    public com.google.android.libraries.navigation.internal.aap.v i;
    public boolean j;

    static {
        by byVar = new by();
        a = byVar;
        com.google.android.libraries.navigation.internal.ael.bi.F(by.class, byVar);
    }

    private by() {
    }

    @Override // com.google.android.libraries.navigation.internal.ael.bi
    public final Object aH(int i, Object obj) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return new com.google.android.libraries.navigation.internal.ael.dk(a, "\u0001\b\u0000\u0001\u0001)\b\u0000\u0001\u0000\u0001ဇ\u0000\u0002ဇ\u0001\u0005ဉ\t\u0017\u001b\u001bဉ\u0011\u001fဉ\u0013\"ဉ\u0014)ဇ\u001a", new Object[]{"b", "c", "d", "e", "f", bx.class, "g", "h", ContextChain.TAG_INFRA, "j"});
        }
        if (i2 == 3) {
            return new by();
        }
        if (i2 == 4) {
            return new bt();
        }
        if (i2 == 5) {
            return a;
        }
        if (i2 != 6) {
            throw null;
        }
        com.google.android.libraries.navigation.internal.ael.dg bcVar = k;
        if (bcVar == null) {
            synchronized (by.class) {
                bcVar = k;
                if (bcVar == null) {
                    bcVar = new com.google.android.libraries.navigation.internal.ael.bc(a);
                    k = bcVar;
                }
            }
        }
        return bcVar;
    }

    public final void c() {
        com.google.android.libraries.navigation.internal.ael.bz bzVar = this.f;
        if (bzVar.c()) {
            return;
        }
        this.f = com.google.android.libraries.navigation.internal.ael.bi.A(bzVar);
    }
}
