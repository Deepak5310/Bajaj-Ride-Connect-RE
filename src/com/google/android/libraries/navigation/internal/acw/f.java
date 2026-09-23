package com.google.android.libraries.navigation.internal.acw;

import com.facebook.common.callercontext.ContextChain;
import com.google.android.libraries.navigation.internal.ael.bc;
import com.google.android.libraries.navigation.internal.ael.bi;
import com.google.android.libraries.navigation.internal.ael.bz;
import com.google.android.libraries.navigation.internal.ael.cz;
import com.google.android.libraries.navigation.internal.ael.dg;
import com.google.android.libraries.navigation.internal.ael.dj;
import com.google.android.libraries.navigation.internal.ael.dk;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class f extends bi implements cz {
    public static final f a;
    private static volatile dg j;
    public int b;
    public int g;
    public int h;
    public com.google.android.libraries.navigation.internal.aax.f i;
    private byte k = 2;
    public String c = "";
    public bz d = dj.b;
    public String e = "";
    public String f = "";

    static {
        f fVar = new f();
        a = fVar;
        bi.F(f.class, fVar);
    }

    private f() {
    }

    @Override // com.google.android.libraries.navigation.internal.ael.bi
    public final Object aH(int i, Object obj) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.k);
        }
        if (i2 == 2) {
            return new dk(a, "\u0004\u0007\u0000\u0001\u0001\b\u0007\u0000\u0001\u0001\u0001ဈ\u0000\u0002\u001a\u0003ဈ\u0001\u0004ဈ\u0002\u0005ဏ\u0003\u0007ᐉ\u0005\bဏ\u0004", new Object[]{"b", "c", "d", "e", "f", "g", ContextChain.TAG_INFRA, "h"});
        }
        if (i2 == 3) {
            return new f();
        }
        if (i2 == 4) {
            return new e();
        }
        if (i2 == 5) {
            return a;
        }
        if (i2 != 6) {
            this.k = obj == null ? (byte) 0 : (byte) 1;
            return null;
        }
        dg bcVar = j;
        if (bcVar == null) {
            synchronized (f.class) {
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
