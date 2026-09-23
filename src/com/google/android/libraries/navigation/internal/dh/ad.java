package com.google.android.libraries.navigation.internal.dh;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class ad extends com.google.android.libraries.navigation.internal.kp.c implements com.google.android.libraries.navigation.internal.ic.a {
    public final long a;
    public final long b;
    public final float c;
    public final float d;
    public final float e;
    public final float f;
    public final boolean g;
    public final float h;
    public final float i;
    public final float j;
    public final float k;
    public final float l;
    public final float m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final float f394n;
    public final float o;
    public final float p;

    public ad(long j, long j2, com.google.android.libraries.navigation.internal.de.x xVar, boolean z, float[] fArr, float[] fArr2, float f, float f2, float[] fArr3) {
        this.a = j;
        this.b = j2;
        this.c = xVar.a;
        this.d = xVar.b;
        this.e = xVar.c;
        this.f = xVar.d;
        this.g = z;
        if (fArr != null) {
            this.h = fArr[0];
            this.i = fArr[1];
            this.j = fArr[2];
        } else {
            this.h = Float.NaN;
            this.i = Float.NaN;
            this.j = Float.NaN;
        }
        if (fArr2 != null) {
            this.k = fArr2[0];
            this.l = fArr2[1];
            this.m = fArr2[2];
        } else {
            this.k = Float.NaN;
            this.l = Float.NaN;
            this.m = Float.NaN;
        }
        this.f394n = f;
        this.o = f2;
        this.p = fArr3 != null ? fArr3[1] : Float.NaN;
    }

    @Override // com.google.android.libraries.navigation.internal.kp.c
    public final com.google.android.libraries.navigation.internal.kp.f c() {
        return new com.google.android.libraries.navigation.internal.kp.f("rotation-vector").g("timeMs", this.a).g("timeNs", this.b).l("gyroZOnly", this.g).c("w", this.f).c("x", this.c).c("y", this.d).c("z", this.e).j("gx", this.h).j("gy", this.i).j("gz", this.j).j("ay", this.p).j("mx", this.k).j("my", this.l).j("mz", this.m).j("maxRot", this.f394n).j("maxAcc", this.o);
    }

    public final String toString() {
        return com.google.android.libraries.navigation.internal.yx.al.b(this).d("timestampMs", this.a).d("deltaTNs", this.b).e("gyroZOnly", this.g).b("x", this.c).b("y", this.d).b("z", this.e).b("w", this.f).b("gx", this.h).b("gy", this.i).b("gz", this.j).b("ay", this.p).b("mx", this.k).b("my", this.l).b("mz", this.m).b("maxRateOfTurn", this.f394n).b("maxAcceleration", this.o).toString();
    }
}
