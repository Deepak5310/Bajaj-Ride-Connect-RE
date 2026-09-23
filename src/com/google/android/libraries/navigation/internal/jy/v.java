package com.google.android.libraries.navigation.internal.jy;

import com.google.android.libraries.navigation.internal.yx.ak;
import com.google.android.libraries.navigation.internal.yx.al;
import com.google.android.libraries.navigation.internal.zt.as;
import java.util.Arrays;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class v {
    public final as a;
    private final int b = 0;

    public v(as asVar) {
        this.a = asVar;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof v)) {
            return false;
        }
        v vVar = (v) obj;
        if (this.a != vVar.a) {
            return false;
        }
        int i = vVar.b;
        return true;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.a, null});
    }

    public final String toString() {
        ak akVarB = al.b(this);
        akVarB.h();
        akVarB.g("action", this.a);
        akVarB.g("cardinalDirection", null);
        return akVarB.toString();
    }
}
