package com.google.android.libraries.navigation.internal.afl;

import com.facebook.common.callercontext.ContextChain;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class ah extends com.google.android.libraries.navigation.internal.ael.bi implements com.google.android.libraries.navigation.internal.ael.cz {
    public static final ah a;
    private static volatile com.google.android.libraries.navigation.internal.ael.dg p;
    public int b;
    public boolean c;
    public boolean d;
    public boolean e;
    public boolean f;
    public boolean g;
    public com.google.android.libraries.navigation.internal.adi.ab h;
    public boolean j;
    public com.google.android.libraries.navigation.internal.ace.fw k;
    public String i = "";
    public String l = "";
    public String m = "";

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public String f296n = "";
    public String o = "";

    static {
        ah ahVar = new ah();
        a = ahVar;
        com.google.android.libraries.navigation.internal.ael.bi.F(ah.class, ahVar);
    }

    private ah() {
    }

    public static /* synthetic */ void e(ah ahVar) {
        ahVar.b |= 8;
        ahVar.f = true;
    }

    public static /* synthetic */ void g(ah ahVar) {
        ahVar.b |= 1;
        ahVar.c = true;
    }

    @Override // com.google.android.libraries.navigation.internal.ael.bi
    public final Object aH(int i, Object obj) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return new com.google.android.libraries.navigation.internal.ael.dk(a, "\u0001\r\u0000\u0001\u0001\u000e\r\u0000\u0000\u0000\u0001ဇ\u0000\u0002ဇ\u0001\u0003ဇ\u0003\u0004ဉ\u0005\u0005ဈ\u0006\u0006ဇ\u0004\bဉ\t\tဇ\u0002\nဈ\n\u000bဈ\u000b\fဈ\f\rဈ\r\u000eဇ\b", new Object[]{"b", "c", "d", "f", "h", ContextChain.TAG_INFRA, "g", "k", "e", "l", "m", "n", "o", "j"});
        }
        if (i2 == 3) {
            return new ah();
        }
        if (i2 == 4) {
            return new ag();
        }
        if (i2 == 5) {
            return a;
        }
        if (i2 != 6) {
            throw null;
        }
        com.google.android.libraries.navigation.internal.ael.dg bcVar = p;
        if (bcVar == null) {
            synchronized (ah.class) {
                bcVar = p;
                if (bcVar == null) {
                    bcVar = new com.google.android.libraries.navigation.internal.ael.bc(a);
                    p = bcVar;
                }
            }
        }
        return bcVar;
    }
}
