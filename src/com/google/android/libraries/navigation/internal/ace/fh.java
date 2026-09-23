package com.google.android.libraries.navigation.internal.ace;

import com.facebook.common.callercontext.ContextChain;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class fh extends com.google.android.libraries.navigation.internal.ael.bi implements com.google.android.libraries.navigation.internal.ael.cz {
    public static final fh a;
    private static volatile com.google.android.libraries.navigation.internal.ael.dg s;
    public boolean b;
    public boolean c;
    public boolean d;
    public boolean e;
    public boolean f;
    public boolean g;
    public boolean h;
    public int i;
    public boolean j;
    public boolean k;
    public boolean l;
    public boolean m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f163n;
    public boolean o;
    public boolean p;
    public boolean q;
    public boolean r;
    private int t;
    private int u;

    static {
        fh fhVar = new fh();
        a = fhVar;
        com.google.android.libraries.navigation.internal.ael.bi.F(fh.class, fhVar);
    }

    private fh() {
    }

    @Override // com.google.android.libraries.navigation.internal.ael.bi
    public final Object aH(int i, Object obj) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return new com.google.android.libraries.navigation.internal.ael.dk(a, "\u0001\u0011\u0000\u0002\u00012\u0011\u0000\u0000\u0000\u0001ဇ\u0000\u0003ဇ\u0001\u0004ဇ\u0002\u0005ဇ\u0005\u0007ဇ\u0007\tဇ\t\n᠌\n\u0011ဇ\u0013\u0015ဇ\u0003\u001fဇ\u001f\"ဇ\"'ဇ&(ဇ')ဇ(.ဇ-0ဇ\u000f2ဇ0", new Object[]{"t", "u", "b", "c", "d", "f", "g", "h", ContextChain.TAG_INFRA, fe.a, "k", "e", "l", "m", "n", "o", ContextChain.TAG_PRODUCT, "q", "j", "r"});
        }
        if (i2 == 3) {
            return new fh();
        }
        if (i2 == 4) {
            return new fg();
        }
        if (i2 == 5) {
            return a;
        }
        if (i2 != 6) {
            throw null;
        }
        com.google.android.libraries.navigation.internal.ael.dg bcVar = s;
        if (bcVar == null) {
            synchronized (fh.class) {
                bcVar = s;
                if (bcVar == null) {
                    bcVar = new com.google.android.libraries.navigation.internal.ael.bc(a);
                    s = bcVar;
                }
            }
        }
        return bcVar;
    }
}
