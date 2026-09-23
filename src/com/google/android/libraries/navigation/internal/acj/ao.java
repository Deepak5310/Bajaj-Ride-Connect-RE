package com.google.android.libraries.navigation.internal.acj;

import com.facebook.common.callercontext.ContextChain;
import com.google.android.libraries.navigation.internal.ael.bc;
import com.google.android.libraries.navigation.internal.ael.bi;
import com.google.android.libraries.navigation.internal.ael.cz;
import com.google.android.libraries.navigation.internal.ael.dg;
import com.google.android.libraries.navigation.internal.ael.dk;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class ao extends bi implements cz {
    public static final ao a;
    private static volatile dg r;
    public int b;
    public int c;
    public int d;
    public int e;
    public int f;
    public boolean g;
    public boolean h;
    public boolean i;
    public int j;
    public int k;
    public double l;
    public double m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f169n;
    public int o;
    public d p;
    public w q;
    private byte s = 2;

    static {
        ao aoVar = new ao();
        a = aoVar;
        bi.F(ao.class, aoVar);
    }

    private ao() {
    }

    @Override // com.google.android.libraries.navigation.internal.ael.bi
    public final Object aH(int i, Object obj) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.s);
        }
        if (i2 == 2) {
            return new dk(a, "\u0004\u000f\u0000\u0001\u0001\u0013\u000f\u0000\u0000\u0000\u0001င\u0001\u0002င\u0002\u0003င\u0004\u0004ဇ\u0005\u0005ဇ\u0006\u0006င\b\u0007င\t\bင\f\tင\r\u000bဉ\u000f\u000fင\u0003\u0010ဇ\u0007\u0011က\n\u0012က\u000b\u0013ဉ\u0012", new Object[]{"b", "c", "d", "f", "g", "h", "j", "k", "n", "o", ContextChain.TAG_PRODUCT, "e", ContextChain.TAG_INFRA, "l", "m", "q"});
        }
        if (i2 == 3) {
            return new ao();
        }
        if (i2 == 4) {
            return new an();
        }
        if (i2 == 5) {
            return a;
        }
        if (i2 != 6) {
            this.s = obj == null ? (byte) 0 : (byte) 1;
            return null;
        }
        dg bcVar = r;
        if (bcVar == null) {
            synchronized (ao.class) {
                bcVar = r;
                if (bcVar == null) {
                    bcVar = new bc(a);
                    r = bcVar;
                }
            }
        }
        return bcVar;
    }
}
