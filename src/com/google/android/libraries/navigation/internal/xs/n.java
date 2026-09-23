package com.google.android.libraries.navigation.internal.xs;

import com.facebook.common.callercontext.ContextChain;
import com.google.android.libraries.navigation.internal.ael.bc;
import com.google.android.libraries.navigation.internal.ael.bi;
import com.google.android.libraries.navigation.internal.ael.bj;
import com.google.android.libraries.navigation.internal.ael.bq;
import com.google.android.libraries.navigation.internal.ael.br;
import com.google.android.libraries.navigation.internal.ael.bz;
import com.google.android.libraries.navigation.internal.ael.cz;
import com.google.android.libraries.navigation.internal.ael.dg;
import com.google.android.libraries.navigation.internal.ael.dj;
import com.google.android.libraries.navigation.internal.ael.dk;
import com.google.android.libraries.navigation.internal.ael.x;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class n extends bi implements cz {
    public static final br a = new l();
    public static final n b;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private static volatile dg f653n;
    public int c;
    public boolean e;
    public long g;
    public r k;
    public boolean l;
    public boolean m;
    public x d = x.b;
    public String f = "";
    public bz h = dj.b;
    public bz i = dj.b;
    public bq j = bj.a;

    static {
        n nVar = new n();
        b = nVar;
        bi.F(n.class, nVar);
    }

    private n() {
    }

    @Override // com.google.android.libraries.navigation.internal.ael.bi
    public final Object aH(int i, Object obj) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return new dk(b, "\u0004\n\u0000\u0001\u0001\u000b\n\u0000\u0003\u0000\u0001ည\u0000\u0002ဇ\u0001\u0003ဈ\u0002\u0004ဂ\u0003\u0005\u001a\u0006\u001a\u0007ࠬ\bဉ\u0004\nဇ\u0005\u000bဇ\u0006", new Object[]{"c", "d", "e", "f", "g", "h", ContextChain.TAG_INFRA, "j", com.google.android.libraries.navigation.internal.aae.a.a, "k", "l", "m"});
        }
        if (i2 == 3) {
            return new n();
        }
        if (i2 == 4) {
            return new m();
        }
        if (i2 == 5) {
            return b;
        }
        if (i2 != 6) {
            throw null;
        }
        dg bcVar = f653n;
        if (bcVar == null) {
            synchronized (n.class) {
                bcVar = f653n;
                if (bcVar == null) {
                    bcVar = new bc(b);
                    f653n = bcVar;
                }
            }
        }
        return bcVar;
    }
}
