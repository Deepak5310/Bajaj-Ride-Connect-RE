package com.google.android.libraries.navigation.internal.ace;

import androidx.exifinterface.media.ExifInterface;
import com.facebook.common.callercontext.ContextChain;
import com.mappls.sdk.services.api.weather.WeatherCriteria;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class kx extends com.google.android.libraries.navigation.internal.ael.bi implements com.google.android.libraries.navigation.internal.ael.cz {
    private static volatile com.google.android.libraries.navigation.internal.ael.dg A;
    public static final kx a;
    private int B;
    private int C;
    private int D;
    private int E;
    private int F;
    public int b;
    public int c;
    public boolean d;
    public boolean e;
    public boolean f;
    public boolean g;
    public boolean h;
    public boolean i;
    public boolean j;
    public boolean k;
    public boolean l;
    public boolean m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f166n;
    public int o;
    public int p;
    public boolean q;
    public boolean r;
    public int s;
    public boolean t;
    public boolean u;
    public boolean v;
    public boolean w;
    public int x;
    public boolean y;
    public boolean z;

    static {
        kx kxVar = new kx();
        a = kxVar;
        com.google.android.libraries.navigation.internal.ael.bi.F(kx.class, kxVar);
    }

    private kx() {
        Object[] objArr = com.google.android.libraries.navigation.internal.ael.dj.a;
        this.o = 131072;
        this.p = 10;
        this.s = -1;
        this.x = -1;
    }

    @Override // com.google.android.libraries.navigation.internal.ael.bi
    public final Object aH(int i, Object obj) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return new com.google.android.libraries.navigation.internal.ael.dk(a, "\u0001\u0017\u0000\u0007\u0003Ù\u0017\u0000\u0000\u0000\u0003ဇ\u0002\u0004ဇ\u0003\u0005ဇ\u0004\u001eဇ# ဇ$#ဇ')ဇ-+ဇ..ဇ12ဇ5`ဇ]kငh\u0088င\u0085¢ဇ¡¤ဇ£¥င¤¦ဇ¥°ဇ®¶ဇ³·ဇ´¹ငµÓဇÏÙဇÕ", new Object[]{"b", "c", "B", WeatherCriteria.UNIT_CELSIUS, "D", ExifInterface.LONGITUDE_EAST, WeatherCriteria.UNIT_FARENHEIT, "d", "e", "f", "g", "h", ContextChain.TAG_INFRA, "j", "k", "l", "m", "n", "o", ContextChain.TAG_PRODUCT, "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"});
        }
        if (i2 == 3) {
            return new kx();
        }
        if (i2 == 4) {
            return new kw();
        }
        if (i2 == 5) {
            return a;
        }
        if (i2 != 6) {
            throw null;
        }
        com.google.android.libraries.navigation.internal.ael.dg bcVar = A;
        if (bcVar == null) {
            synchronized (kx.class) {
                bcVar = A;
                if (bcVar == null) {
                    bcVar = new com.google.android.libraries.navigation.internal.ael.bc(a);
                    A = bcVar;
                }
            }
        }
        return bcVar;
    }
}
