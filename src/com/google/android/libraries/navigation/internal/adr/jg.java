package com.google.android.libraries.navigation.internal.adr;

import com.facebook.common.callercontext.ContextChain;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class jg extends com.google.android.libraries.navigation.internal.ael.bi implements com.google.android.libraries.navigation.internal.ael.cz {
    public static final jg a;
    private static volatile com.google.android.libraries.navigation.internal.ael.dg m;
    public int b;
    public int e;
    public boolean h;
    public el i;
    public iz j;
    public jb k;
    public int l;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private byte f227n = 2;
    public String c = "";
    public String d = "";
    public com.google.android.libraries.navigation.internal.ael.bz f = com.google.android.libraries.navigation.internal.ael.dj.b;
    public com.google.android.libraries.navigation.internal.ael.x g = com.google.android.libraries.navigation.internal.ael.x.b;

    static {
        jg jgVar = new jg();
        a = jgVar;
        com.google.android.libraries.navigation.internal.ael.bi.F(jg.class, jgVar);
    }

    private jg() {
    }

    @Override // com.google.android.libraries.navigation.internal.ael.bi
    public final Object aH(int i, Object obj) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.f227n);
        }
        if (i2 == 2) {
            return new com.google.android.libraries.navigation.internal.ael.dk(a, "\u0001\n\u0000\u0001\u0002\r\n\u0000\u0001\u0001\u0002ည\u0003\u0003ᐉ\u0005\u0006ဈ\u0000\u0007ဈ\u0001\bဉ\u0006\t\u001b\nဉ\u0007\u000b᠌\u0002\fဇ\u0004\r᠌\b", new Object[]{"b", "g", ContextChain.TAG_INFRA, "c", "d", "j", "f", n.class, "k", "e", jc.a, "h", "l", iv.a});
        }
        if (i2 == 3) {
            return new jg();
        }
        if (i2 == 4) {
            return new ix();
        }
        if (i2 == 5) {
            return a;
        }
        if (i2 != 6) {
            this.f227n = obj == null ? (byte) 0 : (byte) 1;
            return null;
        }
        com.google.android.libraries.navigation.internal.ael.dg bcVar = m;
        if (bcVar == null) {
            synchronized (jg.class) {
                bcVar = m;
                if (bcVar == null) {
                    bcVar = new com.google.android.libraries.navigation.internal.ael.bc(a);
                    m = bcVar;
                }
            }
        }
        return bcVar;
    }
}
