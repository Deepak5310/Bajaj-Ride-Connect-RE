package com.google.android.libraries.navigation.internal.afk;

import com.facebook.common.callercontext.ContextChain;
import com.google.android.libraries.navigation.internal.ael.bc;
import com.google.android.libraries.navigation.internal.ael.be;
import com.google.android.libraries.navigation.internal.ael.bf;
import com.google.android.libraries.navigation.internal.ael.bi;
import com.google.android.libraries.navigation.internal.ael.bj;
import com.google.android.libraries.navigation.internal.ael.dg;
import com.google.android.libraries.navigation.internal.ael.dj;
import com.google.android.libraries.navigation.internal.ael.dk;
import com.google.android.libraries.navigation.internal.ael.x;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class b extends be implements bf {
    public static final b a;
    private static volatile dg k;
    public int b;
    public long c;
    public long d;
    public int e;
    public x f;
    public long g;
    public boolean h;
    public double i;
    public g j;
    private byte l = 2;

    static {
        b bVar = new b();
        a = bVar;
        bi.F(b.class, bVar);
    }

    private b() {
        Object[] objArr = dj.a;
        x xVar = x.b;
        this.f = x.b;
        this.g = 180000L;
        bj bjVar = bj.a;
    }

    @Override // com.google.android.libraries.navigation.internal.ael.bi
    public final Object aH(int i, Object obj) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.l);
        }
        if (i2 == 2) {
            return new dk(a, "\u0001\b\u0000\u0001\u0001!\b\u0000\u0000\u0001\u0001ဂ\u0000\u0006ည\u000b\u000bင\u0005\u000fတ\u0011\u0011ဂ\u0001\u0019ဇ\u0017 က\u001a!ᐉ\u001c", new Object[]{"b", "c", "f", "e", "g", "d", "h", ContextChain.TAG_INFRA, "j"});
        }
        if (i2 == 3) {
            return new b();
        }
        if (i2 == 4) {
            return new a();
        }
        if (i2 == 5) {
            return a;
        }
        if (i2 != 6) {
            this.l = obj == null ? (byte) 0 : (byte) 1;
            return null;
        }
        dg bcVar = k;
        if (bcVar == null) {
            synchronized (b.class) {
                bcVar = k;
                if (bcVar == null) {
                    bcVar = new bc(a);
                    k = bcVar;
                }
            }
        }
        return bcVar;
    }
}
