package com.google.android.libraries.navigation.internal.ol;

import com.facebook.react.uimanager.ViewProps;
import java.util.Arrays;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class i {
    private static final h f = h.WORLD;
    public final com.google.android.libraries.navigation.internal.oe.x a;
    public final com.google.android.libraries.navigation.internal.oe.ay b;
    public h c;
    public float d;
    public final com.google.android.libraries.navigation.internal.oe.x e;

    public i() {
        com.google.android.libraries.navigation.internal.oe.x xVar = new com.google.android.libraries.navigation.internal.oe.x();
        h hVar = f;
        com.google.android.libraries.navigation.internal.oe.x xVar2 = new com.google.android.libraries.navigation.internal.oe.x();
        com.google.android.libraries.navigation.internal.oe.ay ayVar = new com.google.android.libraries.navigation.internal.oe.ay(1.0f, 1.0f);
        this.b = ayVar;
        this.a = new com.google.android.libraries.navigation.internal.oe.x(xVar);
        ayVar.q(1.0f, 1.0f);
        this.c = hVar;
        this.d = 0.0f;
        this.e = new com.google.android.libraries.navigation.internal.oe.x(xVar2);
    }

    public final void a(i iVar) {
        this.a.W(iVar.a);
        this.b.r(iVar.b);
        this.c = iVar.c;
        this.d = iVar.d;
        this.e.W(iVar.e);
    }

    public final void b(com.google.android.libraries.navigation.internal.oe.x xVar) {
        this.a.W(xVar);
    }

    public final void c(float f2, com.google.android.libraries.navigation.internal.oe.x xVar) {
        this.d = f2;
        this.e.W(xVar);
    }

    public final void d(float f2, h hVar) {
        this.b.q(f2, f2);
        this.c = hVar;
    }

    public final void e(double d, double d2) {
        float f2 = (float) (d * com.google.android.libraries.navigation.internal.oe.x.f(d2));
        this.b.q(f2, f2);
        this.c = h.WORLD;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof i) {
            i iVar = (i) obj;
            if (this.a.equals(iVar.a) && this.b.equals(iVar.b) && this.c.equals(iVar.c) && Float.compare(this.d, iVar.d) == 0 && this.e.equals(iVar.e)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.a, this.b, this.c, Float.valueOf(this.d), this.e});
    }

    public final String toString() {
        com.google.android.libraries.navigation.internal.yx.ak akVarB = com.google.android.libraries.navigation.internal.yx.al.b(this);
        akVarB.g(ViewProps.POSITION, this.a);
        akVarB.g("scale", this.b);
        akVarB.g("scaleType", this.c);
        com.google.android.libraries.navigation.internal.yx.ak akVarB2 = akVarB.b("rotationDegrees", this.d);
        akVarB2.g("rotationOrigin", this.e);
        return akVarB2.toString();
    }
}
