package com.google.android.libraries.navigation.internal.adl;

import com.facebook.common.callercontext.ContextChain;
import com.google.android.libraries.navigation.internal.adg.ga;
import com.google.android.libraries.navigation.internal.adg.hm;
import com.google.android.libraries.navigation.internal.adg.jg;
import com.google.android.libraries.navigation.internal.adg.ji;
import com.google.android.libraries.navigation.internal.adg.jq;
import com.google.android.libraries.navigation.internal.ael.bc;
import com.google.android.libraries.navigation.internal.ael.bi;
import com.google.android.libraries.navigation.internal.ael.bz;
import com.google.android.libraries.navigation.internal.ael.cz;
import com.google.android.libraries.navigation.internal.ael.dg;
import com.google.android.libraries.navigation.internal.ael.dj;
import com.google.android.libraries.navigation.internal.ael.dk;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class u extends bi implements cz {
    public static final u a;
    private static volatile dg k;
    public int b;
    public hm c;
    public int d;
    public com.google.android.libraries.navigation.internal.aeg.d e;
    public int f;
    public int g;
    public int h;
    public int j;
    private byte l = 2;
    public bz i = dj.b;

    static {
        u uVar = new u();
        a = uVar;
        bi.F(u.class, uVar);
    }

    private u() {
    }

    @Override // com.google.android.libraries.navigation.internal.ael.bi
    public final Object aH(int i, Object obj) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.l);
        }
        if (i2 == 2) {
            return new dk(a, "\u0001\b\u0000\u0001\u0002\u000b\b\u0000\u0001\u0003\u0002ᐉ\u0001\u0003င\u0002\u0004ᐉ\u0003\u0005᠌\u0004\u0006Л\u0007᠌\u0005\b᠌\u0006\u000bင\t", new Object[]{"b", "c", "d", "e", "f", ji.a, ContextChain.TAG_INFRA, ga.class, "g", jg.a, "h", jq.a, "j"});
        }
        if (i2 == 3) {
            return new u();
        }
        if (i2 == 4) {
            return new t();
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
            synchronized (u.class) {
                bcVar = k;
                if (bcVar == null) {
                    bcVar = new bc(a);
                    k = bcVar;
                }
            }
        }
        return bcVar;
    }

    public final void c() {
        bz bzVar = this.i;
        if (bzVar.c()) {
            return;
        }
        this.i = bi.A(bzVar);
    }
}
