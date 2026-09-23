package com.google.android.libraries.navigation.internal.da;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class h extends com.google.android.libraries.navigation.internal.kp.c implements com.google.android.libraries.navigation.internal.ic.a {
    public final long a;
    public final double b;
    public final double c;
    public final float d;

    public h(long j, double d, double d2, float f) {
        this.a = j;
        this.b = d;
        this.c = d2;
        this.d = f;
    }

    @Override // com.google.android.libraries.navigation.internal.kp.c
    public final com.google.android.libraries.navigation.internal.kp.f c() {
        return new com.google.android.libraries.navigation.internal.kp.f("network_location").g("time", this.a).a("lat", this.b).a("lng", this.c).c("accuracy", this.d);
    }
}
