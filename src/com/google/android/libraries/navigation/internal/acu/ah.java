package com.google.android.libraries.navigation.internal.acu;

import androidx.exifinterface.media.ExifInterface;
import com.facebook.common.callercontext.ContextChain;
import com.google.android.libraries.navigation.internal.ael.cm;
import com.google.android.libraries.navigation.internal.ael.cz;
import com.google.android.libraries.navigation.internal.ael.dg;
import com.google.android.libraries.navigation.internal.ael.dj;
import com.google.android.libraries.navigation.internal.ael.dk;
import com.mappls.sdk.services.api.weather.WeatherCriteria;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class ah extends com.google.android.libraries.navigation.internal.ael.bi implements cz {
    private static volatile dg V;
    public static final ah a;
    public boolean A;
    public boolean C;
    public boolean D;
    public boolean E;
    public boolean F;
    public float G;
    public com.google.android.libraries.navigation.internal.zr.d H;
    public long I;
    public ad K;
    public com.google.android.libraries.navigation.internal.db.aq L;
    public ch M;
    public int N;
    public com.google.android.apps.gmm.location.navigation.cb Q;
    public bx R;
    public cf U;
    public int b;
    public int c;
    public aj d;
    public com.google.android.libraries.navigation.internal.db.aa e;
    public float f;
    public float g;
    public boolean h;
    public double j;
    public double k;
    public int l;
    public int m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public double f172n;
    public int o;
    public float q;
    public int r;
    public com.google.android.libraries.navigation.internal.db.ae s;
    public com.google.android.libraries.navigation.internal.adj.d t;
    public int v;
    public int w;
    public int x;
    public int y;
    public int z;
    private byte W = 2;
    public com.google.android.libraries.navigation.internal.ael.bz i = dj.b;
    public String p = "";
    public String u = "";
    public com.google.android.libraries.navigation.internal.ael.bz B = dj.b;
    public com.google.android.libraries.navigation.internal.ael.bz J = dj.b;
    public com.google.android.libraries.navigation.internal.ael.bt O = cm.a;
    public com.google.android.libraries.navigation.internal.ael.bt P = cm.a;
    public com.google.android.libraries.navigation.internal.ael.bz S = dj.b;
    public String T = "";

    static {
        ah ahVar = new ah();
        a = ahVar;
        com.google.android.libraries.navigation.internal.ael.bi.F(ah.class, ahVar);
    }

    private ah() {
    }

    @Override // com.google.android.libraries.navigation.internal.ael.bi
    public final Object aH(int i, Object obj) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.W);
        }
        if (i2 == 2) {
            return new dk(a, "\u0004,\u0000\u0002\u0001O,\u0000\u0006\u0001\u0001ဉ\u0000\u0002ဉ\u0001\u0005ခ\u0002\u0006ခ\u0003\u0007ဇ\u0004\b\u001b\u000fက\u0007\u0010က\b\u0011ဍ\t\u0012ဍ\n\u0013က\u000b\u0014ဍ\f\u0015ဈ\r\u0016ခ\u000e\u0017ဍ\u000f\u0018ဉ\u0010\u0019ᐉ\u0011\u001aဈ\u0012\u001eဍ\u0013\u001fဍ\u0014 ဍ\u0015!ဍ\u0016\"ဍ\u0017#ဇ\u0018(\u001b-ဇ\u0019.ဇ\u001a/ဇ\u001b0ဇ\u001c1ခ\u001d3ဉ\u001f4ဎ 5\u001b7ဉ!9ဉ\"<ဉ%Aဍ&B.C.Fဉ'Kဉ(L\u001bMဈ)Oဉ+", new Object[]{"b", "c", "d", "e", "f", "g", "h", ContextChain.TAG_INFRA, com.google.android.libraries.navigation.internal.zr.bq.class, "j", "k", "l", "m", "n", "o", ContextChain.TAG_PRODUCT, "q", "r", "s", "t", "u", "v", "w", "x", "y", "z", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "B", aq.class, WeatherCriteria.UNIT_CELSIUS, "D", ExifInterface.LONGITUDE_EAST, WeatherCriteria.UNIT_FARENHEIT, "G", "H", "I", "J", am.class, "K", "L", "M", "N", "O", "P", "Q", "R", ExifInterface.LATITUDE_SOUTH, l.class, ExifInterface.GPS_DIRECTION_TRUE, "U"});
        }
        if (i2 == 3) {
            return new ah();
        }
        if (i2 == 4) {
            return new ag();
        }
        if (i2 == 5) {
            return a;
        }
        if (i2 != 6) {
            this.W = obj == null ? (byte) 0 : (byte) 1;
            return null;
        }
        dg bcVar = V;
        if (bcVar == null) {
            synchronized (ah.class) {
                bcVar = V;
                if (bcVar == null) {
                    bcVar = new com.google.android.libraries.navigation.internal.ael.bc(a);
                    V = bcVar;
                }
            }
        }
        return bcVar;
    }
}
