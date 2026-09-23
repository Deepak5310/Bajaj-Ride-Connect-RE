package com.google.android.libraries.navigation.internal.gd;

import com.facebook.common.callercontext.ContextChain;
import com.google.android.libraries.navigation.internal.ael.bc;
import com.google.android.libraries.navigation.internal.ael.bi;
import com.google.android.libraries.navigation.internal.ael.cz;
import com.google.android.libraries.navigation.internal.ael.dg;
import com.google.android.libraries.navigation.internal.ael.dk;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class i extends bi implements cz {
    public static final i a;
    private static volatile dg m;
    public int b;
    public boolean c;
    public boolean d;
    public boolean e;
    public boolean f;
    public boolean g;
    public boolean h = true;
    public boolean i;
    public boolean j;
    public int k;
    public boolean l;

    static {
        i iVar = new i();
        a = iVar;
        bi.F(i.class, iVar);
    }

    private i() {
    }

    public static /* synthetic */ void b(i iVar) {
        iVar.b |= 4;
        iVar.e = false;
    }

    @Override // com.google.android.libraries.navigation.internal.ael.bi
    public final Object aH(int i, Object obj) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return new dk(a, "\u0004\n\u0000\u0001\u0002\u000b\n\u0000\u0000\u0000\u0002ဇ\u0000\u0003ဇ\u0001\u0004ဇ\u0005\u0005ဇ\u0002\u0006ဇ\u0003\u0007ဇ\u0004\bဇ\u0007\t᠌\b\nဇ\t\u000bဇ\u0006", new Object[]{"b", "c", "d", "h", "e", "f", "g", "j", "k", g.a, "l", ContextChain.TAG_INFRA});
        }
        if (i2 == 3) {
            return new i();
        }
        if (i2 == 4) {
            return new f();
        }
        if (i2 == 5) {
            return a;
        }
        if (i2 != 6) {
            throw null;
        }
        dg bcVar = m;
        if (bcVar == null) {
            synchronized (i.class) {
                bcVar = m;
                if (bcVar == null) {
                    bcVar = new bc(a);
                    m = bcVar;
                }
            }
        }
        return bcVar;
    }
}
