package com.google.android.libraries.navigation.internal.adg;

import com.facebook.common.callercontext.ContextChain;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class jp extends com.google.android.libraries.navigation.internal.ael.bi implements com.google.android.libraries.navigation.internal.ael.cz {
    public static final jp a;
    private static volatile com.google.android.libraries.navigation.internal.ael.dg m;
    public int b;
    public int c;
    public int d;
    public int e;
    public int f;
    public int g;
    public boolean h;
    public float i;
    public float j;
    public float k;
    public float l;

    static {
        jp jpVar = new jp();
        a = jpVar;
        com.google.android.libraries.navigation.internal.ael.bi.F(jp.class, jpVar);
    }

    private jp() {
    }

    @Override // com.google.android.libraries.navigation.internal.ael.bi
    public final Object aH(int i, Object obj) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return new com.google.android.libraries.navigation.internal.ael.dk(a, "\u0001\n\u0000\u0001\u0001\u000b\n\u0000\u0000\u0000\u0001ဆ\u0000\u0002င\u0001\u0003ဆ\u0002\u0004င\u0005\u0005ဇ\u0006\u0006ခ\u0007\u0007ခ\b\tခ\n\nခ\u000b\u000bဆ\u0003", new Object[]{"b", "c", "d", "e", "g", "h", ContextChain.TAG_INFRA, "j", "k", "l", "f"});
        }
        if (i2 == 3) {
            return new jp();
        }
        if (i2 == 4) {
            return new jo();
        }
        if (i2 == 5) {
            return a;
        }
        if (i2 != 6) {
            throw null;
        }
        com.google.android.libraries.navigation.internal.ael.dg bcVar = m;
        if (bcVar == null) {
            synchronized (jp.class) {
                bcVar = m;
                if (bcVar == null) {
                    bcVar = new com.google.android.libraries.navigation.internal.ael.bc(a);
                    m = bcVar;
                }
            }
        }
        return bcVar;
    }
}
