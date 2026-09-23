package com.google.android.libraries.navigation.internal.om;

import com.google.android.libraries.navigation.internal.afl.no;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class h extends x {
    public final boolean a;
    public final boolean b;
    public final no c;
    public final int d;
    public final boolean e;
    public final boolean f;
    private final float g;
    private final float h;
    private final int i;
    private final int j;
    private final boolean k;
    private final boolean l;
    private final boolean m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final boolean f503n;
    private final boolean o;

    public h(float f, float f2, int i, boolean z, boolean z2, no noVar, int i2, int i3, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, boolean z8, boolean z9) {
        this.g = f;
        this.h = f2;
        this.i = i;
        this.a = z;
        this.b = z2;
        this.c = noVar;
        this.d = i2;
        this.j = i3;
        this.k = z3;
        this.l = z4;
        this.m = z5;
        this.e = z6;
        this.f = z7;
        this.f503n = z8;
        this.o = z9;
    }

    @Override // com.google.android.libraries.navigation.internal.om.x
    public final float a() {
        return this.g;
    }

    @Override // com.google.android.libraries.navigation.internal.om.x
    public final float b() {
        return this.h;
    }

    @Override // com.google.android.libraries.navigation.internal.om.x
    public final int c() {
        return this.d;
    }

    @Override // com.google.android.libraries.navigation.internal.om.x
    public final int d() {
        return this.j;
    }

    @Override // com.google.android.libraries.navigation.internal.om.x
    public final int e() {
        return this.i;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof x) {
            x xVar = (x) obj;
            if (Float.floatToIntBits(this.g) == Float.floatToIntBits(xVar.a()) && Float.floatToIntBits(this.h) == Float.floatToIntBits(xVar.b()) && this.i == xVar.e() && this.a == xVar.m() && this.b == xVar.h() && this.c.equals(xVar.f()) && this.d == xVar.c() && this.j == xVar.d() && this.k == xVar.o() && this.l == xVar.i() && this.m == xVar.g() && this.e == xVar.j() && this.f == xVar.k() && this.f503n == xVar.l() && this.o == xVar.n()) {
                return true;
            }
        }
        return false;
    }

    @Override // com.google.android.libraries.navigation.internal.om.x
    public final no f() {
        return this.c;
    }

    @Override // com.google.android.libraries.navigation.internal.om.x
    public final boolean g() {
        return this.m;
    }

    @Override // com.google.android.libraries.navigation.internal.om.x
    public final boolean h() {
        return this.b;
    }

    @Override // com.google.android.libraries.navigation.internal.om.x
    public final boolean i() {
        return this.l;
    }

    @Override // com.google.android.libraries.navigation.internal.om.x
    public final boolean j() {
        return this.e;
    }

    @Override // com.google.android.libraries.navigation.internal.om.x
    public final boolean k() {
        return this.f;
    }

    @Override // com.google.android.libraries.navigation.internal.om.x
    public final boolean l() {
        return this.f503n;
    }

    @Override // com.google.android.libraries.navigation.internal.om.x
    public final boolean m() {
        return this.a;
    }

    @Override // com.google.android.libraries.navigation.internal.om.x
    public final boolean n() {
        return this.o;
    }

    @Override // com.google.android.libraries.navigation.internal.om.x
    public final boolean o() {
        return this.k;
    }

    public final String toString() {
        return "{" + this.g + ", " + this.h + ", " + this.i + ", " + this.a + ", " + this.b + ", " + String.valueOf(this.c) + ", " + this.d + ", " + this.j + ", " + this.k + ", " + this.l + ", " + this.m + ", " + this.e + ", " + this.f + ", " + this.f503n + ", " + this.o + "}";
    }

    public final int hashCode() {
        int iN;
        int iFloatToIntBits = ((Float.floatToIntBits(this.g) ^ 1000003) * 1000003) ^ Float.floatToIntBits(this.h);
        no noVar = this.c;
        if (noVar.H()) {
            iN = noVar.n();
        } else {
            int iN2 = noVar.ak;
            if (iN2 == 0) {
                iN2 = noVar.n();
                noVar.ak = iN2;
            }
            iN = iN2;
        }
        boolean z = this.b;
        boolean z2 = this.a;
        return (((((((((((((((((((((((((iFloatToIntBits * 1000003) ^ this.i) * 1000003) ^ (true != z2 ? 1237 : 1231)) * 1000003) ^ (true != z ? 1237 : 1231)) * 1000003) ^ iN) * 1000003) ^ this.d) * 1000003) ^ this.j) * 1000003) ^ (true != this.k ? 1237 : 1231)) * 1000003) ^ (true != this.l ? 1237 : 1231)) * 1000003) ^ (true != this.m ? 1237 : 1231)) * 1000003) ^ (true != this.e ? 1237 : 1231)) * 1000003) ^ (true != this.f ? 1237 : 1231)) * 1000003) ^ (true != this.f503n ? 1237 : 1231)) * 1000003) ^ (true == this.o ? 1231 : 1237);
    }
}
