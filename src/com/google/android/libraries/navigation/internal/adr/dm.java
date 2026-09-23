package com.google.android.libraries.navigation.internal.adr;

import com.facebook.common.callercontext.ContextChain;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class dm extends com.google.android.libraries.navigation.internal.ael.bi implements com.google.android.libraries.navigation.internal.ael.cz {
    public static final dm a;
    private static volatile com.google.android.libraries.navigation.internal.ael.dg j;
    public int b;
    public int c;
    public int d;
    public int e;
    public int f;
    public boolean g;
    private byte k = 2;
    public String h = "";
    public com.google.android.libraries.navigation.internal.ael.bz i = com.google.android.libraries.navigation.internal.ael.dj.b;

    static {
        dm dmVar = new dm();
        a = dmVar;
        com.google.android.libraries.navigation.internal.ael.bi.F(dm.class, dmVar);
    }

    private dm() {
    }

    @Override // com.google.android.libraries.navigation.internal.ael.bi
    public final Object aH(int i, Object obj) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.k);
        }
        if (i2 == 2) {
            return new com.google.android.libraries.navigation.internal.ael.dk(a, "\u0001\u0007\u0000\u0001\u0001\t\u0007\u0000\u0001\u0001\u0001ᴌ\u0000\u0002ဏ\u0001\u0003င\u0002\u0004င\u0003\u0005ဇ\u0004\u0006ဈ\u0005\t\u001b", new Object[]{"b", "c", dg.a, "d", "e", "f", "g", "h", ContextChain.TAG_INFRA, dl.class});
        }
        if (i2 == 3) {
            return new dm();
        }
        if (i2 == 4) {
            return new df();
        }
        if (i2 == 5) {
            return a;
        }
        if (i2 != 6) {
            this.k = obj == null ? (byte) 0 : (byte) 1;
            return null;
        }
        com.google.android.libraries.navigation.internal.ael.dg bcVar = j;
        if (bcVar == null) {
            synchronized (dm.class) {
                bcVar = j;
                if (bcVar == null) {
                    bcVar = new com.google.android.libraries.navigation.internal.ael.bc(a);
                    j = bcVar;
                }
            }
        }
        return bcVar;
    }
}
