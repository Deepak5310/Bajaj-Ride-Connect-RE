package com.google.android.libraries.navigation.internal.abt;

import com.google.android.libraries.navigation.internal.abf.aj;
import com.google.android.libraries.navigation.internal.abf.r;
import com.google.android.libraries.navigation.internal.abf.s;
import java.util.Arrays;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class j {
    public final String a;
    public final float b;

    public j(String str, float f) {
        s.k(str, "text");
        this.a = str;
        this.b = f;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof j)) {
            return false;
        }
        j jVar = (j) obj;
        return r.a(this.a, jVar.a) && r.a(Float.valueOf(this.b), Float.valueOf(jVar.b));
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.a, Float.valueOf(this.b)});
    }

    public final String toString() {
        aj ajVarF = aj.f(this);
        ajVarF.g("text", this.a);
        return ajVarF.b("bearingDeg", this.b).toString();
    }
}
