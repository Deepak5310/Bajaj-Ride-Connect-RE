package com.google.android.libraries.navigation.internal.adg;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class bg extends com.google.android.libraries.navigation.internal.ael.be implements com.google.android.libraries.navigation.internal.ael.bf {
    public static final bg a;
    private static volatile com.google.android.libraries.navigation.internal.ael.dg g;
    public int b;
    public int c;
    public fi d;
    public as e;
    public eh f;
    private cl h;
    private byte i = 2;

    static {
        bg bgVar = new bg();
        a = bgVar;
        com.google.android.libraries.navigation.internal.ael.bi.F(bg.class, bgVar);
    }

    private bg() {
        Object[] objArr = com.google.android.libraries.navigation.internal.ael.dj.a;
    }

    @Override // com.google.android.libraries.navigation.internal.ael.bi
    public final Object aH(int i, Object obj) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.i);
        }
        if (i2 == 2) {
            return new com.google.android.libraries.navigation.internal.ael.dk(a, "\u0001\u0005\u0000\u0001\u0001\f\u0005\u0000\u0000\u0004\u0001᠌\u0000\u0004ᐉ\u0002\u0005ᐉ\u0003\u0007ᐉ\u0005\fᐉ\b", new Object[]{"b", "c", jq.a, "d", "e", "f", "h"});
        }
        if (i2 == 3) {
            return new bg();
        }
        if (i2 == 4) {
            return new bf();
        }
        if (i2 == 5) {
            return a;
        }
        if (i2 != 6) {
            this.i = obj == null ? (byte) 0 : (byte) 1;
            return null;
        }
        com.google.android.libraries.navigation.internal.ael.dg bcVar = g;
        if (bcVar == null) {
            synchronized (bg.class) {
                bcVar = g;
                if (bcVar == null) {
                    bcVar = new com.google.android.libraries.navigation.internal.ael.bc(a);
                    g = bcVar;
                }
            }
        }
        return bcVar;
    }
}
