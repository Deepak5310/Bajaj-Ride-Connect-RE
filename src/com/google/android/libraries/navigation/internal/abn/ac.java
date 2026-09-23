package com.google.android.libraries.navigation.internal.abn;

import java.util.Arrays;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class ac {
    public final double a;
    public final double b;

    static {
        new ac(0.0d, 0.0d);
    }

    public ac(double d, double d2) {
        boolean z = false;
        if (!Double.isNaN(d) && !Double.isNaN(d2)) {
            z = true;
        }
        com.google.android.libraries.navigation.internal.abf.s.b(z, "NaN is not a valid value: (%s,%s)", Double.valueOf(d), Double.valueOf(d2));
        this.a = d;
        this.b = d2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ac)) {
            return false;
        }
        ac acVar = (ac) obj;
        return this.a == acVar.a && this.b == acVar.b;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Double.valueOf(this.a), Double.valueOf(this.b)});
    }

    public final String toString() {
        return com.google.android.libraries.navigation.internal.abf.aj.f(this).a("x", this.a).a("y", this.b).toString();
    }
}
