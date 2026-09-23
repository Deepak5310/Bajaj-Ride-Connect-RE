package com.google.android.libraries.navigation.internal.ace;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class mq extends com.google.android.libraries.navigation.internal.ael.bi implements com.google.android.libraries.navigation.internal.ael.cz {
    public static final mq a;
    private static volatile com.google.android.libraries.navigation.internal.ael.dg e;
    public String b = "";
    public com.google.android.libraries.navigation.internal.ael.bz c = com.google.android.libraries.navigation.internal.ael.dj.b;
    public boolean d;
    private int f;

    static {
        mq mqVar = new mq();
        a = mqVar;
        com.google.android.libraries.navigation.internal.ael.bi.F(mq.class, mqVar);
    }

    private mq() {
    }

    @Override // com.google.android.libraries.navigation.internal.ael.bi
    public final Object aH(int i, Object obj) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return new com.google.android.libraries.navigation.internal.ael.dk(a, "\u0001\u0000", null);
        }
        if (i2 == 3) {
            return new mq();
        }
        if (i2 == 4) {
            return new mp();
        }
        if (i2 == 5) {
            return a;
        }
        if (i2 != 6) {
            throw null;
        }
        com.google.android.libraries.navigation.internal.ael.dg bcVar = e;
        if (bcVar == null) {
            synchronized (mq.class) {
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
