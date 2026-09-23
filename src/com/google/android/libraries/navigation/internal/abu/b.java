package com.google.android.libraries.navigation.internal.abu;

import com.google.android.libraries.navigation.internal.abf.aj;
import com.google.android.libraries.navigation.internal.abf.r;
import com.google.android.libraries.navigation.internal.abf.s;
import java.util.Arrays;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public class b {
    public final String e;
    public final float f;
    public final float g;

    public b(String str, float f, float f2) {
        s.k(str, "panoId");
        this.e = str;
        s.i(f, "dXm cannot be NaN");
        this.f = f;
        s.i(f2, "dYm cannot be NaN");
        this.g = f2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        return r.a(this.e, bVar.e) && r.a(Float.valueOf(this.f), Float.valueOf(bVar.f)) && r.a(Float.valueOf(this.g), Float.valueOf(bVar.g));
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.e, Float.valueOf(this.f), Float.valueOf(this.g)});
    }

    public String toString() {
        aj ajVarF = aj.f(this);
        ajVarF.g("panoId", this.e);
        return ajVarF.b("dXm", this.f).b("dYm", this.g).toString();
    }
}
