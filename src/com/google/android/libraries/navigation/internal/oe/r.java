package com.google.android.libraries.navigation.internal.oe;

import java.io.Serializable;
import java.util.Arrays;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class r implements Serializable {
    static final long serialVersionUID = 2026947877447454771L;
    public final double a;
    public final double b;

    public r() {
        this(0.0d, 0.0d);
    }

    public r(double d, double d2) {
        this.b = (d2 < -180.0d || d2 >= 180.0d) ? ((((d2 - 180.0d) % 360.0d) + 360.0d) % 360.0d) - 180.0d : d2;
        this.a = Math.max(-90.0d, Math.min(90.0d, d));
    }

    public static r a(com.google.android.libraries.navigation.internal.adq.z zVar) {
        return new r(zVar.c, zVar.d);
    }

    public static boolean e(r rVar, r rVar2) {
        return (rVar == null || rVar2 == null || p.b(rVar, rVar2) >= 1.0d) ? false : true;
    }

    private static boolean f(double d, double d2) {
        return (Double.doubleToLongBits(d) & (-2)) == (Double.doubleToLongBits(d2) & (-2));
    }

    public final com.google.android.libraries.navigation.internal.adq.z b() {
        com.google.android.libraries.navigation.internal.adq.y yVar = (com.google.android.libraries.navigation.internal.adq.y) com.google.android.libraries.navigation.internal.adq.z.a.q();
        if (!yVar.b.H()) {
            yVar.v();
        }
        double d = this.a;
        com.google.android.libraries.navigation.internal.adq.z zVar = (com.google.android.libraries.navigation.internal.adq.z) yVar.b;
        zVar.b |= 1;
        zVar.c = d;
        double d2 = this.b;
        if (!yVar.b.H()) {
            yVar.v();
        }
        com.google.android.libraries.navigation.internal.adq.z zVar2 = (com.google.android.libraries.navigation.internal.adq.z) yVar.b;
        zVar2.b |= 2;
        zVar2.d = d2;
        return (com.google.android.libraries.navigation.internal.adq.z) yVar.t();
    }

    public final com.google.android.libraries.navigation.internal.afj.b c() {
        com.google.android.libraries.navigation.internal.afj.a aVar = (com.google.android.libraries.navigation.internal.afj.a) com.google.android.libraries.navigation.internal.afj.b.a.q();
        if (!aVar.b.H()) {
            aVar.v();
        }
        ((com.google.android.libraries.navigation.internal.afj.b) aVar.b).b = this.a;
        double d = this.b;
        if (!aVar.b.H()) {
            aVar.v();
        }
        ((com.google.android.libraries.navigation.internal.afj.b) aVar.b).c = d;
        return (com.google.android.libraries.navigation.internal.afj.b) aVar.t();
    }

    public final com.google.android.libraries.navigation.internal.afm.z d() {
        com.google.android.libraries.navigation.internal.afm.y yVar = (com.google.android.libraries.navigation.internal.afm.y) com.google.android.libraries.navigation.internal.afm.z.a.q();
        if (!yVar.b.H()) {
            yVar.v();
        }
        double d = this.a;
        com.google.android.libraries.navigation.internal.afm.z zVar = (com.google.android.libraries.navigation.internal.afm.z) yVar.b;
        zVar.b |= 1;
        zVar.c = (int) (d * 1000000.0d);
        double d2 = this.b;
        if (!yVar.b.H()) {
            yVar.v();
        }
        com.google.android.libraries.navigation.internal.afm.z zVar2 = (com.google.android.libraries.navigation.internal.afm.z) yVar.b;
        zVar2.b |= 2;
        zVar2.d = (int) (d2 * 1000000.0d);
        return (com.google.android.libraries.navigation.internal.afm.z) yVar.t();
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof r)) {
            return false;
        }
        r rVar = (r) obj;
        return f(this.a, rVar.a) && f(this.b, rVar.b);
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Long.valueOf(Double.doubleToLongBits(this.a)), Long.valueOf(Double.doubleToLongBits(this.b))});
    }

    public final String toString() {
        return "lat/lng: (" + this.a + "," + this.b + ")";
    }
}
