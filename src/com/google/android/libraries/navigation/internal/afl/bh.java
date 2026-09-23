package com.google.android.libraries.navigation.internal.afl;

import com.facebook.common.callercontext.ContextChain;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class bh extends com.google.android.libraries.navigation.internal.ael.bi implements com.google.android.libraries.navigation.internal.ael.cz {
    public static final bh a;
    private static volatile com.google.android.libraries.navigation.internal.ael.dg k;
    public int b;
    public int c = 500;
    public boolean d;
    public boolean e;
    public boolean f;
    public boolean g;
    public boolean h;
    public int i;
    public int j;
    private int l;
    private boolean m;

    static {
        bh bhVar = new bh();
        a = bhVar;
        com.google.android.libraries.navigation.internal.ael.bi.F(bh.class, bhVar);
    }

    private bh() {
    }

    @Override // com.google.android.libraries.navigation.internal.ael.bi
    public final Object aH(int i, Object obj) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return new com.google.android.libraries.navigation.internal.ael.dk(a, "\u0001\b\u0000\u0002)L\b\u0000\u0000\u0000)ဇ\u001f+ဇ!,ဇ\"-ဇ*.ဇ-@ဇ$Kင9Lင:", new Object[]{"l", "b", "d", "e", "m", "g", "h", "f", ContextChain.TAG_INFRA, "j"});
        }
        if (i2 == 3) {
            return new bh();
        }
        if (i2 == 4) {
            return new bg();
        }
        if (i2 == 5) {
            return a;
        }
        if (i2 != 6) {
            throw null;
        }
        com.google.android.libraries.navigation.internal.ael.dg bcVar = k;
        if (bcVar == null) {
            synchronized (bh.class) {
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
