package com.google.android.libraries.navigation.internal.pd;

import com.google.android.libraries.navigation.internal.oe.q;
import com.google.android.libraries.navigation.internal.oe.r;
import com.google.android.libraries.navigation.internal.oe.x;
import com.google.android.libraries.navigation.internal.yx.ak;
import com.google.android.libraries.navigation.internal.yx.al;
import com.google.android.libraries.navigation.internal.yx.ar;
import java.io.Serializable;
import java.util.Arrays;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class d implements Serializable {
    public static final d a;
    public static final int b;
    public static final int c;
    public static final int d;
    public static final int e;
    public static final int f;
    public static final int g;
    public static final int h;
    public final r i;
    public final x j;
    public final float k;
    public final float l;
    public final float m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final e f515n;
    public q o;
    private q p;

    static {
        a aVar = new a();
        aVar.e(new x(0, 0));
        aVar.c = 20.0f;
        aVar.d = 0.0f;
        aVar.e = 0.0f;
        aVar.f = e.a;
        a = aVar.a();
        b.b();
        b = 5;
        c = 1;
        d = 2;
        e = 4;
        f = 8;
        g = 16;
        h = 31;
    }

    public d(r rVar, float f2, float f3, float f4, e eVar) {
        ar.r(rVar, "Null camera target");
        ar.r(eVar, "Null camera lookAhead");
        if (f3 <= 0.0f) {
            f3 = 0.0f;
        } else if (f3 > 90.0f) {
            f3 = 90.0f;
        }
        this.i = rVar;
        this.j = com.google.android.libraries.navigation.internal.oe.h.c(rVar);
        this.k = Math.max(2.0f, Math.min(f2, 21.0f));
        this.l = f3 + 0.0f;
        this.m = (((double) f4) <= 0.0d ? (f4 % 360.0f) + 360.0f : f4) % 360.0f;
        this.f515n = e.e(eVar);
    }

    public static final com.google.android.libraries.navigation.internal.oq.f b(d dVar) {
        com.google.android.libraries.navigation.internal.oq.e eVarG = com.google.android.libraries.navigation.internal.oq.f.g();
        eVarG.e(dVar.i);
        eVarG.k(dVar.k);
        eVarG.j(dVar.l);
        eVarG.h(dVar.m);
        e eVar = dVar.f515n;
        eVarG.i(com.google.android.libraries.navigation.internal.oq.j.c(eVar.b, eVar.c));
        return eVarG.l();
    }

    public static final d c(com.google.android.libraries.navigation.internal.oq.f fVar) {
        a aVar = new a();
        aVar.d(fVar.d());
        aVar.c = fVar.c();
        aVar.d = fVar.b();
        aVar.e = fVar.a();
        aVar.f = new e(((com.google.android.libraries.navigation.internal.oq.c) fVar.f()).a, ((com.google.android.libraries.navigation.internal.oq.c) fVar.f()).b);
        return aVar.a();
    }

    public final q a() {
        q qVar;
        if (this.p == null) {
            double d2 = (90.0d - ((double) this.m)) * 0.017453292519943295d;
            float fCos = (float) Math.cos(d2);
            float fSin = (float) Math.sin(d2);
            float f2 = this.l;
            if (f2 == 0.0f) {
                qVar = new q(Math.round(fCos * 65536.0f), Math.round(fSin * 65536.0f));
            } else {
                double d3 = ((double) f2) * 0.017453292519943295d;
                float fCos2 = (float) Math.cos(d3);
                qVar = new q(Math.round(fCos * fCos2 * 65536.0f), Math.round(fSin * fCos2 * 65536.0f), Math.round(((float) Math.sin(d3)) * 65536.0f));
            }
            this.p = qVar;
        }
        return this.p;
    }

    public final Object d(int i) {
        float f2;
        if (i == 0) {
            throw null;
        }
        int i2 = i - 1;
        if (i2 == 0) {
            return this.j;
        }
        if (i2 == 1) {
            f2 = this.k;
        } else if (i2 == 2) {
            f2 = this.l;
        } else {
            if (i2 != 3) {
                return this.f515n;
            }
            f2 = this.m;
        }
        return Float.valueOf(f2);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof d)) {
            return false;
        }
        d dVar = (d) obj;
        return this.i.equals(dVar.i) && Float.floatToIntBits(this.k) == Float.floatToIntBits(dVar.k) && Float.floatToIntBits(this.l) == Float.floatToIntBits(dVar.l) && Float.floatToIntBits(this.m) == Float.floatToIntBits(dVar.m) && this.f515n.equals(dVar.f515n);
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.i, Float.valueOf(this.k), Float.valueOf(this.l), Float.valueOf(this.m), this.f515n});
    }

    public final String toString() {
        ak akVarB = al.b(this);
        akVarB.g("target", this.i);
        ak akVarB2 = akVarB.b("zoom", this.k).b("tilt", this.l).b("bearing", this.m);
        akVarB2.g("lookAhead", this.f515n);
        return akVarB2.toString();
    }
}
