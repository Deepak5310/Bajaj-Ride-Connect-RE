package com.google.android.libraries.navigation.internal.acu;

import com.facebook.common.callercontext.ContextChain;
import com.google.android.libraries.navigation.internal.ael.cz;
import com.google.android.libraries.navigation.internal.ael.dg;
import com.google.android.libraries.navigation.internal.ael.dk;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class bv extends com.google.android.libraries.navigation.internal.ael.bi implements cz {
    public static final bv a;
    private static volatile dg m;
    public long b;
    public long c;
    public long d;
    public int e;
    public int f;
    public boolean g;
    public boolean h;
    public int i;
    public int j;
    public int k;
    public int l;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private int f175n;

    static {
        bv bvVar = new bv();
        a = bvVar;
        com.google.android.libraries.navigation.internal.ael.bi.F(bv.class, bvVar);
    }

    private bv() {
    }

    @Override // com.google.android.libraries.navigation.internal.ael.bi
    public final Object aH(int i, Object obj) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return new dk(a, "\u0004\u000b\u0000\u0001\u0002\f\u000b\u0000\u0000\u0000\u0002ဂ\u0002\u0003င\u0005\u0004ဇ\u0006\u0005ဇ\u0007\u0006င\b\u0007င\t\bင\n\tင\u000b\nဂ\u0001\u000bဂ\u0003\fင\u0004", new Object[]{"n", "c", "f", "g", "h", ContextChain.TAG_INFRA, "j", "k", "l", "b", "d", "e"});
        }
        if (i2 == 3) {
            return new bv();
        }
        if (i2 == 4) {
            return new bu();
        }
        if (i2 == 5) {
            return a;
        }
        if (i2 != 6) {
            throw null;
        }
        dg bcVar = m;
        if (bcVar == null) {
            synchronized (bv.class) {
                bcVar = m;
                if (bcVar == null) {
                    bcVar = new com.google.android.libraries.navigation.internal.ael.bc(a);
                    m = bcVar;
                }
            }
        }
        return bcVar;
    }
}
