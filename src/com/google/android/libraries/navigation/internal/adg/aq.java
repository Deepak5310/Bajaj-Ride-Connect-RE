package com.google.android.libraries.navigation.internal.adg;

import com.facebook.common.callercontext.ContextChain;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class aq extends com.google.android.libraries.navigation.internal.ael.be implements com.google.android.libraries.navigation.internal.ael.bf {
    public static final aq a;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private static volatile com.google.android.libraries.navigation.internal.ael.dg f179n;
    public int b;
    public gm c;
    public boolean d;
    public boolean e;
    public int f;
    public int g;
    public int h;
    public int k;
    public int l;
    public fs m;
    private byte o = 2;
    public int i = -1;
    public long j = -1;

    static {
        aq aqVar = new aq();
        a = aqVar;
        com.google.android.libraries.navigation.internal.ael.bi.F(aq.class, aqVar);
    }

    private aq() {
        Object[] objArr = com.google.android.libraries.navigation.internal.ael.dj.a;
    }

    @Override // com.google.android.libraries.navigation.internal.ael.bi
    public final Object aH(int i, Object obj) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.o);
        }
        if (i2 == 2) {
            return new com.google.android.libraries.navigation.internal.ael.dk(a, "\u0001\u000b\u0000\u0001\u0001\u000f\u000b\u0000\u0000\u0002\u0001ᐉ\u0000\u0002ဇ\u0002\u0003င\u0007\u0004င\t\u0005ဆ\n\u0007ဇ\u0001\bဂ\b\u000bင\u0005\fင\u0006\r᠌\u0003\u000fᐉ\f", new Object[]{"b", "c", "e", ContextChain.TAG_INFRA, "k", "l", "d", "j", "g", "h", "f", cy.a, "m"});
        }
        if (i2 == 3) {
            return new aq();
        }
        if (i2 == 4) {
            return new ap();
        }
        if (i2 == 5) {
            return a;
        }
        if (i2 != 6) {
            this.o = obj == null ? (byte) 0 : (byte) 1;
            return null;
        }
        com.google.android.libraries.navigation.internal.ael.dg bcVar = f179n;
        if (bcVar == null) {
            synchronized (aq.class) {
                bcVar = f179n;
                if (bcVar == null) {
                    bcVar = new com.google.android.libraries.navigation.internal.ael.bc(a);
                    f179n = bcVar;
                }
            }
        }
        return bcVar;
    }
}
