package com.google.android.libraries.navigation.internal.afm;

import com.facebook.common.callercontext.ContextChain;
import com.google.android.libraries.navigation.internal.ael.dk;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class bx extends com.google.android.libraries.navigation.internal.ael.bi implements com.google.android.libraries.navigation.internal.ael.cz {
    public static final bx a;
    private static volatile com.google.android.libraries.navigation.internal.ael.dg q;
    public int b;
    public z d;
    public int e;
    public int f;
    public bi h;
    public bo i;
    public bw j;
    public bs k;
    public boolean l;
    public boolean m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f327n;
    public int o;
    private byte r = 2;
    public String c = "";
    public int g = -1;
    public com.google.android.libraries.navigation.internal.ael.bq p = com.google.android.libraries.navigation.internal.ael.bj.a;

    static {
        bx bxVar = new bx();
        a = bxVar;
        com.google.android.libraries.navigation.internal.ael.bi.F(bx.class, bxVar);
    }

    private bx() {
    }

    @Override // com.google.android.libraries.navigation.internal.ael.bi
    public final Object aH(int i, Object obj) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.r);
        }
        if (i2 == 2) {
            return new dk(a, "\u0004\u000e\u0000\u0001\u0001@\u000e\u0000\u0001\u0003\u0001ဈ\u0000\u0002ᐉ\u0001\u0011ထ\u0005!ᐑ\u00071ဇ\t2ဇ\n3ဇ\u000b4င\u00045ᐑ\b:င\f;ࠞ=ထ\u0006?င\u0002@᠌\u0003", new Object[]{"b", "c", "d", "h", "j", "l", "m", "n", "g", "k", "o", ContextChain.TAG_PRODUCT, bj.a, ContextChain.TAG_INFRA, "e", "f", bl.a});
        }
        if (i2 == 3) {
            return new bx();
        }
        if (i2 == 4) {
            return new be();
        }
        if (i2 == 5) {
            return a;
        }
        if (i2 != 6) {
            this.r = obj == null ? (byte) 0 : (byte) 1;
            return null;
        }
        com.google.android.libraries.navigation.internal.ael.dg bcVar = q;
        if (bcVar == null) {
            synchronized (bx.class) {
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
