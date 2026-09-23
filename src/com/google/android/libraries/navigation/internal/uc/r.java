package com.google.android.libraries.navigation.internal.uc;

import com.BV.LinearGradient.LinearGradientManager;
import com.google.android.libraries.navigation.internal.bp.bg;
import com.google.android.libraries.navigation.internal.yx.ak;
import com.google.android.libraries.navigation.internal.yx.al;
import java.util.Arrays;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class r {
    public final bg a;
    public final int b;
    public final int c;

    public r(bg bgVar, int i, int i2) {
        this.a = bgVar;
        this.b = i;
        this.c = i2;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof r)) {
            return false;
        }
        r rVar = (r) obj;
        return this.a == rVar.a && this.b == rVar.b && this.c == rVar.c;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.a, Integer.valueOf(this.b), Integer.valueOf(this.c)});
    }

    public final String toString() {
        ak akVarB = al.b(this);
        akVarB.g("routeDescription", this.a);
        return akVarB.c(LinearGradientManager.PROP_START_POINT, this.b).c(LinearGradientManager.PROP_END_POINT, this.c).toString();
    }
}
