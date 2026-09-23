package com.google.android.libraries.navigation.internal.adi;

import com.facebook.common.callercontext.ContextChain;
import com.google.android.libraries.navigation.internal.ael.cz;
import com.google.android.libraries.navigation.internal.ael.dg;
import com.google.android.libraries.navigation.internal.ael.dk;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class bd extends com.google.android.libraries.navigation.internal.ael.bi implements cz {
    public static final bd a;
    private static volatile dg g;
    public int b;
    public com.google.android.libraries.navigation.internal.aeg.d c;
    public n d;
    private com.google.android.libraries.navigation.internal.aeg.b h;
    private bf i;
    private byte j = 2;
    public String e = "";
    public boolean f = true;

    static {
        bd bdVar = new bd();
        a = bdVar;
        com.google.android.libraries.navigation.internal.ael.bi.F(bd.class, bdVar);
    }

    private bd() {
    }

    @Override // com.google.android.libraries.navigation.internal.ael.bi
    public final Object aH(int i, Object obj) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.j);
        }
        if (i2 == 2) {
            return new dk(a, "\u0001\u0006\u0000\u0001\u0001\u001a\u0006\u0000\u0000\u0004\u0001ᐉ\u0000\u0003ᐉ\u0003\u0004ᐉ\u0004\bᐉ\u0002\u0019ဈ\u0006\u001aဇ\u0007", new Object[]{"b", "c", ContextChain.TAG_INFRA, "d", "h", "e", "f"});
        }
        if (i2 == 3) {
            return new bd();
        }
        if (i2 == 4) {
            return new bc();
        }
        if (i2 == 5) {
            return a;
        }
        if (i2 != 6) {
            this.j = obj == null ? (byte) 0 : (byte) 1;
            return null;
        }
        dg bcVar = g;
        if (bcVar == null) {
            synchronized (bd.class) {
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
