package com.google.android.libraries.navigation.internal.adr;

import com.facebook.common.callercontext.ContextChain;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class cm extends com.google.android.libraries.navigation.internal.ael.bi implements com.google.android.libraries.navigation.internal.ael.cz {
    public static final cm a;
    private static volatile com.google.android.libraries.navigation.internal.ael.dg m;
    public int b;
    public com.google.android.libraries.navigation.internal.aap.d c;
    public int d;
    public com.google.android.libraries.navigation.internal.aap.d e;
    public cb f;
    public com.google.android.libraries.navigation.internal.aap.d g;
    public com.google.android.libraries.navigation.internal.aap.r i;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private byte f219n = 2;
    public com.google.android.libraries.navigation.internal.ael.x h = com.google.android.libraries.navigation.internal.ael.x.b;
    public com.google.android.libraries.navigation.internal.ael.bz j = com.google.android.libraries.navigation.internal.ael.dj.b;
    public com.google.android.libraries.navigation.internal.ael.bz k = com.google.android.libraries.navigation.internal.ael.dj.b;
    public com.google.android.libraries.navigation.internal.ael.bz l = com.google.android.libraries.navigation.internal.ael.dj.b;

    static {
        cm cmVar = new cm();
        a = cmVar;
        com.google.android.libraries.navigation.internal.ael.bi.F(cm.class, cmVar);
    }

    private cm() {
    }

    @Override // com.google.android.libraries.navigation.internal.ael.bi
    public final Object aH(int i, Object obj) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.f219n);
        }
        if (i2 == 2) {
            ii.a aVar = ii.a.DELAY_NODATA;
            return new com.google.android.libraries.navigation.internal.ael.dk(a, "\u0001\n\u0000\u0001\u0001\r\n\u0000\u0003\u0003\u0001ဉ\u0000\u0003᠌\u0002\u0004ဉ\u0003\u0005ဉ\u0004\u0006ဉ\u0005\u0007ည\u0006\bဉ\u0007\nЛ\u000bЛ\rЛ", new Object[]{"b", "c", "d", ih.a, "e", "f", "g", "h", ContextChain.TAG_INFRA, "j", cj.class, "k", cj.class, "l", cl.class});
        }
        if (i2 == 3) {
            return new cm();
        }
        if (i2 == 4) {
            return new bz();
        }
        if (i2 == 5) {
            return a;
        }
        if (i2 != 6) {
            this.f219n = obj == null ? (byte) 0 : (byte) 1;
            return null;
        }
        com.google.android.libraries.navigation.internal.ael.dg bcVar = m;
        if (bcVar == null) {
            synchronized (cm.class) {
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
