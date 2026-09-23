package com.google.android.libraries.navigation.internal.oe;

import com.facebook.react.uimanager.ViewProps;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.Arrays;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class ag implements Comparable {
    public final x a;
    public final double b;
    public final int c;
    private final double d;

    public ag(x xVar, double d, double d2, int i) {
        this.a = xVar;
        this.b = d;
        this.d = d2;
        this.c = i;
    }

    @Override // java.lang.Comparable
    public final /* bridge */ /* synthetic */ int compareTo(Object obj) {
        return Double.compare(this.d, ((ag) obj).d);
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof ag)) {
            return false;
        }
        ag agVar = (ag) obj;
        return com.google.android.libraries.navigation.internal.yx.am.a(this.a, agVar.a) && this.b == agVar.b && this.d == agVar.d && this.c == agVar.c;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.a, Double.valueOf(this.b), Double.valueOf(this.d), Integer.valueOf(this.c)});
    }

    public final String toString() {
        com.google.android.libraries.navigation.internal.yx.ak akVarB = com.google.android.libraries.navigation.internal.yx.al.b(this);
        akVarB.g(ViewProps.POSITION, this.a);
        return akVarB.a("bearing", this.b).a("distanceMeters", this.d).c(FirebaseAnalytics.Param.INDEX, this.c).c("hash", hashCode()).toString();
    }
}
