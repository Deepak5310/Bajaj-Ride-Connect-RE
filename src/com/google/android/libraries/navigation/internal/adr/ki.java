package com.google.android.libraries.navigation.internal.adr;

import androidx.exifinterface.media.ExifInterface;
import com.facebook.common.callercontext.ContextChain;
import com.mappls.sdk.services.api.weather.WeatherCriteria;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class ki extends com.google.android.libraries.navigation.internal.ael.bi implements com.google.android.libraries.navigation.internal.ael.cz {
    private static volatile com.google.android.libraries.navigation.internal.ael.dg B;
    public static final ki a;
    public String A;
    private int C;
    public int b;
    public boolean f;
    public Cif g;
    public ii i;
    public com.google.android.libraries.navigation.internal.adz.f j;
    public int l;
    public com.google.android.libraries.navigation.internal.ael.bz m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public el f229n;
    public cu o;
    public boolean p;
    public jg q;
    public int r;
    public String s;
    public com.google.android.libraries.navigation.internal.ael.x t;
    public com.google.android.libraries.navigation.internal.ael.x u;
    public kf v;
    public com.google.android.libraries.navigation.internal.ael.bz w;
    public int x;
    public dc y;
    public com.google.android.libraries.navigation.internal.ael.bz z;
    private byte D = 2;
    public String c = "";
    public String d = "";
    public int e = 1;
    public com.google.android.libraries.navigation.internal.ael.bz h = com.google.android.libraries.navigation.internal.ael.dj.b;
    public com.google.android.libraries.navigation.internal.ael.bz k = com.google.android.libraries.navigation.internal.ael.dj.b;

    static {
        ki kiVar = new ki();
        a = kiVar;
        com.google.android.libraries.navigation.internal.ael.bi.F(ki.class, kiVar);
    }

    private ki() {
        com.google.android.libraries.navigation.internal.ael.x xVar = com.google.android.libraries.navigation.internal.ael.x.b;
        this.m = com.google.android.libraries.navigation.internal.ael.dj.b;
        this.s = "";
        com.google.android.libraries.navigation.internal.ael.x xVar2 = com.google.android.libraries.navigation.internal.ael.x.b;
        this.t = xVar2;
        this.u = xVar2;
        this.w = com.google.android.libraries.navigation.internal.ael.dj.b;
        this.z = com.google.android.libraries.navigation.internal.ael.dj.b;
        this.A = "";
    }

    @Override // com.google.android.libraries.navigation.internal.ael.bi
    public final Object aH(int i, Object obj) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.D);
        }
        if (i2 == 2) {
            return new com.google.android.libraries.navigation.internal.ael.dk(a, "\u0001\u0017\u0000\u0002\u00013\u0017\u0000\u0005\u0006\u0001ᐉ\u0004\u0002Л\u0004ᐉ\u0005\u0005ဈ\u0000\u0006ဈ\u0001\tင\t\f\u001a\u0012ဉ\u000f\u0016ဇ\u0010\u0017ᐉ\u0011\u001aည\u0015\u001bည\u0016\u001cᐉ\u0018!င\u0012\"\u001b$᠌\u001c(ဉ\u001e*᠌\u0002.ဈ\u0013/Л0\u001b1ဈ 3ဉ\u0006", new Object[]{"b", WeatherCriteria.UNIT_CELSIUS, "g", "h", gj.class, ContextChain.TAG_INFRA, "c", "d", "l", "m", "o", ContextChain.TAG_PRODUCT, "q", "t", "u", "v", "r", "w", km.class, "x", kc.a, "y", "e", fx.a, "s", "k", el.class, "z", kh.class, ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "j"});
        }
        if (i2 == 3) {
            return new ki();
        }
        if (i2 == 4) {
            return new kb();
        }
        if (i2 == 5) {
            return a;
        }
        if (i2 != 6) {
            this.D = obj == null ? (byte) 0 : (byte) 1;
            return null;
        }
        com.google.android.libraries.navigation.internal.ael.dg bcVar = B;
        if (bcVar == null) {
            synchronized (ki.class) {
                bcVar = B;
                if (bcVar == null) {
                    bcVar = new com.google.android.libraries.navigation.internal.ael.bc(a);
                    B = bcVar;
                }
            }
        }
        return bcVar;
    }

    public final void c() {
        com.google.android.libraries.navigation.internal.ael.bz bzVar = this.h;
        if (bzVar.c()) {
            return;
        }
        this.h = com.google.android.libraries.navigation.internal.ael.bi.A(bzVar);
    }
}
