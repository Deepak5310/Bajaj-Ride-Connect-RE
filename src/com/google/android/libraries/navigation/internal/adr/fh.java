package com.google.android.libraries.navigation.internal.adr;

import com.facebook.common.callercontext.ContextChain;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class fh extends com.google.android.libraries.navigation.internal.ael.bi implements com.google.android.libraries.navigation.internal.ael.cz {
    public static final fh a;
    private static volatile com.google.android.libraries.navigation.internal.ael.dg s;
    public int b;
    public com.google.android.libraries.navigation.internal.aap.d d;
    public bm e;
    public com.google.android.libraries.navigation.internal.aap.d f;
    public float g;
    public com.google.android.libraries.navigation.internal.aap.d h;
    public ex i;
    public fg k;
    public gn l;
    public fb m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public ez f222n;
    public gn o;
    public n p;
    public int q;
    private byte t = 2;
    public String c = "";
    public com.google.android.libraries.navigation.internal.ael.bz j = com.google.android.libraries.navigation.internal.ael.dj.b;
    public com.google.android.libraries.navigation.internal.ael.bz r = com.google.android.libraries.navigation.internal.ael.dj.b;

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
            return Byte.valueOf(this.t);
        }
        if (i2 == 2) {
            return new com.google.android.libraries.navigation.internal.ael.dk(a, "\u0001\u0010\u0000\u0001\u0001\u0012\u0010\u0000\u0002\u0002\u0001ဉ\u0002\u0002ဉ\u0004\u0003ဉ\b\u0004\u001a\u0006ဉ\t\u0007ဈ\u0000\tဉ\u0005\nခ\u0006\u000bဉ\u0007\fဉ\u000b\rဉ\u000e\u000e᠌\u000f\u000f\u001b\u0010ᐉ\n\u0011ဉ\f\u0012ᐉ\r", new Object[]{"b", "d", "e", ContextChain.TAG_INFRA, "j", "k", "c", "f", "g", "h", "m", ContextChain.TAG_PRODUCT, "q", et.a, "r", com.google.android.libraries.navigation.internal.ady.k.class, "l", "n", "o"});
        }
        if (i2 == 3) {
            return new fh();
        }
        if (i2 == 4) {
            return new ev();
        }
        if (i2 == 5) {
            return a;
        }
        if (i2 != 6) {
            this.t = obj == null ? (byte) 0 : (byte) 1;
            return null;
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
