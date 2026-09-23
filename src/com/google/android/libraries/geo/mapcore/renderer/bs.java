package com.google.android.libraries.geo.mapcore.renderer;

import java.util.Arrays;
import java.util.Locale;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes2.dex */
public final class bs {
    final br a;
    public final int b;
    public final int c;
    public final int d;
    public final int e;
    public final int f;
    public final boolean g;
    public final String h;
    public final String i;
    public final String j;

    public bs(String str, String str2, String str3, int i, int i2, int i3, int i4, int i5, br brVar) {
        this.h = str;
        this.i = str2;
        this.j = str3;
        this.b = i;
        this.d = i2;
        this.e = i3;
        this.c = i4;
        this.f = i5;
        this.a = brVar;
        boolean z = false;
        if (str3 != null && str3.toLowerCase(Locale.ROOT).contains("mali")) {
            z = true;
        }
        this.g = z;
    }

    public final boolean a(boolean z) {
        br brVar = this.a;
        return z ? brVar.e : brVar.d;
    }

    public final boolean b() {
        return this.d != 0;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof bs) {
            bs bsVar = (bs) obj;
            if (com.google.android.libraries.navigation.internal.yx.am.a(this.h, bsVar.h) && com.google.android.libraries.navigation.internal.yx.am.a(this.i, bsVar.i) && com.google.android.libraries.navigation.internal.yx.am.a(this.j, bsVar.j) && this.b == bsVar.b && this.d == bsVar.d && this.e == bsVar.e && this.c == bsVar.c && this.f == bsVar.f && this.a == bsVar.a) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.h, this.i, this.j, Integer.valueOf(this.b), Integer.valueOf(this.d), Integer.valueOf(this.e), Integer.valueOf(this.c), Integer.valueOf(this.f), this.a});
    }

    public final String toString() {
        com.google.android.libraries.navigation.internal.yx.ak akVarB = com.google.android.libraries.navigation.internal.yx.al.b(this);
        akVarB.g("gpuVendor", this.h);
        akVarB.g("glVersion", this.i);
        akVarB.g("glRenderer", this.j);
        com.google.android.libraries.navigation.internal.yx.ak akVarC = akVarB.c("maxTextureSize", this.b).c("maxVertexTextureImageUnits", this.d).c("maxVertexUniformVectors", this.e).c("maxSupportedLineWidth", this.c).c("maxVertexAttribs", this.f);
        akVarC.g("nonPowerOfTwoTextureSupport", this.a);
        return akVarC.toString();
    }
}
