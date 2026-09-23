package com.google.android.libraries.navigation.internal.afm;

import com.facebook.common.callercontext.ContextChain;
import com.google.android.libraries.navigation.internal.ael.dk;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class cl extends com.google.android.libraries.navigation.internal.ael.bi implements com.google.android.libraries.navigation.internal.ael.cz {
    public static final cl a;
    private static volatile com.google.android.libraries.navigation.internal.ael.dg k;
    public int b;
    public bd d;
    public ce e;
    public ck f;
    public cg g;
    public cc h;
    public boolean j;
    private byte l = 2;
    public String c = "";
    public String i = "";

    static {
        cl clVar = new cl();
        a = clVar;
        com.google.android.libraries.navigation.internal.ael.bi.F(cl.class, clVar);
    }

    private cl() {
    }

    @Override // com.google.android.libraries.navigation.internal.ael.bi
    public final Object aH(int i, Object obj) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.l);
        }
        if (i2 == 2) {
            return new dk(a, "\u0004\b\u0000\u0001\u0002D\b\u0000\u0000\u0005\u0002ဈ\u0000\u0003ᐉ\u0001\u0011ᐑ\u0003\u001bᐑ\u0002!ဈ\u0006\"ဇ\u0007#ᐑ\u0004Dᐑ\u0005", new Object[]{"b", "c", "d", "f", "e", ContextChain.TAG_INFRA, "j", "g", "h"});
        }
        if (i2 == 3) {
            return new cl();
        }
        if (i2 == 4) {
            return new by();
        }
        if (i2 == 5) {
            return a;
        }
        if (i2 != 6) {
            this.l = obj == null ? (byte) 0 : (byte) 1;
            return null;
        }
        com.google.android.libraries.navigation.internal.ael.dg bcVar = k;
        if (bcVar == null) {
            synchronized (cl.class) {
                bcVar = k;
                if (bcVar == null) {
                    bcVar = new com.google.android.libraries.navigation.internal.ael.bc(a);
                    k = bcVar;
                }
            }
        }
        return bcVar;
    }
}
