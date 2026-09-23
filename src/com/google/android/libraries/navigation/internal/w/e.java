package com.google.android.libraries.navigation.internal.w;

import android.graphics.Typeface;
import android.text.TextUtils;
import android.util.LruCache;
import com.bajajconnect.rideapp.R;
import com.google.android.libraries.navigation.internal.ms.ad;
import com.google.android.libraries.navigation.internal.ms.ah;
import com.google.android.libraries.navigation.internal.mx.k;
import com.google.android.libraries.navigation.internal.mx.m;
import com.google.android.libraries.navigation.internal.mx.w;
import com.google.android.libraries.navigation.internal.nc.bf;
import com.google.android.libraries.navigation.internal.nc.bh;
import com.google.android.libraries.navigation.internal.nc.j;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
@Deprecated
public final class e {
    public static final bh a;
    public static final bh b;

    static {
        Typeface typeface = ad.e;
        LruCache lruCache = j.a;
        new bf(R.font.mappls_category_montserrat_semi_bold, typeface);
        a = new bf(2131296266, ad.d);
        b = new bf(2131296268, ad.e);
        new bf(2131296269, ad.d);
    }

    public static k a() {
        return new k(new m[]{ah.aj(1), ah.aH(true), ah.C(TextUtils.TruncateAt.END)});
    }

    public static w b() {
        return ah.aP(2131821123);
    }

    public static w c() {
        return ah.aP(2131821124);
    }

    public static w d() {
        return ah.aP(2131821125);
    }

    public static w e() {
        return ah.aP(2131821126);
    }

    public static w f() {
        return ah.aR(b.g());
    }

    public static w g() {
        return ah.aP(2131821138);
    }

    public static w h() {
        return ah.aP(2131821140);
    }

    public static w i() {
        return ah.aR(com.google.android.libraries.navigation.internal.af.e.b(a.j(), a.i()));
    }

    public static w j() {
        return ah.aR(com.google.android.libraries.navigation.internal.af.e.b(a.n(), a.r()));
    }

    public static w k() {
        return ah.aP(2131821149);
    }

    public static w l() {
        return ah.aP(2131821150);
    }
}
