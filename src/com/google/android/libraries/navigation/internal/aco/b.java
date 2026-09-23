package com.google.android.libraries.navigation.internal.aco;

import com.facebook.common.callercontext.ContextChain;
import com.google.android.libraries.navigation.internal.ael.bc;
import com.google.android.libraries.navigation.internal.ael.bi;
import com.google.android.libraries.navigation.internal.ael.cz;
import com.google.android.libraries.navigation.internal.ael.dg;
import com.google.android.libraries.navigation.internal.ael.dk;
import com.google.android.libraries.navigation.internal.ael.x;
import com.google.android.libraries.navigation.internal.aes.h;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class b extends bi implements cz {
    public static final b a;
    private static volatile dg j;
    public int b;
    public h e;
    public h f;
    public boolean i;
    public String c = "";
    public String d = "";
    public x g = x.b;
    public String h = "";

    static {
        b bVar = new b();
        a = bVar;
        bi.F(b.class, bVar);
    }

    private b() {
    }

    @Override // com.google.android.libraries.navigation.internal.ael.bi
    public final Object aH(int i, Object obj) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return new dk(a, "\u0004\u0006\u0000\u0001\u0001\t\u0006\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဈ\u0001\u0003ဉ\u0002\u0005ဈ\u0006\u0006ဇ\u0007\tည\u0004", new Object[]{"b", "c", "d", "e", "h", ContextChain.TAG_INFRA, "g"});
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
            throw null;
        }
        dg bcVar = j;
        if (bcVar == null) {
            synchronized (b.class) {
                bcVar = j;
                if (bcVar == null) {
                    bcVar = new bc(a);
                    j = bcVar;
                }
            }
        }
        return bcVar;
    }
}
