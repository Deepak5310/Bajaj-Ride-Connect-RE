package com.google.android.libraries.navigation.internal.db;

import com.google.android.libraries.navigation.internal.agh.he;
import java.util.Comparator;
import java.util.function.Function;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class c {
    public static final /* synthetic */ int i = 0;
    public final float a;
    public final p b;
    public final float c;
    public final com.google.android.libraries.navigation.internal.agh.as d;
    public final float e;
    public final float f;
    public final boolean g;
    public final int h;

    static {
        Comparator.comparing(new Function() { // from class: com.google.android.libraries.navigation.internal.db.a
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return Float.valueOf(((c) obj).a);
            }
        }).reversed();
    }

    public c(float f, p pVar, float f2, com.google.android.libraries.navigation.internal.agh.as asVar, float f3, float f4, boolean z, int i2) {
        this.a = f;
        this.b = pVar;
        this.c = f2;
        this.d = asVar;
        this.e = f3;
        this.f = f4;
        this.g = z;
        this.h = i2;
    }

    public static double b(p pVar, double d, double d2) {
        if (d >= d2) {
            return 0.0d;
        }
        return pVar.a(d2) - pVar.a(d);
    }

    public final double a(double d) {
        return Math.min(this.f, Math.max(this.e, d));
    }

    public final he c() {
        return this.d.g();
    }

    public final String toString() {
        com.google.android.libraries.navigation.internal.yx.ak akVarB = com.google.android.libraries.navigation.internal.yx.al.b(this).b("probability", this.a);
        akVarB.g("positionDistributionAlongSegment", this.b);
        com.google.android.libraries.navigation.internal.yx.ak akVarB2 = akVarB.b("speed", this.c);
        akVarB2.g("segmentStartDistanceAlongRoute", this.d);
        return akVarB2.b("truncationLower", this.e).b("truncationUpper", this.f).e("onTunnelSegment", this.g).toString();
    }
}
