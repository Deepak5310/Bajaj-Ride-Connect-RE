package com.google.android.libraries.navigation.internal.zp;

import com.facebook.common.callercontext.ContextChain;
import com.google.android.libraries.navigation.internal.ael.cz;
import com.google.android.libraries.navigation.internal.ael.dg;
import com.google.android.libraries.navigation.internal.ael.dk;
import com.google.android.libraries.navigation.internal.zr.cg;
import com.google.android.libraries.navigation.internal.zr.ev;
import com.google.android.libraries.navigation.internal.zr.ex;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class bk extends com.google.android.libraries.navigation.internal.ael.bi implements cz {
    public static final bk a;
    private static volatile dg g;
    public int b;
    public com.google.android.libraries.navigation.internal.zr.bm c;
    public com.google.android.libraries.navigation.internal.zr.aq d;
    public cg e;
    public com.google.android.libraries.navigation.internal.zq.d f;
    private int h;
    private com.google.android.libraries.navigation.internal.zq.f i;
    private bm j;
    private com.google.android.libraries.navigation.internal.zr.b k;
    private com.google.android.libraries.navigation.internal.zr.ay l;
    private ev m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private ex f666n;
    private byte o = 2;

    static {
        bk bkVar = new bk();
        a = bkVar;
        com.google.android.libraries.navigation.internal.ael.bi.F(bk.class, bkVar);
    }

    private bk() {
        com.google.android.libraries.navigation.internal.ael.bj bjVar = com.google.android.libraries.navigation.internal.ael.bj.a;
    }

    @Override // com.google.android.libraries.navigation.internal.ael.bi
    public final Object aH(int i, Object obj) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.o);
        }
        if (i2 == 2) {
            return new dk(a, "\u0004\n\u0000\u0002\u0004/\n\u0000\u0000\u0002\u0004ဉ\u0003\nဉ\u0007\rဉ\n\u000fᐉ\u000e\u0013ᐉ\u0012\u001fဉ\u001f%ဉ#+ဉ)-ဉ+/ဉ-", new Object[]{"b", "h", "c", "d", "e", ContextChain.TAG_INFRA, "j", "f", "k", "l", "m", "n"});
        }
        if (i2 == 3) {
            return new bk();
        }
        if (i2 == 4) {
            return new bj();
        }
        if (i2 == 5) {
            return a;
        }
        if (i2 != 6) {
            this.o = obj == null ? (byte) 0 : (byte) 1;
            return null;
        }
        dg bcVar = g;
        if (bcVar == null) {
            synchronized (bk.class) {
                bcVar = g;
                if (bcVar == null) {
                    bcVar = new com.google.android.libraries.navigation.internal.ael.bc(a);
                    g = bcVar;
                }
            }
        }
        return bcVar;
    }
}
