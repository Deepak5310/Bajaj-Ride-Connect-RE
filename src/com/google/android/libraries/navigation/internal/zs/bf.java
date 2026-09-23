package com.google.android.libraries.navigation.internal.zs;

import com.facebook.common.callercontext.ContextChain;
import com.google.android.libraries.navigation.internal.acd.mk;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class bf extends com.google.android.libraries.navigation.internal.ael.bi implements com.google.android.libraries.navigation.internal.ael.cz {
    public static final bf a;
    private static volatile com.google.android.libraries.navigation.internal.ael.dg q;
    public int b;
    public int c;
    public int d;
    public int e;
    public boolean f;
    public boolean g;
    public int h;
    public int i;
    public int j;
    public int k;
    public int l;
    public boolean m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f672n;
    public com.google.android.libraries.navigation.internal.zr.q o;
    public boolean p;

    static {
        bf bfVar = new bf();
        a = bfVar;
        com.google.android.libraries.navigation.internal.ael.bi.F(bf.class, bfVar);
    }

    private bf() {
    }

    @Override // com.google.android.libraries.navigation.internal.ael.bi
    public final Object aH(int i, Object obj) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            com.google.android.libraries.navigation.internal.ael.bo boVar = com.google.android.libraries.navigation.internal.afl.cf.a;
            com.google.android.libraries.navigation.internal.ael.bo boVar2 = mk.a;
            com.google.android.libraries.navigation.internal.ael.bo boVar3 = bd.a;
            com.google.android.libraries.navigation.internal.ael.bo boVar4 = az.a;
            com.google.android.libraries.navigation.internal.ael.bo boVar5 = az.a;
            return new com.google.android.libraries.navigation.internal.ael.dk(a, "\u0001\u000e\u0000\u0001\u0001\u000e\u000e\u0000\u0000\u0000\u0001᠌\u0000\u0002᠌\u0001\u0003င\u0002\u0004ဇ\u0003\u0005ဇ\u0004\u0006᠌\u0005\u0007᠌\u0006\b᠌\u0007\t᠌\b\n᠌\t\u000bဇ\n\fဇ\u000b\rဉ\f\u000eဇ\r", new Object[]{"b", "c", boVar, "d", boVar2, "e", "f", "g", "h", boVar3, ContextChain.TAG_INFRA, boVar4, "j", boVar5, "k", boVar5, "l", bb.a, "m", "n", "o", ContextChain.TAG_PRODUCT});
        }
        if (i2 == 3) {
            return new bf();
        }
        if (i2 == 4) {
            return new ay();
        }
        if (i2 == 5) {
            return a;
        }
        if (i2 != 6) {
            throw null;
        }
        com.google.android.libraries.navigation.internal.ael.dg bcVar = q;
        if (bcVar == null) {
            synchronized (bf.class) {
                bcVar = q;
                if (bcVar == null) {
                    bcVar = new com.google.android.libraries.navigation.internal.ael.bc(a);
                    q = bcVar;
                }
            }
        }
        return bcVar;
    }
}
