package com.google.android.libraries.navigation.internal.zs;

import androidx.exifinterface.media.ExifInterface;
import com.facebook.common.callercontext.ContextChain;
import com.mappls.sdk.services.api.weather.WeatherCriteria;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class fb extends com.google.android.libraries.navigation.internal.ael.bi implements com.google.android.libraries.navigation.internal.ael.cz {
    private static volatile com.google.android.libraries.navigation.internal.ael.dg U;
    public static final fb a;
    public int A;
    public int B;
    public int C;
    public int D;
    public int E;
    public int F;
    public boolean G;
    public boolean H;
    public com.google.android.libraries.navigation.internal.zr.q I;
    public boolean J;
    public float K;
    public float L;
    public float M;
    public float N;
    public int O;
    public int P;
    public boolean Q;
    public int R = 3000;
    public int S = 3000;
    public int T = 25000;
    public int b;
    public int c;
    public boolean d;
    public boolean e;
    public int f;
    public int g;
    public int h;
    public int i;
    public int j;
    public int k;
    public int l;
    public int m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f677n;
    public int o;
    public int p;
    public boolean q;
    public boolean r;
    public boolean s;
    public int t;
    public int u;
    public boolean v;
    public int w;
    public int x;
    public int y;
    public int z;

    static {
        fb fbVar = new fb();
        a = fbVar;
        com.google.android.libraries.navigation.internal.ael.bi.F(fb.class, fbVar);
    }

    private fb() {
    }

    @Override // com.google.android.libraries.navigation.internal.ael.bi
    public final Object aH(int i, Object obj) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            com.google.android.libraries.navigation.internal.ael.bo boVar = ez.a;
            com.google.android.libraries.navigation.internal.ady.al alVar = com.google.android.libraries.navigation.internal.ady.al.DRIVE;
            return new com.google.android.libraries.navigation.internal.ael.dk(a, "\u0001+\u0000\u0002\u00013+\u0000\u0000\u0000\u0001ဇ\u0000\u0002ဇ\u0001\u0003င\u0002\u0004င\u0003\u0005င\u0004\u0006င\u0005\u0007င\u0006\bင\u0007\tင\b\nင\t\u000bင\n\fင\u000b\rင\f\u000eဇ\r\u000fဇ\u000e\u0010ဇ\u000f\u0011င\u0010\u0012င\u0011\u0013ဇ\u0012\u0014င\u0013\u0016င\u0016\u001c᠌\u001c\u001d᠌\u001d\u001eင\u0015\u001fင\u001e င\u001f!င #င\"$င#%ဇ$&ဇ%'ဉ&(ဇ')ခ(*ခ)+ခ*,ခ+-᠌,.င-0ဇ/1င02င13င2", new Object[]{"b", "c", "d", "e", "f", "g", "h", ContextChain.TAG_INFRA, "j", "k", "l", "m", "n", "o", ContextChain.TAG_PRODUCT, "q", "r", "s", "t", "u", "v", "w", "y", "z", boVar, ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, com.google.android.libraries.navigation.internal.ady.ak.a, "x", "B", WeatherCriteria.UNIT_CELSIUS, "D", ExifInterface.LONGITUDE_EAST, WeatherCriteria.UNIT_FARENHEIT, "G", "H", "I", "J", "K", "L", "M", "N", "O", ex.a, "P", "Q", "R", ExifInterface.LATITUDE_SOUTH, ExifInterface.GPS_DIRECTION_TRUE});
        }
        if (i2 == 3) {
            return new fb();
        }
        if (i2 == 4) {
            return new ew();
        }
        if (i2 == 5) {
            return a;
        }
        if (i2 != 6) {
            throw null;
        }
        com.google.android.libraries.navigation.internal.ael.dg bcVar = U;
        if (bcVar == null) {
            synchronized (fb.class) {
                bcVar = U;
                if (bcVar == null) {
                    bcVar = new com.google.android.libraries.navigation.internal.ael.bc(a);
                    U = bcVar;
                }
            }
        }
        return bcVar;
    }
}
