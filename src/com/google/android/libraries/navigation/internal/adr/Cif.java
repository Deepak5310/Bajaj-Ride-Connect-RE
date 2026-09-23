package com.google.android.libraries.navigation.internal.adr;

import com.facebook.common.callercontext.ContextChain;

/* JADX INFO: renamed from: com.google.android.libraries.navigation.internal.adr.if, reason: invalid class name */
/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class Cif extends com.google.android.libraries.navigation.internal.ael.bi<Cif, ie> implements com.google.android.libraries.navigation.internal.ael.cz {
    public static final Cif a;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private static volatile com.google.android.libraries.navigation.internal.ael.dg f226n;
    public int b;
    public int c;
    public bm e;
    public com.google.android.libraries.navigation.internal.aap.d f;
    public jm g;
    public cm i;
    public ap j;
    public p k;
    public com.google.android.libraries.navigation.internal.ady.x l;
    private byte o = 2;
    public String d = "";
    public com.google.android.libraries.navigation.internal.ael.bz h = com.google.android.libraries.navigation.internal.ael.dj.b;
    public com.google.android.libraries.navigation.internal.ael.bz m = com.google.android.libraries.navigation.internal.ael.dj.b;

    static {
        Cif cif = new Cif();
        a = cif;
        com.google.android.libraries.navigation.internal.ael.bi.F(Cif.class, cif);
    }

    private Cif() {
    }

    @Override // com.google.android.libraries.navigation.internal.ael.bi
    public final Object aH(int i, Object obj) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.o);
        }
        if (i2 == 2) {
            com.google.android.libraries.navigation.internal.ady.al alVar = com.google.android.libraries.navigation.internal.ady.al.DRIVE;
            return new com.google.android.libraries.navigation.internal.ael.dk(a, "\u0001\u000b\u0000\u0001\u0001\u0012\u000b\u0000\u0002\u0005\u0001᠌\u0000\u0002ဈ\u0001\u0003ဉ\u0002\u0004ဉ\u0003\u0007ᐉ\u0005\nЛ\u000bᐉ\b\fဉ\r\u000fЛ\u0011ဉ\n\u0012ᐉ\u000b", new Object[]{"b", "c", com.google.android.libraries.navigation.internal.ady.ak.a, "d", "e", "f", "g", "h", el.class, ContextChain.TAG_INFRA, "l", "m", gn.class, "j", "k"});
        }
        if (i2 == 3) {
            return new Cif();
        }
        if (i2 == 4) {
            return new ie();
        }
        if (i2 == 5) {
            return a;
        }
        if (i2 != 6) {
            this.o = obj == null ? (byte) 0 : (byte) 1;
            return null;
        }
        com.google.android.libraries.navigation.internal.ael.dg bcVar = f226n;
        if (bcVar == null) {
            synchronized (Cif.class) {
                bcVar = f226n;
                if (bcVar == null) {
                    bcVar = new com.google.android.libraries.navigation.internal.ael.bc(a);
                    f226n = bcVar;
                }
            }
        }
        return bcVar;
    }
}
