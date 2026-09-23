package com.google.android.libraries.navigation.internal.acd;

import com.facebook.common.callercontext.ContextChain;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class mg extends com.google.android.libraries.navigation.internal.ael.bi implements com.google.android.libraries.navigation.internal.ael.cz {
    public static final mg a;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private static volatile com.google.android.libraries.navigation.internal.ael.dg f159n;
    public int b;
    public int c = 0;
    public Object d;
    public boolean e;
    public boolean f;
    public long g;
    public int h;
    public boolean i;
    public boolean j;
    public int k;
    public int l;
    public int m;

    static {
        mg mgVar = new mg();
        a = mgVar;
        com.google.android.libraries.navigation.internal.ael.bi.F(mg.class, mgVar);
    }

    private mg() {
    }

    @Override // com.google.android.libraries.navigation.internal.ael.bi
    public final Object aH(int i, Object obj) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return new com.google.android.libraries.navigation.internal.ael.dk(a, "\u0001\u000b\u0001\u0001\u0001\r\u000b\u0000\u0000\u0000\u0001ဇ\u0000\u0003စ\u0003\u0004င\u0004\u0005ဇ\u0005\u0006ဇ\u0006\u0007င\u0007\bင\b\nင\n\u000bဇ\u0002\f:\u0000\r:\u0000", new Object[]{"d", "c", "b", "e", "g", "h", ContextChain.TAG_INFRA, "j", "k", "l", "m", "f"});
        }
        if (i2 == 3) {
            return new mg();
        }
        if (i2 == 4) {
            return new mf();
        }
        if (i2 == 5) {
            return a;
        }
        if (i2 != 6) {
            throw null;
        }
        com.google.android.libraries.navigation.internal.ael.dg bcVar = f159n;
        if (bcVar == null) {
            synchronized (mg.class) {
                bcVar = f159n;
                if (bcVar == null) {
                    bcVar = new com.google.android.libraries.navigation.internal.ael.bc(a);
                    f159n = bcVar;
                }
            }
        }
        return bcVar;
    }
}
