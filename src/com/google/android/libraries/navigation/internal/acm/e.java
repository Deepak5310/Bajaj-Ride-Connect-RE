package com.google.android.libraries.navigation.internal.acm;

import com.facebook.common.callercontext.ContextChain;
import com.google.android.libraries.navigation.internal.ael.bc;
import com.google.android.libraries.navigation.internal.ael.bi;
import com.google.android.libraries.navigation.internal.ael.bj;
import com.google.android.libraries.navigation.internal.ael.bq;
import com.google.android.libraries.navigation.internal.ael.br;
import com.google.android.libraries.navigation.internal.ael.cz;
import com.google.android.libraries.navigation.internal.ael.dg;
import com.google.android.libraries.navigation.internal.ael.dj;
import com.google.android.libraries.navigation.internal.ael.dk;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class e extends bi implements cz {
    public static final br a = new a();
    public static final e b;
    private static volatile dg j;
    public boolean c;
    public boolean d;
    public boolean e;
    public boolean f;
    public bq g;
    public boolean h;
    public boolean i;
    private int k;

    static {
        e eVar = new e();
        b = eVar;
        bi.F(e.class, eVar);
    }

    private e() {
        Object[] objArr = dj.a;
        this.g = bj.a;
    }

    @Override // com.google.android.libraries.navigation.internal.ael.bi
    public final Object aH(int i, Object obj) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return new dk(b, "\u0004\u0006\u0000\u0001\u0001\r\u0006\u0000\u0000\u0000\u0001ဇ\u0000\u0002ဇ\u0001\u0005ဇ\u0002\tဇ\b\u000bဇ\t\rဇ\u0003", new Object[]{"k", "c", "d", "e", "h", ContextChain.TAG_INFRA, "f"});
        }
        if (i2 == 3) {
            return new e();
        }
        if (i2 == 4) {
            return new b();
        }
        if (i2 == 5) {
            return b;
        }
        if (i2 != 6) {
            throw null;
        }
        dg bcVar = j;
        if (bcVar == null) {
            synchronized (e.class) {
                bcVar = j;
                if (bcVar == null) {
                    bcVar = new bc(b);
                    j = bcVar;
                }
            }
        }
        return bcVar;
    }
}
