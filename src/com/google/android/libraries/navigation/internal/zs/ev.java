package com.google.android.libraries.navigation.internal.zs;

import com.facebook.common.callercontext.ContextChain;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class ev extends com.google.android.libraries.navigation.internal.ael.bi implements com.google.android.libraries.navigation.internal.ael.cz {
    public static final ev a;
    private static volatile com.google.android.libraries.navigation.internal.ael.dg j;
    public int b;
    public long c;
    public String d = "";
    public String e = "";
    public com.google.android.libraries.navigation.internal.ael.bz f;
    public boolean g;
    public int h;
    public int i;

    static {
        ev evVar = new ev();
        a = evVar;
        com.google.android.libraries.navigation.internal.ael.bi.F(ev.class, evVar);
    }

    private ev() {
        com.google.android.libraries.navigation.internal.ael.bj bjVar = com.google.android.libraries.navigation.internal.ael.bj.a;
        this.f = com.google.android.libraries.navigation.internal.ael.dj.b;
    }

    @Override // com.google.android.libraries.navigation.internal.ael.bi
    public final Object aH(int i, Object obj) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return new com.google.android.libraries.navigation.internal.ael.dk(a, "\u0001\u0007\u0000\u0001\u0001\u0019\u0007\u0000\u0001\u0000\u0001စ\u0000\bဈ\t\u0010ဈ\u0001\u0011\u001a\u0016ဇ\f\u0018᠌\r\u0019င\u000e", new Object[]{"b", "c", "e", "d", "f", "g", "h", et.a, ContextChain.TAG_INFRA});
        }
        if (i2 == 3) {
            return new ev();
        }
        if (i2 == 4) {
            return new es();
        }
        if (i2 == 5) {
            return a;
        }
        if (i2 != 6) {
            throw null;
        }
        com.google.android.libraries.navigation.internal.ael.dg bcVar = j;
        if (bcVar == null) {
            synchronized (ev.class) {
                bcVar = j;
                if (bcVar == null) {
                    bcVar = new com.google.android.libraries.navigation.internal.ael.bc(a);
                    j = bcVar;
                }
            }
        }
        return bcVar;
    }
}
