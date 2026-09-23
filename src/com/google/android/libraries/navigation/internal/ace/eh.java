package com.google.android.libraries.navigation.internal.ace;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class eh extends com.google.android.libraries.navigation.internal.ael.bi implements com.google.android.libraries.navigation.internal.ael.cz {
    public static final eh a;
    private static volatile com.google.android.libraries.navigation.internal.ael.dg b;
    private int c;
    private int d;
    private eq e;
    private b f;

    static {
        eh ehVar = new eh();
        a = ehVar;
        com.google.android.libraries.navigation.internal.ael.bi.F(eh.class, ehVar);
    }

    private eh() {
        Object[] objArr = com.google.android.libraries.navigation.internal.ael.dj.a;
    }

    @Override // com.google.android.libraries.navigation.internal.ael.bi
    public final Object aH(int i, Object obj) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return new com.google.android.libraries.navigation.internal.ael.dk(a, "\u0001\u0002\u0000\u0002\u001b9\u0002\u0000\u0000\u0000\u001bဉ\u001d9ဉ6", new Object[]{"c", "d", "e", "f"});
        }
        if (i2 == 3) {
            return new eh();
        }
        if (i2 == 4) {
            return new eg();
        }
        if (i2 == 5) {
            return a;
        }
        if (i2 != 6) {
            throw null;
        }
        com.google.android.libraries.navigation.internal.ael.dg bcVar = b;
        if (bcVar == null) {
            synchronized (eh.class) {
                bcVar = b;
                if (bcVar == null) {
                    bcVar = new com.google.android.libraries.navigation.internal.ael.bc(a);
                    b = bcVar;
                }
            }
        }
        return bcVar;
    }
}
