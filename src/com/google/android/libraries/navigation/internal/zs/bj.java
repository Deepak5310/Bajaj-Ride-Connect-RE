package com.google.android.libraries.navigation.internal.zs;

import com.facebook.common.callercontext.ContextChain;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class bj extends com.google.android.libraries.navigation.internal.ael.bi implements com.google.android.libraries.navigation.internal.ael.cz {
    public static final bj a;
    private static volatile com.google.android.libraries.navigation.internal.ael.dg u;
    public int b;
    public int c;
    public boolean d;
    public long e;
    public int f;
    public int g;
    public long h;
    public int i;
    public int j;
    public int k;
    public boolean l;
    public int m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f673n;
    public int o;
    public int p;
    public int q;
    public int r;
    public fh s;
    public int t;

    static {
        bj bjVar = new bj();
        a = bjVar;
        com.google.android.libraries.navigation.internal.ael.bi.F(bj.class, bjVar);
    }

    private bj() {
    }

    @Override // com.google.android.libraries.navigation.internal.ael.bi
    public final Object aH(int i, Object obj) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            com.google.android.libraries.navigation.internal.ael.bo boVar = cq.a;
            com.google.android.libraries.navigation.internal.ady.al alVar = com.google.android.libraries.navigation.internal.ady.al.DRIVE;
            return new com.google.android.libraries.navigation.internal.ael.dk(a, "\u0001\u0012\u0000\u0001\u0001\u001d\u0012\u0000\u0000\u0000\u0001᠌\u0000\u0002ဇ\u0001\u0003ဂ\u0002\u0005ဏ\u0003\u0006ဏ\u0004\u0007ဏ\u0006\bဏ\u0007\t᠌\b\nဇ\t\u000bဏ\n\fဏ\u000b\r᠌\f\u000eဏ\r\u000fဏ\u000e\u0010ဉ\u0010\u0011င\u0011\u001cဂ\u0005\u001dဏ\u000f", new Object[]{"b", "c", boVar, "d", "e", "f", "g", ContextChain.TAG_INFRA, "j", "k", com.google.android.libraries.navigation.internal.ady.ak.a, "l", "m", "n", "o", bg.a, ContextChain.TAG_PRODUCT, "q", "s", "t", "h", "r"});
        }
        if (i2 == 3) {
            return new bj();
        }
        if (i2 == 4) {
            return new bi();
        }
        if (i2 == 5) {
            return a;
        }
        if (i2 != 6) {
            throw null;
        }
        com.google.android.libraries.navigation.internal.ael.dg bcVar = u;
        if (bcVar == null) {
            synchronized (bj.class) {
                bcVar = u;
                if (bcVar == null) {
                    bcVar = new com.google.android.libraries.navigation.internal.ael.bc(a);
                    u = bcVar;
                }
            }
        }
        return bcVar;
    }
}
