package com.google.android.libraries.navigation.internal.adl;

import com.facebook.common.callercontext.ContextChain;
import com.google.android.libraries.navigation.internal.ael.bc;
import com.google.android.libraries.navigation.internal.ael.bi;
import com.google.android.libraries.navigation.internal.ael.cz;
import com.google.android.libraries.navigation.internal.ael.dg;
import com.google.android.libraries.navigation.internal.ael.dk;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class x extends bi implements cz {
    public static final x a;
    private static volatile dg p;
    public int b;
    public int c = 0;
    public Object d;
    public boolean e;
    public boolean f;
    public boolean g;
    public s h;
    public boolean i;
    public boolean j;
    public boolean k;
    public boolean l;
    public boolean m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f213n;
    public boolean o;

    static {
        x xVar = new x();
        a = xVar;
        bi.F(x.class, xVar);
    }

    private x() {
    }

    public static /* synthetic */ void c(x xVar) {
        xVar.b |= 32;
        xVar.i = true;
    }

    @Override // com.google.android.libraries.navigation.internal.ael.bi
    public final Object aH(int i, Object obj) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return new dk(a, "\u0004\u0019\u0001\u0001\u0001&\u0019\u0000\u0000\u0000\u0001:\u0000\u0002<\u0000\u0004<\u0000\u0005<\u0000\u0006ဇ\u0000\u0007ဇ\u0001\tဇ\u0003\n:\u0000\u000bဉ\u0004\fဇ\u0005\u000eဇ\u0007\u000fဇ\b\u0010:\u0000\u0011:\u0000\u0012:\u0000\u0013:\u0000\u0014ဇ\t\u0015:\u0000\u0016:\u0000\u0017ဇ\n\u0018ဇ\u000b\u001cဇ\u0010#<\u0000%6\u0000&:\u0000", new Object[]{"d", "c", "b", al.class, m.class, ah.class, "e", "f", "g", "h", ContextChain.TAG_INFRA, "j", "k", "l", "m", "n", "o", ay.class});
        }
        if (i2 == 3) {
            return new x();
        }
        if (i2 == 4) {
            return new v();
        }
        if (i2 == 5) {
            return a;
        }
        if (i2 != 6) {
            throw null;
        }
        dg bcVar = p;
        if (bcVar == null) {
            synchronized (x.class) {
                bcVar = p;
                if (bcVar == null) {
                    bcVar = new bc(a);
                    p = bcVar;
                }
            }
        }
        return bcVar;
    }
}
