package com.google.android.libraries.navigation.internal.adq;

import com.facebook.common.callercontext.ContextChain;
import com.google.android.libraries.navigation.internal.ael.bi;
import com.google.android.libraries.navigation.internal.ael.bj;
import com.google.android.libraries.navigation.internal.ael.cz;
import com.google.android.libraries.navigation.internal.ael.dg;
import com.google.android.libraries.navigation.internal.ael.dj;
import com.google.android.libraries.navigation.internal.ael.dk;
import com.google.android.libraries.navigation.internal.zr.ds;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class al extends bi implements cz {
    public static final al a;
    private static volatile dg j;
    public int b;
    public int e;
    public boolean f;
    public boolean g;
    public int h;
    public ds i;
    private com.google.android.libraries.navigation.internal.zt.b k;
    private byte l = 2;
    public String c = "";
    public String d = "";

    static {
        al alVar = new al();
        a = alVar;
        bi.F(al.class, alVar);
    }

    private al() {
        bj bjVar = bj.a;
        Object[] objArr = dj.a;
    }

    @Override // com.google.android.libraries.navigation.internal.ael.bi
    public final Object aH(int i, Object obj) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.l);
        }
        if (i2 == 2) {
            return new dk(a, "\u0001\u0007\u0000\u0001\u0004\u001b\u0007\u0000\u0000\u0001\u0004ᐉ\u0004\u0007᠌\u0010\tဈ\u0001\u000fင\u0006\u0011ဈ\u0000\u0014ဇ\t\u001bဉ\u0016", new Object[]{"b", "k", "h", u.a, "d", "e", "c", "f", ContextChain.TAG_INFRA});
        }
        if (i2 == 3) {
            return new al();
        }
        if (i2 == 4) {
            return new ak();
        }
        if (i2 == 5) {
            return a;
        }
        if (i2 != 6) {
            this.l = obj == null ? (byte) 0 : (byte) 1;
            return null;
        }
        dg bcVar = j;
        if (bcVar == null) {
            synchronized (al.class) {
                bcVar = j;
                if (bcVar == null) {
                    bcVar = new com.google.android.libraries.navigation.internal.ael.bc(a);
                    j = bcVar;
                }
            }
        }
        return bcVar;
    }
}
