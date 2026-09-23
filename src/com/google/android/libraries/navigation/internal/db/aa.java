package com.google.android.libraries.navigation.internal.db;

import com.facebook.common.callercontext.ContextChain;
import com.google.android.libraries.navigation.internal.ael.bc;
import com.google.android.libraries.navigation.internal.ael.bi;
import com.google.android.libraries.navigation.internal.ael.cz;
import com.google.android.libraries.navigation.internal.ael.dg;
import com.google.android.libraries.navigation.internal.ael.dk;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class aa extends bi implements cz {
    public static final aa a;
    private static volatile dg j;
    public int b;
    public long c;
    public double d;
    public double e;
    public float f;
    public float g;
    public float h;
    public float i;

    static {
        aa aaVar = new aa();
        a = aaVar;
        bi.F(aa.class, aaVar);
    }

    private aa() {
    }

    @Override // com.google.android.libraries.navigation.internal.ael.bi
    public final Object aH(int i, Object obj) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return new dk(a, "\u0004\u0007\u0000\u0001\u0001\t\u0007\u0000\u0000\u0000\u0001ဂ\u0000\u0002က\u0001\u0003က\u0002\u0004ခ\u0003\u0006ခ\u0005\bခ\u0007\tခ\b", new Object[]{"b", "c", "d", "e", "f", "g", "h", ContextChain.TAG_INFRA});
        }
        if (i2 == 3) {
            return new aa();
        }
        if (i2 == 4) {
            return new z();
        }
        if (i2 == 5) {
            return a;
        }
        if (i2 != 6) {
            throw null;
        }
        dg bcVar = j;
        if (bcVar == null) {
            synchronized (aa.class) {
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
