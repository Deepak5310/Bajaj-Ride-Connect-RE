package com.google.android.libraries.navigation.internal.be;

import com.google.android.libraries.navigation.internal.oe.ad;
import com.google.android.libraries.navigation.internal.oe.x;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class e {
    private static final f c(ad adVar, int i, double d) {
        if (adVar.e() < 2 || i < 0 || i >= adVar.e()) {
            return null;
        }
        if (i == adVar.e() - 1) {
            i--;
            d += (double) adVar.c(i);
        }
        while (i > 0 && d < 0.0d) {
            i--;
            d += (double) adVar.c(i);
        }
        while (i < adVar.e() - 2 && d >= adVar.c(i)) {
            d -= (double) adVar.c(i);
            i++;
        }
        return new f(i, d, adVar);
    }

    @JvmStatic
    public final f a(ad polyline, int i, double d) {
        Intrinsics.checkNotNullParameter(polyline, "polyline");
        return c(polyline, i, 0.0d);
    }

    @JvmStatic
    public final f b(ad polyline, int i, double d) {
        Intrinsics.checkNotNullParameter(polyline, "polyline");
        if (polyline.e() >= 2 && i < polyline.e()) {
            return c(polyline, i, d * (i < polyline.e() + (-1) ? x.g((x) polyline.q().get(i), (x) polyline.q().get(i + 1)) : x.g((x) polyline.q().get(i), (x) polyline.q().get(i - 1))));
        }
        return null;
    }
}
