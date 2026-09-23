package com.google.android.libraries.navigation.internal.abm;

import java.util.Arrays;
import java.util.List;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class e {
    public final double[] a;
    public final List b;

    public e(double[] dArr, List list) {
        this.a = dArr;
        this.b = list;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof e)) {
            return false;
        }
        e eVar = (e) obj;
        return Arrays.equals(this.a, eVar.a) && com.google.android.libraries.navigation.internal.abf.r.a(this.b, eVar.b);
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(Arrays.hashCode(this.a)), this.b});
    }

    public final String toString() {
        com.google.android.libraries.navigation.internal.abf.aj ajVarF = com.google.android.libraries.navigation.internal.abf.aj.f(this);
        ajVarF.g("coords", Arrays.toString(this.a));
        ajVarF.g("lineEndIndices", this.b);
        return ajVarF.toString();
    }
}
