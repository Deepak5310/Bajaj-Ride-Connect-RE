package com.google.android.libraries.navigation.internal.afm;

import com.facebook.common.callercontext.ContextChain;
import com.google.android.libraries.navigation.internal.ael.dk;
import com.google.firebase.perf.util.Constants;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class aq extends com.google.android.libraries.navigation.internal.ael.bi implements com.google.android.libraries.navigation.internal.ael.cz {
    public static final aq a;
    private static volatile com.google.android.libraries.navigation.internal.ael.dg t;
    public int b;
    public boolean c;
    public int d;
    public int f;
    public int g;
    public z l;
    public int p;
    public int q;
    public int s;
    private byte u = 2;
    public int e = Constants.MAX_URL_LENGTH;
    public int h = 512;
    public int i = 512;
    public String j = "";
    public int k = 4;
    public String m = "";

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public String f326n = "";
    public String o = "";
    public int r = 1;

    static {
        aq aqVar = new aq();
        a = aqVar;
        com.google.android.libraries.navigation.internal.ael.bi.F(aq.class, aqVar);
    }

    private aq() {
    }

    @Override // com.google.android.libraries.navigation.internal.ael.bi
    public final Object aH(int i, Object obj) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.u);
        }
        if (i2 == 2) {
            return new dk(a, "\u0004\u0011\u0000\u0001\u0002=\u0011\u0000\u0000\u0006\u0002ဇ\u0000\u0003င\u0001\u0004ᔄ\u0003\u0005ᔄ\u0004\u0006င\u0005\u0007င\u0006\bᔈ\u0007\tင\b\nᔉ\t\u000bဈ\n\fဈ\u000b\rဈ\f\u000eᔄ\r\u000fᔄ\u000e\u0010᠌\u000f\u0011င\u0002=᠌\u0010", new Object[]{"b", "c", "d", "f", "g", "h", ContextChain.TAG_INFRA, "j", "k", "l", "m", "n", "o", ContextChain.TAG_PRODUCT, "q", "r", ar.a, "e", "s", bb.a});
        }
        if (i2 == 3) {
            return new aq();
        }
        if (i2 == 4) {
            return new ap();
        }
        if (i2 == 5) {
            return a;
        }
        if (i2 != 6) {
            this.u = obj == null ? (byte) 0 : (byte) 1;
            return null;
        }
        com.google.android.libraries.navigation.internal.ael.dg bcVar = t;
        if (bcVar == null) {
            synchronized (aq.class) {
                bcVar = t;
                if (bcVar == null) {
                    bcVar = new com.google.android.libraries.navigation.internal.ael.bc(a);
                    t = bcVar;
                }
            }
        }
        return bcVar;
    }
}
