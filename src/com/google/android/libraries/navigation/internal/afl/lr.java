package com.google.android.libraries.navigation.internal.afl;

import androidx.exifinterface.media.ExifInterface;
import com.adobe.internal.xmp.options.PropertyOptions;
import com.facebook.common.callercontext.ContextChain;
import com.mappls.sdk.services.api.weather.WeatherCriteria;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class lr extends com.google.android.libraries.navigation.internal.ael.bi implements com.google.android.libraries.navigation.internal.ael.cz {
    public static final lr a;
    private static volatile com.google.android.libraries.navigation.internal.ael.dg x;
    private boolean A;
    private boolean B;
    private com.google.android.libraries.navigation.internal.ady.b C;
    public int b;
    public int c;
    public Object e;
    public com.google.android.libraries.navigation.internal.adr.ka f;
    public mh g;
    public com.google.android.libraries.navigation.internal.adr.by h;
    public com.google.android.libraries.navigation.internal.adr.kw i;
    public com.google.android.libraries.navigation.internal.adr.lc j;
    public int l;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f320n;
    public com.google.android.libraries.navigation.internal.ady.v o;
    public com.google.android.libraries.navigation.internal.adr.gg p;
    public com.google.android.libraries.navigation.internal.adr.gc q;
    public com.google.android.libraries.navigation.internal.adr.d r;
    public com.google.android.libraries.navigation.internal.adv.b s;
    public com.google.android.libraries.navigation.internal.ady.n t;
    public boolean u;
    public boolean v;
    public com.google.android.libraries.navigation.internal.aar.b w;
    private boolean y;
    private boolean z;
    public int d = 0;
    public int k = 3;
    public int m = 1;

    static {
        lr lrVar = new lr();
        a = lrVar;
        com.google.android.libraries.navigation.internal.ael.bi.F(lr.class, lrVar);
    }

    private lr() {
        com.google.android.libraries.navigation.internal.ael.bj bjVar = com.google.android.libraries.navigation.internal.ael.bj.a;
        this.A = true;
    }

    public static /* synthetic */ void e(lr lrVar) {
        lrVar.b |= 16777216;
        lrVar.z = true;
    }

    public static /* synthetic */ void g(lr lrVar) {
        lrVar.b |= PropertyOptions.DELETE_EXISTING;
        lrVar.B = true;
    }

    public static /* synthetic */ void h(lr lrVar) {
        lrVar.b |= 4194304;
        lrVar.y = true;
    }

    public static /* synthetic */ void i(lr lrVar) {
        lrVar.b |= 268435456;
        lrVar.A = false;
    }

    @Override // com.google.android.libraries.navigation.internal.ael.bi
    public final Object aH(int i, Object obj) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return new com.google.android.libraries.navigation.internal.ael.dk(a, "\u0001\u0018\u0001\u0002\u0001N\u0018\u0000\u0000\u0000\u0001ဉ\u0001\u0002ဉ\u0002\u0004ဇ\u0016\u0006ဉ\u0017\u0007ဇ\f\bဇ\u0018\tဉ\u0019\u0011ဉ\u0000\u0017ဉ\u001b\u0018ဉ\u0014\u0019ဇ\u001c\u001aဇ\u001d'င\b,ဉ\u00036᠌\u000b8ဉ*9ဉ+<င\n?ဉ-@<\u0000Dဉ\u0004Hဇ1Iဇ2Nဉ7", new Object[]{"e", "d", "b", "c", "g", "h", "y", ContextChain.TAG_PRODUCT, "n", "z", "q", "f", "r", "o", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "B", "k", ContextChain.TAG_INFRA, "m", lp.a, "s", "t", "l", WeatherCriteria.UNIT_CELSIUS, com.google.android.libraries.navigation.internal.adr.ga.class, "j", "u", "v", "w"});
        }
        if (i2 == 3) {
            return new lr();
        }
        if (i2 == 4) {
            return new lo();
        }
        if (i2 == 5) {
            return a;
        }
        if (i2 != 6) {
            throw null;
        }
        com.google.android.libraries.navigation.internal.ael.dg bcVar = x;
        if (bcVar == null) {
            synchronized (lr.class) {
                bcVar = x;
                if (bcVar == null) {
                    bcVar = new com.google.android.libraries.navigation.internal.ael.bc(a);
                    x = bcVar;
                }
            }
        }
        return bcVar;
    }
}
