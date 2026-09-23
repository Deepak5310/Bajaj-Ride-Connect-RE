package com.google.android.libraries.navigation.internal.zt;

import com.facebook.common.callercontext.ContextChain;
import com.google.android.libraries.navigation.internal.ael.bc;
import com.google.android.libraries.navigation.internal.ael.bi;
import com.google.android.libraries.navigation.internal.ael.cz;
import com.google.android.libraries.navigation.internal.ael.dg;
import com.google.android.libraries.navigation.internal.ael.dk;
import com.google.android.libraries.navigation.internal.zp.cd;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class b extends bi implements cz {
    public static final b a;
    private static volatile dg k;
    public int b;
    public cd d;
    public int e;
    public int f;
    public int i;
    public d j;
    private byte l = 2;
    public int c = -1;
    public int g = -1;
    public int h = -1;

    static {
        b bVar = new b();
        a = bVar;
        bi.F(b.class, bVar);
    }

    private b() {
    }

    @Override // com.google.android.libraries.navigation.internal.ael.bi
    public final Object aH(int i, Object obj) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.l);
        }
        if (i2 == 2) {
            return new dk(a, "\u0001\b\u0000\u0001\u0001\u000f\b\u0000\u0000\u0001\u0001င\u0000\u0002င\u0003\u0005င\u0005\u0006င\u0006\u0007င\u0007\bင\u0004\rᐉ\u000b\u000fဉ\u0002", new Object[]{"b", "c", "e", "g", "h", ContextChain.TAG_INFRA, "f", "j", "d"});
        }
        if (i2 == 3) {
            return new b();
        }
        if (i2 == 4) {
            return new a();
        }
        if (i2 == 5) {
            return a;
        }
        if (i2 != 6) {
            this.l = obj == null ? (byte) 0 : (byte) 1;
            return null;
        }
        dg bcVar = k;
        if (bcVar == null) {
            synchronized (b.class) {
                bcVar = k;
                if (bcVar == null) {
                    bcVar = new bc(a);
                    k = bcVar;
                }
            }
        }
        return bcVar;
    }
}
