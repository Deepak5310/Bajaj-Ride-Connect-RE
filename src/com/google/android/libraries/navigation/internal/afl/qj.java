package com.google.android.libraries.navigation.internal.afl;

import androidx.exifinterface.media.ExifInterface;
import com.facebook.common.callercontext.ContextChain;
import com.mappls.sdk.services.api.weather.WeatherCriteria;
import org.joda.time.DateTimeConstants;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class qj extends com.google.android.libraries.navigation.internal.ael.bi implements com.google.android.libraries.navigation.internal.ael.cz {
    private static volatile com.google.android.libraries.navigation.internal.ael.dg N;
    public static final qj a;
    public boolean A;
    public boolean B;
    public boolean C;
    public boolean D;
    public int E;
    public boolean F;
    public boolean G;
    public boolean H;
    public boolean I;
    public boolean J;
    public boolean K;
    public float L;
    public float M;
    private int O;
    private int P;
    private int Q;
    private int R;
    private int S;
    private com.google.android.libraries.navigation.internal.ael.cs T = com.google.android.libraries.navigation.internal.ael.cs.a;
    private com.google.android.libraries.navigation.internal.ael.cs U;
    private com.google.android.libraries.navigation.internal.ael.cs V;
    public int b;
    public int c;
    public int d;
    public boolean e;
    public int f;
    public boolean g;
    public String h;
    public String i;
    public float j;
    public int k;
    public pw l;
    public boolean m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public com.google.android.libraries.navigation.internal.ael.bq f325n;
    public boolean o;
    public boolean p;
    public com.google.android.libraries.navigation.internal.ael.cs q;
    public boolean r;
    public int s;
    public qc t;
    public boolean u;
    public boolean v;
    public boolean w;
    public boolean x;
    public boolean y;
    public int z;

    static {
        qj qjVar = new qj();
        a = qjVar;
        com.google.android.libraries.navigation.internal.ael.bi.F(qj.class, qjVar);
    }

    private qj() {
        com.google.android.libraries.navigation.internal.ael.cs csVar = com.google.android.libraries.navigation.internal.ael.cs.a;
        this.q = csVar;
        this.U = csVar;
        this.V = csVar;
        this.b = DateTimeConstants.MINUTES_PER_WEEK;
        this.c = 43200;
        this.e = true;
        this.h = "https://www.google.com/maps/vt/";
        this.i = "https://www.google.com/maps/vt/";
        this.j = 15.0f;
        com.google.android.libraries.navigation.internal.ael.bj bjVar = com.google.android.libraries.navigation.internal.ael.bj.a;
        this.k = 30;
        this.f325n = com.google.android.libraries.navigation.internal.ael.bj.a;
        this.u = true;
    }

    @Override // com.google.android.libraries.navigation.internal.ael.bi
    public final Object aH(int i, Object obj) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return new com.google.android.libraries.navigation.internal.ael.dk(a, "\u0001(\u0000\u0005\u0004º(\u0004\u0000\u0000\u0004င\u0004\u0007င\b\bဇ\t\r᠌\u000e\u000fဇ\u0010\u0010ဈ\u0011\u0011ဈ\u0012\u0019ခ\u00174࠲8င,9ဉ-:ဇ.Rင\u0005ZဇJ[ဇ@\\2^2kငTrဉ\\vဇ^zဇb{ဇc}ဇe\u0085ဇj\u0092ငt\u0094ဇv\u0097ဇy\u0099ဇ{\u009aဇ|\u009cင~\u009dဇ\u007f¡ဇ\u0082¢ဇ\u0083¥ဇ\u0086§2¨ဇ\u0088°ဇ>¸ဇ\u0092¹ခ\u0093ºခ\u0094", new Object[]{"O", "P", "Q", "R", ExifInterface.LATITUDE_SOUTH, "b", "d", "e", "f", pz.a, "g", "h", ContextChain.TAG_INFRA, "j", ExifInterface.GPS_DIRECTION_TRUE, qg.a, qe.a, "k", "l", "m", "c", "r", ContextChain.TAG_PRODUCT, "q", qh.a, "U", py.a, "s", "t", "u", "v", "w", "x", "y", "z", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "B", WeatherCriteria.UNIT_CELSIUS, "D", ExifInterface.LONGITUDE_EAST, WeatherCriteria.UNIT_FARENHEIT, "G", "H", "I", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, qi.a, "J", "o", "K", "L", "M"});
        }
        if (i2 == 3) {
            return new qj();
        }
        if (i2 == 4) {
            return new px();
        }
        if (i2 == 5) {
            return a;
        }
        if (i2 != 6) {
            throw null;
        }
        com.google.android.libraries.navigation.internal.ael.dg bcVar = N;
        if (bcVar == null) {
            synchronized (qj.class) {
                bcVar = N;
                if (bcVar == null) {
                    bcVar = new com.google.android.libraries.navigation.internal.ael.bc(a);
                    N = bcVar;
                }
            }
        }
        return bcVar;
    }
}
