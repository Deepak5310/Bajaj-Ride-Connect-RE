package com.google.android.libraries.navigation.internal.dm;

import com.facebook.common.callercontext.ContextChain;
import com.google.android.libraries.navigation.internal.ael.bc;
import com.google.android.libraries.navigation.internal.ael.bi;
import com.google.android.libraries.navigation.internal.ael.cz;
import com.google.android.libraries.navigation.internal.ael.dg;
import com.google.android.libraries.navigation.internal.ael.dk;
import com.google.android.libraries.navigation.internal.ael.x;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class s extends bi implements cz {
    public static final s a;
    private static volatile dg q;
    public int b;
    public o c;
    public int d;
    public int e;
    public int f;
    public int g;
    public long h;
    public long i;
    public int j;
    public int k;
    public long m;
    public boolean o;
    public long p;
    private byte r = 2;
    public String l = "";

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public x f400n = x.b;

    static {
        s sVar = new s();
        a = sVar;
        bi.F(s.class, sVar);
    }

    private s() {
    }

    @Override // com.google.android.libraries.navigation.internal.ael.bi
    public final Object aH(int i, Object obj) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.r);
        }
        if (i2 == 2) {
            return new dk(a, "\u0004\u000e\u0000\u0001\u0001\u000e\u000e\u0000\u0000\u0001\u0001ᐉ\u0000\u0002င\u0001\u0003င\u0002\u0004င\u0003\u0005င\u0004\u0006ဂ\u0005\u0007ဂ\u0006\bင\u0007\tင\b\nဈ\t\u000bဂ\n\fည\u000b\rဇ\f\u000eဂ\r", new Object[]{"b", "c", "d", "e", "f", "g", "h", ContextChain.TAG_INFRA, "j", "k", "l", "m", "n", "o", ContextChain.TAG_PRODUCT});
        }
        if (i2 == 3) {
            return new s();
        }
        if (i2 == 4) {
            return new r();
        }
        if (i2 == 5) {
            return a;
        }
        if (i2 != 6) {
            this.r = obj == null ? (byte) 0 : (byte) 1;
            return null;
        }
        dg bcVar = q;
        if (bcVar == null) {
            synchronized (s.class) {
                bcVar = q;
                if (bcVar == null) {
                    bcVar = new bc(a);
                    q = bcVar;
                }
            }
        }
        return bcVar;
    }
}
