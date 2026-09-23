package com.google.android.libraries.navigation.internal.aez;

import com.facebook.common.callercontext.ContextChain;
import com.google.android.libraries.navigation.internal.ael.cz;
import com.google.android.libraries.navigation.internal.ael.dg;
import com.google.android.libraries.navigation.internal.ael.dk;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class b extends com.google.android.libraries.navigation.internal.ael.bi implements cz {
    public static final b a;
    private static volatile dg b;
    private int c;
    private int d;
    private bf e;
    private j f;
    private v g;
    private bp h;
    private r i;
    private l j;
    private bj k;
    private bn l;
    private aj m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private t f250n;
    private d o;
    private ad p;
    private ah q;
    private z r;
    private af s;
    private x t;
    private ab u;
    private p v;
    private byte w = 2;

    static {
        b bVar = new b();
        a = bVar;
        com.google.android.libraries.navigation.internal.ael.bi.F(b.class, bVar);
    }

    private b() {
    }

    @Override // com.google.android.libraries.navigation.internal.ael.bi
    public final Object aH(int i, Object obj) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.w);
        }
        if (i2 == 2) {
            return new dk(a, "\u0004\u0012\u0000\u0002\u0001/\u0012\u0000\u0000\u000f\u0001ᐉ\u0000\u0002ᐉ\u0001\u0003ᐉ\u0002\u0006ᐉ\u0005\u000fᐉ\u000e\u0010ᐉ\u000f\u0012ᐉ\u0011\u0015ᐉ\u0014\u0017ဉ\u0016\u0018ᐉ\u0017\u001eᐉ\u001c\u001fဉ\u001d!ဉ\u001f'ᐉ%+ᐉ),ᐉ*-ᐉ+/ᐉ-", new Object[]{"c", "d", "e", "f", "g", "h", ContextChain.TAG_INFRA, "j", "k", "l", "m", "n", "o", ContextChain.TAG_PRODUCT, "q", "r", "s", "t", "u", "v"});
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
            this.w = obj == null ? (byte) 0 : (byte) 1;
            return null;
        }
        dg bcVar = b;
        if (bcVar == null) {
            synchronized (b.class) {
                bcVar = b;
                if (bcVar == null) {
                    bcVar = new com.google.android.libraries.navigation.internal.ael.bc(a);
                    b = bcVar;
                }
            }
        }
        return bcVar;
    }
}
