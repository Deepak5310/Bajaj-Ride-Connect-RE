package com.google.android.libraries.navigation.internal.acd;

import com.drew.metadata.exif.makernotes.FujifilmMakernoteDirectory;
import com.facebook.common.callercontext.ContextChain;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class mj extends com.google.android.libraries.navigation.internal.ael.bi implements com.google.android.libraries.navigation.internal.ael.cz {
    public static final mj a;
    private static volatile com.google.android.libraries.navigation.internal.ael.dg j;
    public int b;
    public String c;
    public String d;
    public int e;
    public boolean f;
    public int g;
    public boolean h;
    public boolean i;

    static {
        mj mjVar = new mj();
        a = mjVar;
        com.google.android.libraries.navigation.internal.ael.bi.F(mj.class, mjVar);
    }

    private mj() {
        Object[] objArr = com.google.android.libraries.navigation.internal.ael.dj.a;
        this.c = "";
        this.d = "";
        this.e = 10;
        this.g = FujifilmMakernoteDirectory.TAG_DYNAMIC_RANGE;
        com.google.android.libraries.navigation.internal.ael.bj bjVar = com.google.android.libraries.navigation.internal.ael.bj.a;
    }

    @Override // com.google.android.libraries.navigation.internal.ael.bi
    public final Object aH(int i, Object obj) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return new com.google.android.libraries.navigation.internal.ael.dk(a, "\u0001\u0007\u0000\u0001\u00163\u0007\u0000\u0000\u0000\u0016ဇ\f\u001aဈ\b$ဈ\t&င\n*ဇ\u001c1င\u00123ဇ\u001f", new Object[]{"b", "f", "c", "d", "e", "h", "g", ContextChain.TAG_INFRA});
        }
        if (i2 == 3) {
            return new mj();
        }
        if (i2 == 4) {
            return new mi();
        }
        if (i2 == 5) {
            return a;
        }
        if (i2 != 6) {
            throw null;
        }
        com.google.android.libraries.navigation.internal.ael.dg bcVar = j;
        if (bcVar == null) {
            synchronized (mj.class) {
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
