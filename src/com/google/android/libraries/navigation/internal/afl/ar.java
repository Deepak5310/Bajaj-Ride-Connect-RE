package com.google.android.libraries.navigation.internal.afl;

import androidx.exifinterface.media.ExifInterface;
import com.facebook.common.callercontext.ContextChain;
import com.mappls.sdk.services.api.weather.WeatherCriteria;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class ar extends com.google.android.libraries.navigation.internal.ael.bi implements com.google.android.libraries.navigation.internal.ael.cz {
    private static volatile com.google.android.libraries.navigation.internal.ael.dg J;
    public static final ar a;
    public int A;
    public int B;
    public int C;
    public boolean D;
    public int E;
    public int F;
    public com.google.android.libraries.navigation.internal.ael.bz G;
    public com.google.android.libraries.navigation.internal.acd.l H;
    public long I;
    private boolean K;
    private boolean M;
    public int b;
    public int c;
    public int d;
    public boolean i;
    public boolean k;
    public boolean m;
    public af o;
    public com.google.android.libraries.navigation.internal.ael.bq p;
    public String q;
    public boolean r;
    public boolean s;
    public boolean t;
    public String u;
    public String v;
    public String w;
    public String x;
    public long y;
    public int z;
    public String e = "";
    public String f = "";
    public String g = "";
    public String h = "";
    public String j = "";
    private String L = "";
    public String l = "";

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f297n = 1;

    static {
        ar arVar = new ar();
        a = arVar;
        com.google.android.libraries.navigation.internal.ael.bi.F(ar.class, arVar);
    }

    private ar() {
        com.google.android.libraries.navigation.internal.ael.bj bjVar = com.google.android.libraries.navigation.internal.ael.bj.a;
        Object[] objArr = com.google.android.libraries.navigation.internal.ael.dj.a;
        this.p = com.google.android.libraries.navigation.internal.ael.bj.a;
        this.q = "";
        this.s = true;
        this.t = true;
        this.u = "";
        this.v = "";
        this.w = "";
        this.x = "";
        this.G = com.google.android.libraries.navigation.internal.ael.dj.b;
    }

    public static /* synthetic */ void e(ar arVar) {
        arVar.b |= 65536;
        arVar.L = "SYSTEM";
    }

    public static /* synthetic */ void g(ar arVar) {
        arVar.b |= 134217728;
        arVar.M = false;
    }

    public static /* synthetic */ void h(ar arVar) {
        arVar.b |= 256;
        arVar.K = true;
    }

    public static /* synthetic */ void i(ar arVar) {
        arVar.b |= 2048;
        arVar.i = true;
    }

    @Override // com.google.android.libraries.navigation.internal.ael.bi
    public final Object aH(int i, Object obj) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return new com.google.android.libraries.navigation.internal.ael.dk(a, "\u0001!\u0000\u0003\u0001M!\u0000\u0002\u0000\u0001ဈ\u0000\u0004ဇ\b\u0005ဈ\n\u0006ဈ\u0002\u0007ဇ\u000b\bဈ\f\tဈ\u0004\nဇ\u000e\u000eင*\u0012ဈ\u0010\u0013ဈ\u0011\u0016᠌\u0015\u001bဈ\u0019\u001dဇ\u001b ဇ\u001f!ဇ &ဈ%'ဈ&(ဈ'/င-0င.3ဉ\u0016;'<ဇ\u0013=᠌:>᠌;@\u001aBဈ(Cဂ)D᠌+Fဉ>LဂCMဇ\u001c", new Object[]{"b", "c", "d", "e", "K", "h", "f", ContextChain.TAG_INFRA, "j", "g", "k", "z", "L", "l", "n", ap.a, "q", "M", "s", "t", "u", "v", "w", "B", WeatherCriteria.UNIT_CELSIUS, "o", ContextChain.TAG_PRODUCT, "m", ExifInterface.LONGITUDE_EAST, ac.a, WeatherCriteria.UNIT_FARENHEIT, aa.a, "G", "x", "y", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, in.a, "H", "I", "r"});
        }
        if (i2 == 3) {
            return new ar();
        }
        if (i2 == 4) {
            return new ao();
        }
        if (i2 == 5) {
            return a;
        }
        if (i2 != 6) {
            throw null;
        }
        com.google.android.libraries.navigation.internal.ael.dg bcVar = J;
        if (bcVar == null) {
            synchronized (ar.class) {
                bcVar = J;
                if (bcVar == null) {
                    bcVar = new com.google.android.libraries.navigation.internal.ael.bc(a);
                    J = bcVar;
                }
            }
        }
        return bcVar;
    }
}
