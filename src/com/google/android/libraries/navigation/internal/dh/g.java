package com.google.android.libraries.navigation.internal.dh;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class g extends com.google.android.libraries.navigation.internal.kp.c implements com.google.android.libraries.navigation.internal.ic.a {
    public final long a;
    public final float b;

    public g(long j, float f) {
        this.a = j;
        this.b = f;
    }

    public static double f(float f) {
        return 44331.5d - (Math.pow(f, 0.190263d) * 4946.62d);
    }

    @Override // com.google.android.libraries.navigation.internal.kp.c
    public final com.google.android.libraries.navigation.internal.kp.f c() {
        return new com.google.android.libraries.navigation.internal.kp.f("pressure").g("timeMs", this.a).c("pascals", this.b);
    }

    public final String toString() {
        return com.google.android.libraries.navigation.internal.yx.al.b(this).d("timeMs", this.a).b("pascals", this.b).a("relative meters", f(this.b)).toString();
    }
}
