package com.google.android.libraries.navigation.internal.zr;

import androidx.exifinterface.media.ExifInterface;
import com.facebook.common.callercontext.ContextChain;
import com.mappls.sdk.services.api.weather.WeatherCriteria;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class de extends com.google.android.libraries.navigation.internal.ael.bi implements com.google.android.libraries.navigation.internal.ael.cz {
    public static final de a;
    private static volatile com.google.android.libraries.navigation.internal.ael.dg ao;
    public boolean A;
    public boolean B;
    public int C;
    public am D;
    public am E;
    public am F;
    public am G;
    public am H;
    public am I;
    public int J;
    public int K;
    public int L;
    public int M;
    public int N;
    public int O;
    public d P;
    public int T;
    public int U;
    public int V;
    public int W;
    public int X;
    public int Y;
    public int Z;
    public int aa;
    public int ac;
    public int ad;
    public cx af;
    public boolean ah;
    public boolean aj;
    public int b;
    public int c;
    public int d;
    public int e;
    public int f;
    public int g;
    public int h;
    public int i;
    public int j;
    public int k;
    public dq l;
    public int m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f670n;
    public int o;
    public int p;
    public int q;
    public int r;
    public int t;
    public boolean u;
    public int v;
    public boolean x;
    public int y;
    public int z;
    public com.google.android.libraries.navigation.internal.ael.bz s = com.google.android.libraries.navigation.internal.ael.dj.b;
    public com.google.android.libraries.navigation.internal.ael.bz w = com.google.android.libraries.navigation.internal.ael.dj.b;
    public com.google.android.libraries.navigation.internal.ael.bz Q = com.google.android.libraries.navigation.internal.ael.dj.b;
    public String R = "";
    public String S = "";
    public String ab = "";
    public com.google.android.libraries.navigation.internal.ael.bz ae = com.google.android.libraries.navigation.internal.ael.dj.b;
    public String ag = "";
    public com.google.android.libraries.navigation.internal.ael.bz ai = com.google.android.libraries.navigation.internal.ael.dj.b;

    static {
        de deVar = new de();
        a = deVar;
        com.google.android.libraries.navigation.internal.ael.bi.F(de.class, deVar);
    }

    private de() {
    }

    @Override // com.google.android.libraries.navigation.internal.ael.bi
    public final Object aH(int i, Object obj) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            com.google.android.libraries.navigation.internal.ady.al alVar = com.google.android.libraries.navigation.internal.ady.al.DRIVE;
            return new com.google.android.libraries.navigation.internal.ael.dk(a, "\u0001:\u0000\u0003\u0001X:\u0000\u0005\u0000\u0001᠌\u0001\u0002င\u0002\u0003င\u0003\u0004င\b\u0005င\u000b\u0006င\u000e\bင\u0012\tဇ\u0013\nင\u0014\u000b\u001b\fဇ\u0018\u000f᠌\"\u0010ဉ#\u0011ဉ$\u0012ဉ%\u0013ဈ0\u0014ဈ1\u0015င3\u0016င5\u0018\u001b\u001aင\u0004\u001bင\u0005\u001cဉ&\u001dဉ(\u001fင) င*!င\u0006\"ဉ\u0007#င7$င8%ဇ!&᠌\u0000'င,(င-)᠌\u001b*ဉD+\u001b/င\f0င\r2င\t7ဇ\u001e:ဈI?\u001b@ငBAငCBဉ'Cင+Dင.Eင4Fင9JဇNKဈALဉ/Mင:Nင;V\u001bW᠌\u0019XဇO", new Object[]{"b", "c", "d", "f", com.google.android.libraries.navigation.internal.ady.ak.a, "g", "h", "m", "o", "r", "t", "u", "v", "w", dd.class, "x", WeatherCriteria.UNIT_CELSIUS, cm.a, "D", ExifInterface.LONGITUDE_EAST, WeatherCriteria.UNIT_FARENHEIT, "R", ExifInterface.LATITUDE_SOUTH, ExifInterface.GPS_DIRECTION_TRUE, ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "s", cv.class, ContextChain.TAG_INFRA, "j", "G", "I", "J", "K", "k", "l", ExifInterface.LONGITUDE_WEST, "X", "B", "e", cq.a, "M", "N", "z", bv.a, "af", "Q", cp.class, ContextChain.TAG_PRODUCT, "q", "n", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "ag", "ae", db.class, "ac", "ad", "H", "L", "O", "U", "Y", "ah", "ab", "P", "Z", "aa", "ai", cl.class, "y", bx.a, "aj"});
        }
        if (i2 == 3) {
            return new de();
        }
        if (i2 == 4) {
            return new cj();
        }
        if (i2 == 5) {
            return a;
        }
        if (i2 != 6) {
            throw null;
        }
        com.google.android.libraries.navigation.internal.ael.dg bcVar = ao;
        if (bcVar == null) {
            synchronized (de.class) {
                bcVar = ao;
                if (bcVar == null) {
                    bcVar = new com.google.android.libraries.navigation.internal.ael.bc(a);
                    ao = bcVar;
                }
            }
        }
        return bcVar;
    }
}
