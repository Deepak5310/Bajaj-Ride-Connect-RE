package com.google.android.libraries.navigation.internal.acd;

import com.facebook.common.callercontext.ContextChain;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class ub extends com.google.android.libraries.navigation.internal.ael.bi implements com.google.android.libraries.navigation.internal.ael.cz {
    public static final ub a;
    private static volatile com.google.android.libraries.navigation.internal.ael.dg l;
    public int b;
    public com.google.android.libraries.navigation.internal.adq.al c;
    public int d;
    public int e;
    public int f;
    public long g;
    public long h;
    public com.google.android.libraries.navigation.internal.adu.ak i;
    public com.google.android.libraries.navigation.internal.aed.d j;
    public com.google.android.libraries.navigation.internal.adx.b k;
    private oz m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private byte f160n = 2;

    static {
        ub ubVar = new ub();
        a = ubVar;
        com.google.android.libraries.navigation.internal.ael.bi.F(ub.class, ubVar);
    }

    private ub() {
    }

    @Override // com.google.android.libraries.navigation.internal.ael.bi
    public final Object aH(int i, Object obj) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.f160n);
        }
        if (i2 == 2) {
            com.google.android.libraries.navigation.internal.ael.bo boVar = com.google.android.libraries.navigation.internal.adu.v.a;
            com.google.android.libraries.navigation.internal.ael.bo boVar2 = com.google.android.libraries.navigation.internal.adu.t.a;
            com.google.android.libraries.navigation.internal.adu.y yVar = com.google.android.libraries.navigation.internal.adu.y.UNKNOWN_INCIDENT_TYPE;
            return new com.google.android.libraries.navigation.internal.ael.dk(a, "\u0001\n\u0000\u0001\u0001\u000b\n\u0000\u0000\u0001\u0001ᐉ\u0000\u0002᠌\u0001\u0003᠌\u0002\u0004စ\u0004\u0005ဉ\n\u0006စ\u0005\u0007᠌\u0003\bဉ\u0006\nဉ\b\u000bဉ\t", new Object[]{"b", "c", "d", boVar, "e", boVar2, "g", "m", "h", "f", com.google.android.libraries.navigation.internal.adu.x.a, ContextChain.TAG_INFRA, "j", "k"});
        }
        if (i2 == 3) {
            return new ub();
        }
        if (i2 == 4) {
            return new ua();
        }
        if (i2 == 5) {
            return a;
        }
        if (i2 != 6) {
            this.f160n = obj == null ? (byte) 0 : (byte) 1;
            return null;
        }
        com.google.android.libraries.navigation.internal.ael.dg bcVar = l;
        if (bcVar == null) {
            synchronized (ub.class) {
                bcVar = l;
                if (bcVar == null) {
                    bcVar = new com.google.android.libraries.navigation.internal.ael.bc(a);
                    l = bcVar;
                }
            }
        }
        return bcVar;
    }
}
