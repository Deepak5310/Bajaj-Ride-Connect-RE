package com.google.android.libraries.navigation.internal.adr;

import com.facebook.common.callercontext.ContextChain;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class ii extends com.google.android.libraries.navigation.internal.ael.bi implements com.google.android.libraries.navigation.internal.ael.cz {
    public static final ii a;
    private static volatile com.google.android.libraries.navigation.internal.ael.dg l;
    public int b;
    public long d;
    public boolean e;
    public io j;
    public int k;
    private byte m = 2;
    public com.google.android.libraries.navigation.internal.ael.bz c = com.google.android.libraries.navigation.internal.ael.dj.b;
    public com.google.android.libraries.navigation.internal.ael.bz f = com.google.android.libraries.navigation.internal.ael.dj.b;
    public com.google.android.libraries.navigation.internal.ael.bz g = com.google.android.libraries.navigation.internal.ael.dj.b;
    public com.google.android.libraries.navigation.internal.ael.bz h = com.google.android.libraries.navigation.internal.ael.dj.b;
    public com.google.android.libraries.navigation.internal.ael.bz i = com.google.android.libraries.navigation.internal.ael.dj.b;

    /* JADX INFO: compiled from: PG */
    public enum a implements com.google.android.libraries.navigation.internal.ael.bm {
        DELAY_NODATA(0),
        DELAY_HEAVY(1),
        DELAY_MEDIUM(2),
        DELAY_LIGHT(3);

        public final int e;

        a(int i) {
            this.e = i;
        }

        public static a b(int i) {
            if (i == 0) {
                return DELAY_NODATA;
            }
            if (i == 1) {
                return DELAY_HEAVY;
            }
            if (i == 2) {
                return DELAY_MEDIUM;
            }
            if (i != 3) {
                return null;
            }
            return DELAY_LIGHT;
        }

        @Override // com.google.android.libraries.navigation.internal.ael.bm
        public final int a() {
            return this.e;
        }

        @Override // java.lang.Enum
        public final String toString() {
            return Integer.toString(this.e);
        }
    }

    static {
        ii iiVar = new ii();
        a = iiVar;
        com.google.android.libraries.navigation.internal.ael.bi.F(ii.class, iiVar);
    }

    private ii() {
    }

    @Override // com.google.android.libraries.navigation.internal.ael.bi
    public final Object aH(int i, Object obj) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.m);
        }
        if (i2 == 2) {
            a aVar = a.DELAY_NODATA;
            return new com.google.android.libraries.navigation.internal.ael.dk(a, "\u0001\b\u0000\u0001\u0001\f\b\u0000\u0005\u0004\u0001\u001b\u0002Л\u0003᠌\u0005\u0004Л\u0006ဉ\u0004\u0007ဂ\u0000\bЛ\fЛ", new Object[]{"b", "c", gv.class, "f", el.class, "k", ih.a, "g", el.class, "j", "d", "h", el.class, ContextChain.TAG_INFRA, el.class});
        }
        if (i2 == 3) {
            return new ii();
        }
        if (i2 == 4) {
            return new ig();
        }
        if (i2 == 5) {
            return a;
        }
        if (i2 != 6) {
            this.m = obj == null ? (byte) 0 : (byte) 1;
            return null;
        }
        com.google.android.libraries.navigation.internal.ael.dg bcVar = l;
        if (bcVar == null) {
            synchronized (ii.class) {
                bcVar = l;
                if (bcVar == null) {
                    bcVar = new com.google.android.libraries.navigation.internal.ael.bc(a);
                    l = bcVar;
                }
            }
        }
        return bcVar;
    }

    public final void c() {
        com.google.android.libraries.navigation.internal.ael.bz bzVar = this.c;
        if (bzVar.c()) {
            return;
        }
        this.c = com.google.android.libraries.navigation.internal.ael.bi.A(bzVar);
    }
}
