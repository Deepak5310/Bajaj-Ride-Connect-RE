package com.google.android.libraries.navigation.internal.acj;

import com.facebook.common.callercontext.ContextChain;
import com.google.android.libraries.navigation.internal.adr.ii;
import com.google.android.libraries.navigation.internal.ael.bc;
import com.google.android.libraries.navigation.internal.ael.bi;
import com.google.android.libraries.navigation.internal.ael.bz;
import com.google.android.libraries.navigation.internal.ael.cz;
import com.google.android.libraries.navigation.internal.ael.dg;
import com.google.android.libraries.navigation.internal.ael.dj;
import com.google.android.libraries.navigation.internal.ael.dk;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class au extends bi implements cz {
    public static final au a;
    private static volatile dg u;
    public int b;
    public int c;
    public boolean d;
    public int e;
    public com.google.android.libraries.navigation.internal.adr.ab f;
    public boolean h;
    public long i;
    public ii k;
    public boolean m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public com.google.android.libraries.navigation.internal.afj.b f170n;
    public com.google.android.libraries.navigation.internal.aci.b o;
    public com.google.android.libraries.navigation.internal.aci.b p;
    public int q;
    public int r;
    public int s;
    public boolean t;
    private byte v = 2;
    public bz g = dj.b;
    public String j = "";
    public bz l = dj.b;

    static {
        au auVar = new au();
        a = auVar;
        bi.F(au.class, auVar);
    }

    private au() {
    }

    @Override // com.google.android.libraries.navigation.internal.ael.bi
    public final Object aH(int i, Object obj) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.v);
        }
        if (i2 == 2) {
            com.google.android.libraries.navigation.internal.ady.al alVar = com.google.android.libraries.navigation.internal.ady.al.DRIVE;
            return new dk(a, "\u0004\u0012\u0000\u0001\u0001\u0012\u0012\u0000\u0002\u0001\u0001᠌\u0000\u0002ဇ\u0001\u0003င\u0002\u0004ဉ\u0003\u0005\u001b\u0006ဇ\u0004\u0007ဂ\u0005\bᐉ\u0007\t\u001b\nဇ\b\u000bဉ\t\f᠌\f\r᠌\r\u000eင\u000e\u000fဇ\u000f\u0010ဉ\n\u0011ဉ\u000b\u0012ለ\u0006", new Object[]{"b", "c", com.google.android.libraries.navigation.internal.ady.ak.a, "d", "e", "f", "g", am.class, "h", ContextChain.TAG_INFRA, "k", "l", aw.class, "m", "n", "q", as.a, "r", aq.a, "s", "t", "o", ContextChain.TAG_PRODUCT, "j"});
        }
        if (i2 == 3) {
            return new au();
        }
        if (i2 == 4) {
            return new ap();
        }
        if (i2 == 5) {
            return a;
        }
        if (i2 != 6) {
            this.v = obj == null ? (byte) 0 : (byte) 1;
            return null;
        }
        dg bcVar = u;
        if (bcVar == null) {
            synchronized (au.class) {
                bcVar = u;
                if (bcVar == null) {
                    bcVar = new bc(a);
                    u = bcVar;
                }
            }
        }
        return bcVar;
    }
}
