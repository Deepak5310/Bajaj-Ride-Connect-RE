package com.google.android.libraries.navigation.internal.afl;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class qc extends com.google.android.libraries.navigation.internal.ael.bi implements com.google.android.libraries.navigation.internal.ael.cz {
    public static final qc a;
    private static volatile com.google.android.libraries.navigation.internal.ael.dg e;
    public boolean b;
    public boolean c;
    public boolean d;
    private int f;

    static {
        qc qcVar = new qc();
        a = qcVar;
        com.google.android.libraries.navigation.internal.ael.bi.F(qc.class, qcVar);
    }

    private qc() {
    }

    @Override // com.google.android.libraries.navigation.internal.ael.bi
    public final Object aH(int i, Object obj) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return new com.google.android.libraries.navigation.internal.ael.dk(a, "\u0001\u0003\u0000\u0001\u0007\u0011\u0003\u0000\u0000\u0000\u0007ဇ\u0006\u000fဇ\u000e\u0011ဇ\u0010", new Object[]{"f", "b", "c", "d"});
        }
        if (i2 == 3) {
            return new qc();
        }
        if (i2 == 4) {
            return new qb();
        }
        if (i2 == 5) {
            return a;
        }
        if (i2 != 6) {
            throw null;
        }
        com.google.android.libraries.navigation.internal.ael.dg bcVar = e;
        if (bcVar == null) {
            synchronized (qc.class) {
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
