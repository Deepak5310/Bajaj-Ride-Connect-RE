package com.google.android.libraries.navigation.internal.afm;

import com.google.android.libraries.navigation.internal.ael.dk;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class ce extends com.google.android.libraries.navigation.internal.ael.bi implements com.google.android.libraries.navigation.internal.ael.cz {
    public static final ce a;
    private static volatile com.google.android.libraries.navigation.internal.ael.dg c;
    private int d;
    private byte e = 2;
    public com.google.android.libraries.navigation.internal.ael.x b = com.google.android.libraries.navigation.internal.ael.x.b;

    static {
        ce ceVar = new ce();
        a = ceVar;
        com.google.android.libraries.navigation.internal.ael.bi.F(ce.class, ceVar);
    }

    private ce() {
    }

    @Override // com.google.android.libraries.navigation.internal.ael.bi
    public final Object aH(int i, Object obj) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.e);
        }
        if (i2 == 2) {
            return new dk(a, "\u0004\u0001\u0000\u0001\u001c\u001c\u0001\u0000\u0000\u0001\u001cᔊ\u0000", new Object[]{"d", "b"});
        }
        if (i2 == 3) {
            return new ce();
        }
        if (i2 == 4) {
            return new cd();
        }
        if (i2 == 5) {
            return a;
        }
        if (i2 != 6) {
            this.e = obj == null ? (byte) 0 : (byte) 1;
            return null;
        }
        com.google.android.libraries.navigation.internal.ael.dg bcVar = c;
        if (bcVar == null) {
            synchronized (ce.class) {
                bcVar = c;
                if (bcVar == null) {
                    bcVar = new com.google.android.libraries.navigation.internal.ael.bc(a);
                    c = bcVar;
                }
            }
        }
        return bcVar;
    }
}
