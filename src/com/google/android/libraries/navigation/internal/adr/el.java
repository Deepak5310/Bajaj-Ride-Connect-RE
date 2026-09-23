package com.google.android.libraries.navigation.internal.adr;

import com.facebook.common.callercontext.ContextChain;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class el extends com.google.android.libraries.navigation.internal.ael.bi<el, dx> implements com.google.android.libraries.navigation.internal.ael.cz {
    public static final el a;
    private static volatile com.google.android.libraries.navigation.internal.ael.dg z;
    public int b;
    public Object d;
    public int g;
    public com.google.android.libraries.navigation.internal.adq.aj k;
    public com.google.android.libraries.navigation.internal.aap.r l;
    public com.google.android.libraries.navigation.internal.aap.r m;
    public com.google.android.libraries.navigation.internal.adq.z r;
    public com.google.android.libraries.navigation.internal.adq.z s;
    public ah v;
    public ah w;
    public int x;
    public ft y;
    public int c = 0;
    private byte A = 2;
    public String e = "";
    public int f = 2;
    public String h = "";
    public String i = "";
    public String j = "";

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public com.google.android.libraries.navigation.internal.ael.bz f221n = com.google.android.libraries.navigation.internal.ael.dj.b;
    public com.google.android.libraries.navigation.internal.ael.bz o = com.google.android.libraries.navigation.internal.ael.dj.b;
    public com.google.android.libraries.navigation.internal.ael.bz p = com.google.android.libraries.navigation.internal.ael.dj.b;
    public com.google.android.libraries.navigation.internal.ael.bz q = com.google.android.libraries.navigation.internal.ael.dj.b;
    public String t = "";
    public int u = 127;

    /* JADX INFO: compiled from: PG */
    public enum a implements com.google.android.libraries.navigation.internal.ael.bm {
        ALERT(0),
        WARNING(1),
        INFORMATION(2),
        CRITICAL(3);

        public final int e;

        a(int i) {
            this.e = i;
        }

        public static a b(int i) {
            if (i == 0) {
                return ALERT;
            }
            if (i == 1) {
                return WARNING;
            }
            if (i == 2) {
                return INFORMATION;
            }
            if (i != 3) {
                return null;
            }
            return CRITICAL;
        }

        @Override // com.google.android.libraries.navigation.internal.ael.bm
        public final int a() {
            return this.e;
        }

        @Override // java.lang.Enum
        public final String toString() {
            return Integer.toString(this.e);
        }
    }

    static {
        el elVar = new el();
        a = elVar;
        com.google.android.libraries.navigation.internal.ael.bi.F(el.class, elVar);
    }

    private el() {
    }

    @Override // com.google.android.libraries.navigation.internal.ael.bi
    public final Object aH(int i, Object obj) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.A);
        }
        if (i2 == 2) {
            a aVar = a.ALERT;
            return new com.google.android.libraries.navigation.internal.ael.dk(a, "\u0001\u001f\u0001\u0001\u0001$\u001f\u0000\u0004\n\u0001᠌\u0002\u0002ဈ\u0004\u0003ဈ\u0005\u0004ဈ\u0006\u0005ဉ\u0007\u0007ဉ\t\bဉ\n\t᠌\u0003\nဉ\f\u000bဉ\r\fဈ\u000e\r᠌\u000f\u000eᐉ\u0010\u000fᐉ\u0011\u0010᠌\u0012\u0011ᐉ\u0013\u0012<\u0000\u0014Л\u0015Л\u0016м\u0000\u0017<\u0000\u0018Л\u0019м\u0000\u001aЛ\u001b<\u0000\u001c<\u0000\u001d<\u0000\u001eм\u0000\u001f<\u0000 ဈ\u0001$<\u0000", new Object[]{"d", "c", "b", "f", ek.a, "h", ContextChain.TAG_INFRA, "j", "k", "l", "m", "g", fo.a, "r", "s", "t", "u", dn.a, "v", "w", "x", em.a, "y", eq.class, "n", gn.class, ContextChain.TAG_PRODUCT, gn.class, fh.class, es.class, "o", gn.class, fn.class, "q", gn.class, eb.class, fj.class, dz.class, ef.class, ej.class, "e", mc.class});
        }
        if (i2 == 3) {
            return new el();
        }
        if (i2 == 4) {
            return new dx();
        }
        if (i2 == 5) {
            return a;
        }
        if (i2 != 6) {
            this.A = obj == null ? (byte) 0 : (byte) 1;
            return null;
        }
        com.google.android.libraries.navigation.internal.ael.dg bcVar = z;
        if (bcVar == null) {
            synchronized (el.class) {
                bcVar = z;
                if (bcVar == null) {
                    bcVar = new com.google.android.libraries.navigation.internal.ael.bc(a);
                    z = bcVar;
                }
            }
        }
        return bcVar;
    }
}
