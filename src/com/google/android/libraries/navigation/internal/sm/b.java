package com.google.android.libraries.navigation.internal.sm;

import com.google.android.libraries.navigation.internal.yx.ak;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class b extends com.google.android.libraries.navigation.internal.kp.c implements com.google.android.libraries.navigation.internal.ic.a {
    private final String a;
    private final int b;
    private final int c;
    private final int d;
    private final double e;
    private final boolean f;

    public b(String str, int i, int i2, int i3, double d, boolean z) {
        this.a = str;
        this.b = i;
        this.c = i2;
        this.d = i3;
        this.e = d;
        this.f = z;
    }

    @Override // com.google.android.libraries.navigation.internal.kp.e, com.google.android.libraries.navigation.internal.ic.a
    public final boolean a() {
        return true;
    }

    @Override // com.google.android.libraries.navigation.internal.kp.c
    public final com.google.android.libraries.navigation.internal.kp.f c() {
        com.google.android.libraries.navigation.internal.kp.f fVar = new com.google.android.libraries.navigation.internal.kp.f("gwd");
        fVar.m("text", this.a);
        return fVar.f("gwdMinDist", this.b).f("gwdMaxDist", this.c).f("stepDistanceFromStartM", this.d).a("confidence", this.e).h("isStrict", this.f);
    }

    public final String toString() {
        ak akVar = new ak("GuidanceAlertDataEvent");
        akVar.g("text", this.a);
        return akVar.c("gwdMinDist", this.b).c("gwdMaxDist", this.c).c("stepDistanceFromStartM", this.d).a("confidence", this.e).e("isStrict", this.f).toString();
    }
}
