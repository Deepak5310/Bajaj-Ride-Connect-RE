package com.google.android.libraries.navigation.internal.afl;

import com.facebook.common.callercontext.ContextChain;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class lz extends com.google.android.libraries.navigation.internal.ael.be implements com.google.android.libraries.navigation.internal.ael.bf {
    public static final lz a;
    private static volatile com.google.android.libraries.navigation.internal.ael.dg k;
    public int b;
    public lj c;
    public com.google.android.libraries.navigation.internal.aes.h f;
    public boolean g;
    public boolean h;
    public lt i;
    public boolean j;
    private com.google.android.libraries.navigation.internal.acd.oz l;
    private byte m = 2;
    public com.google.android.libraries.navigation.internal.ael.bq d = com.google.android.libraries.navigation.internal.ael.bj.a;
    public com.google.android.libraries.navigation.internal.ael.bq e = com.google.android.libraries.navigation.internal.ael.bj.a;

    static {
        lz lzVar = new lz();
        a = lzVar;
        com.google.android.libraries.navigation.internal.ael.bi.F(lz.class, lzVar);
    }

    private lz() {
    }

    @Override // com.google.android.libraries.navigation.internal.ael.bi
    public final Object aH(int i, Object obj) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.m);
        }
        if (i2 == 2) {
            return new com.google.android.libraries.navigation.internal.ael.dk(a, "\u0001\t\u0000\u0001\u0001\f\t\u0000\u0002\u0001\u0001ᐉ\u0000\u0002ࠞ\u0004ࠞ\u0006ဉ\u0001\u0007ဇ\u0002\bဇ\u0003\nဉ\u0004\u000bဉ\u0005\fဇ\u0006", new Object[]{"b", "c", "d", kt.a, "e", lx.a, "f", "g", "h", "l", ContextChain.TAG_INFRA, "j"});
        }
        if (i2 == 3) {
            return new lz();
        }
        if (i2 == 4) {
            return new lw();
        }
        if (i2 == 5) {
            return a;
        }
        if (i2 != 6) {
            this.m = obj == null ? (byte) 0 : (byte) 1;
            return null;
        }
        com.google.android.libraries.navigation.internal.ael.dg bcVar = k;
        if (bcVar == null) {
            synchronized (lz.class) {
                bcVar = k;
                if (bcVar == null) {
                    bcVar = new com.google.android.libraries.navigation.internal.ael.bc(a);
                    k = bcVar;
                }
            }
        }
        return bcVar;
    }
}
