package com.google.android.libraries.navigation.internal.pd;

import com.google.android.libraries.navigation.internal.oe.r;
import com.google.android.libraries.navigation.internal.yx.ak;
import com.google.android.libraries.navigation.internal.yx.al;
import java.util.Arrays;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class i {
    public final g a;
    public final h b;
    private final float c;
    private final float d;
    private final float e;
    private final e f;

    public i(g gVar, float f, float f2, float f3, e eVar, h hVar) {
        this.a = gVar;
        this.c = f;
        this.d = f2;
        this.e = f3;
        this.f = eVar;
        this.b = hVar;
    }

    public final d a(r rVar, float f) {
        h hVar = this.b;
        float f2 = this.e;
        if (hVar == h.LOCATION_AND_BEARING) {
            f2 += f;
        }
        d dVar = d.a;
        a aVar = new a();
        aVar.d(rVar);
        aVar.c = this.c;
        aVar.d = this.d;
        aVar.e = f2;
        aVar.f = this.f;
        return aVar.a();
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof i)) {
            return false;
        }
        i iVar = (i) obj;
        return this.a == iVar.a && this.c == iVar.c && this.d == iVar.d && this.e == iVar.e && this.f.equals(iVar.f) && this.b == iVar.b;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.a, Float.valueOf(this.c), Float.valueOf(this.d), Float.valueOf(this.e), this.f, this.b});
    }

    public final String toString() {
        ak akVarB = al.b(this);
        akVarB.g("id", this.a);
        ak akVarB2 = akVarB.b("zoom", this.c).b("tilt", this.d).b("bearing", this.e);
        akVarB2.g("lookAhead", this.f);
        akVarB2.g("relativeTo", this.b);
        return akVarB2.toString();
    }
}
