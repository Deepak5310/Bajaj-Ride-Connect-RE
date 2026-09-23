package com.google.android.libraries.navigation.internal.abu;

import com.google.android.libraries.navigation.internal.abf.aj;
import com.google.android.libraries.navigation.internal.abf.p;
import com.google.android.libraries.navigation.internal.abf.r;
import com.google.android.libraries.navigation.internal.abf.s;
import java.util.Arrays;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class c {
    private static final String f = "c";
    public final float a;
    public final float b;
    public final float c;
    public final float d;
    public final boolean e;

    public c(float f2, float f3, float f4, float f5) {
        s.i(f2, "nx cannot be NaN");
        this.a = f2;
        s.i(f3, "ny cannot be NaN");
        this.b = f3;
        s.i(f4, "nz cannot be NaN");
        this.c = f4;
        s.i(f5, "dotProduct cannot be NaN");
        this.d = f5;
        s.a((f2 == 0.0f && f3 == 0.0f && f4 == 0.0f) ? false : true, "Zero plane illegal.");
        this.e = Math.abs(f4) >= 0.9f;
    }

    public final Float a(float f2, float f3, float f4) {
        String str = f;
        p.f(str, 2);
        float f5 = this.c;
        float f6 = (f2 * this.a) + (f3 * this.b) + (f4 * f5);
        if (!Float.isNaN(f6) && f6 != 0.0f) {
            return Float.valueOf(this.d / f6);
        }
        p.f(str, 5);
        return null;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        return r.a(Float.valueOf(this.a), Float.valueOf(cVar.a)) && r.a(Float.valueOf(this.b), Float.valueOf(cVar.b)) && r.a(Float.valueOf(this.c), Float.valueOf(cVar.c)) && r.a(Float.valueOf(this.d), Float.valueOf(cVar.d));
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Float.valueOf(this.a), Float.valueOf(this.b), Float.valueOf(this.c), Float.valueOf(this.d)});
    }

    public final String toString() {
        return aj.f(this).b("nx", this.a).b("ny", this.b).b("nz", this.c).b("dotProduct", this.d).e("isGroundPlane", this.e).toString();
    }
}
