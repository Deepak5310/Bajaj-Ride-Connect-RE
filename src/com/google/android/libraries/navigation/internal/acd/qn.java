package com.google.android.libraries.navigation.internal.acd;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class qn extends com.google.android.libraries.navigation.internal.ael.bi implements com.google.android.libraries.navigation.internal.ael.cz {
    public static final qn a;
    private static volatile com.google.android.libraries.navigation.internal.ael.dg b;
    private int c;
    private com.google.android.libraries.navigation.internal.adq.al d;
    private oz e;
    private byte f = 2;

    static {
        qn qnVar = new qn();
        a = qnVar;
        com.google.android.libraries.navigation.internal.ael.bi.F(qn.class, qnVar);
    }

    private qn() {
        com.google.android.libraries.navigation.internal.ael.bj bjVar = com.google.android.libraries.navigation.internal.ael.bj.a;
    }

    @Override // com.google.android.libraries.navigation.internal.ael.bi
    public final Object aH(int i, Object obj) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.f);
        }
        if (i2 == 2) {
            return new com.google.android.libraries.navigation.internal.ael.dk(a, "\u0001\u0002\u0000\u0001\b\u0011\u0002\u0000\u0000\u0001\bᐉ\u000b\u0011ဉ\u0011", new Object[]{"c", "d", "e"});
        }
        if (i2 == 3) {
            return new qn();
        }
        if (i2 == 4) {
            return new qm();
        }
        if (i2 == 5) {
            return a;
        }
        if (i2 != 6) {
            this.f = obj == null ? (byte) 0 : (byte) 1;
            return null;
        }
        com.google.android.libraries.navigation.internal.ael.dg bcVar = b;
        if (bcVar == null) {
            synchronized (qn.class) {
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
