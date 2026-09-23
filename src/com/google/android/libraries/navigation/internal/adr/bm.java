package com.google.android.libraries.navigation.internal.adr;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class bm extends com.google.android.libraries.navigation.internal.ael.bi implements com.google.android.libraries.navigation.internal.ael.cz {
    public static final bm a;
    private static volatile com.google.android.libraries.navigation.internal.ael.dg e;
    public int b;
    public int c;
    public int d = 2;

    /* JADX INFO: compiled from: PG */
    public enum a implements com.google.android.libraries.navigation.internal.ael.bm {
        KILOMETERS(0),
        MILES(1),
        MILES_YARDS(3),
        REGIONAL(2);

        public final int e;

        a(int i) {
            this.e = i;
        }

        public static a b(int i) {
            if (i == 0) {
                return KILOMETERS;
            }
            if (i == 1) {
                return MILES;
            }
            if (i == 2) {
                return REGIONAL;
            }
            if (i != 3) {
                return null;
            }
            return MILES_YARDS;
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
        bm bmVar = new bm();
        a = bmVar;
        com.google.android.libraries.navigation.internal.ael.bi.F(bm.class, bmVar);
    }

    private bm() {
    }

    @Override // com.google.android.libraries.navigation.internal.ael.bi
    public final Object aH(int i, Object obj) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            a aVar = a.KILOMETERS;
            return new com.google.android.libraries.navigation.internal.ael.dk(a, "\u0001\u0002\u0000\u0001\u0001\u0003\u0002\u0000\u0000\u0000\u0001င\u0000\u0003᠌\u0002", new Object[]{"b", "c", "d", bl.a});
        }
        if (i2 == 3) {
            return new bm();
        }
        if (i2 == 4) {
            return new bk();
        }
        if (i2 == 5) {
            return a;
        }
        if (i2 != 6) {
            throw null;
        }
        com.google.android.libraries.navigation.internal.ael.dg bcVar = e;
        if (bcVar == null) {
            synchronized (bm.class) {
                bcVar = e;
                if (bcVar == null) {
                    bcVar = new com.google.android.libraries.navigation.internal.ael.bc(a);
                    e = bcVar;
                }
            }
        }
        return bcVar;
    }
}
