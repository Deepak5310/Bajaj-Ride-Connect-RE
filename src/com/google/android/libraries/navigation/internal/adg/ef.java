package com.google.android.libraries.navigation.internal.adg;

import com.facebook.common.callercontext.ContextChain;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class ef extends com.google.android.libraries.navigation.internal.ael.be implements ei {
    public static final ef a;
    private static volatile com.google.android.libraries.navigation.internal.ael.dg x;
    public int b;
    public dt c;
    public dt d;
    public d e;
    public gq f;
    public int h;
    public int i;
    public int j;
    public int k;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f186n;
    public int o;
    public fs u;
    public int v;
    private byte y = 2;
    public int g = 9;
    public int l = -1;
    public long m = -1;
    public com.google.android.libraries.navigation.internal.ael.bq p = com.google.android.libraries.navigation.internal.ael.bj.a;
    public com.google.android.libraries.navigation.internal.ael.bz q = com.google.android.libraries.navigation.internal.ael.dj.b;
    public com.google.android.libraries.navigation.internal.ael.bz r = com.google.android.libraries.navigation.internal.ael.dj.b;
    public com.google.android.libraries.navigation.internal.ael.bz s = com.google.android.libraries.navigation.internal.ael.dj.b;
    public com.google.android.libraries.navigation.internal.ael.bz t = com.google.android.libraries.navigation.internal.ael.dj.b;

    static {
        ef efVar = new ef();
        a = efVar;
        com.google.android.libraries.navigation.internal.ael.bi.F(ef.class, efVar);
    }

    private ef() {
    }

    @Override // com.google.android.libraries.navigation.internal.ael.bi
    public final Object aH(int i, Object obj) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.y);
        }
        if (i2 == 2) {
            return new com.google.android.libraries.navigation.internal.ael.dk(a, "\u0001\u0014\u0000\u0001\u0001Ϩ\u0014\u0000\u0005\u0006\u0001ᐉ\u0000\u0002ᐉ\u0001\u0003ᐉ\u0003\u0004ᐉ\u0004\u0005ဂ\r\u0007᠌\u0005\bင\f\tင\u000e\nဆ\u000f\u000bင\u0007\fင\b\rင\t\u000eင\u0006\u0010'\u0011\u001b\u0012Л\u0013\u001b\u0014\u001b\u0016ᐉ\u0010Ϩင\u0012", new Object[]{"b", "c", "d", "e", "f", "m", "g", ed.a, "l", "n", "o", ContextChain.TAG_INFRA, "j", "k", "h", ContextChain.TAG_PRODUCT, "q", w.class, "r", ea.class, "s", ec.class, "t", by.class, "u", "v"});
        }
        if (i2 == 3) {
            return new ef();
        }
        if (i2 == 4) {
            return new dy();
        }
        if (i2 == 5) {
            return a;
        }
        if (i2 != 6) {
            this.y = obj == null ? (byte) 0 : (byte) 1;
            return null;
        }
        com.google.android.libraries.navigation.internal.ael.dg bcVar = x;
        if (bcVar == null) {
            synchronized (ef.class) {
                bcVar = x;
                if (bcVar == null) {
                    bcVar = new com.google.android.libraries.navigation.internal.ael.bc(a);
                    x = bcVar;
                }
            }
        }
        return bcVar;
    }

    @Override // com.google.android.libraries.navigation.internal.adg.ei
    public final dt c() {
        dt dtVar = this.c;
        return dtVar == null ? dt.a : dtVar;
    }

    @Override // com.google.android.libraries.navigation.internal.adg.ei
    public final dt d() {
        dt dtVar = this.d;
        return dtVar == null ? dt.a : dtVar;
    }

    @Override // com.google.android.libraries.navigation.internal.adg.ei
    public final boolean e() {
        return (this.b & 2) != 0;
    }
}
