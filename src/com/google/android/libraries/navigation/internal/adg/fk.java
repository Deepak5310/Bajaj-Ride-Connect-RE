package com.google.android.libraries.navigation.internal.adg;

import com.facebook.common.callercontext.ContextChain;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class fk extends com.google.android.libraries.navigation.internal.ael.bi implements com.google.android.libraries.navigation.internal.ael.cz {
    public static final fk a;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private static volatile com.google.android.libraries.navigation.internal.ael.dg f198n;
    public int b;
    public int g;
    public boolean h;
    public float k;
    public float l;
    public int m;
    public com.google.android.libraries.navigation.internal.ael.bz c = com.google.android.libraries.navigation.internal.ael.dj.b;
    public com.google.android.libraries.navigation.internal.ael.bq d = com.google.android.libraries.navigation.internal.ael.bj.a;
    public com.google.android.libraries.navigation.internal.ael.bz e = com.google.android.libraries.navigation.internal.ael.dj.b;
    public com.google.android.libraries.navigation.internal.ael.bq f = com.google.android.libraries.navigation.internal.ael.bj.a;
    public String i = "";
    public String j = "";

    static {
        fk fkVar = new fk();
        a = fkVar;
        com.google.android.libraries.navigation.internal.ael.bi.F(fk.class, fkVar);
    }

    private fk() {
    }

    @Override // com.google.android.libraries.navigation.internal.ael.bi
    public final Object aH(int i, Object obj) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return new com.google.android.libraries.navigation.internal.ael.dk(a, "\u0001\u000b\u0000\u0001\u0001\u000f\u000b\u0000\u0004\u0000\u0001\u001b\u0004င\u0002\u0005ဇ\u0003\u0006'\u0007ဈ\u0004\tဈ\u0006\u000bခ\b\fင\n\rခ\t\u000e\u001b\u000f'", new Object[]{"b", "c", id.class, "g", "h", "d", ContextChain.TAG_INFRA, "j", "k", "m", "l", "e", id.class, "f"});
        }
        if (i2 == 3) {
            return new fk();
        }
        if (i2 == 4) {
            return new fj();
        }
        if (i2 == 5) {
            return a;
        }
        if (i2 != 6) {
            throw null;
        }
        com.google.android.libraries.navigation.internal.ael.dg bcVar = f198n;
        if (bcVar == null) {
            synchronized (fk.class) {
                bcVar = f198n;
                if (bcVar == null) {
                    bcVar = new com.google.android.libraries.navigation.internal.ael.bc(a);
                    f198n = bcVar;
                }
            }
        }
        return bcVar;
    }

    public final void c() {
        com.google.android.libraries.navigation.internal.ael.bz bzVar = this.c;
        if (bzVar.c()) {
            return;
        }
        this.c = com.google.android.libraries.navigation.internal.ael.bi.A(bzVar);
    }
}
