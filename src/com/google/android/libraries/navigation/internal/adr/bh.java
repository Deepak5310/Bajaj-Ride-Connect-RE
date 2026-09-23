package com.google.android.libraries.navigation.internal.adr;

import com.facebook.common.callercontext.ContextChain;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class bh extends com.google.android.libraries.navigation.internal.ael.bi implements com.google.android.libraries.navigation.internal.ael.cz {
    public static final bh a;
    private static volatile com.google.android.libraries.navigation.internal.ael.dg j;
    public int b;
    public int c;
    public ah f;
    public int i;
    private byte k = 2;
    public String d = "";
    public String e = "";
    public String g = "";
    public String h = "";

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
            return Byte.valueOf(this.k);
        }
        if (i2 == 2) {
            return new com.google.android.libraries.navigation.internal.ael.dk(a, "\u0001\u0007\u0000\u0001\u0001\n\u0007\u0000\u0000\u0001\u0001᠌\u0000\u0002ဈ\u0001\u0003ဈ\u0007\u0004ဈ\b\u0005ဈ\u0005\t᠌\t\nᐉ\u0006", new Object[]{"b", "c", bf.a, "d", "g", "h", "e", ContextChain.TAG_INFRA, bd.a, "f"});
        }
        if (i2 == 3) {
            return new bh();
        }
        if (i2 == 4) {
            return new bc();
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
            synchronized (bh.class) {
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
