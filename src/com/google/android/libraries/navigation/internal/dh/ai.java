package com.google.android.libraries.navigation.internal.dh;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
@com.google.android.libraries.navigation.internal.ib.a
public final class ai extends com.google.android.libraries.navigation.internal.kp.c implements com.google.android.libraries.navigation.internal.ic.a {
    public final int a;
    public final float b;
    public final float c;
    public final boolean d;
    private final int e;

    public ai(int i, int i2, float f, float f2, boolean z) {
        this.a = i;
        this.e = i2;
        this.b = f;
        this.c = f2;
        this.d = z;
    }

    @Override // com.google.android.libraries.navigation.internal.kp.c
    public final com.google.android.libraries.navigation.internal.kp.f c() {
        return new com.google.android.libraries.navigation.internal.kp.f("satellite-status").f("numUsedInFix", this.a).f("numInView", this.e).j("topSnr", this.b).j("fifthOrWorstSnr", this.c).h("maybeDR", this.d);
    }

    public final boolean f() {
        return !Float.isNaN(this.c);
    }

    public final boolean g() {
        return !Float.isNaN(this.b);
    }

    public final String toString() {
        return com.google.android.libraries.navigation.internal.yx.al.b(this).c("numUsedInFix", this.a).c("numInView", this.e).b("topSnr", this.b).b("fifthOrWorstSnr", this.c).e("maybeDR", this.d).toString();
    }
}
