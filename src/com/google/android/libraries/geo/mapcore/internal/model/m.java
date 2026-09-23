package com.google.android.libraries.geo.mapcore.internal.model;

import com.google.android.libraries.navigation.internal.adg.io;
import com.google.android.libraries.navigation.internal.yz.ev;
import com.google.android.libraries.navigation.internal.yz.hx;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes2.dex */
public final class m extends bz {
    public final int a;
    public final bs b;
    public final int c;
    public final int d;
    public final int e;
    public final float f;
    public final float g;
    public final float h;
    public final int i;
    public final int j;
    public final int k;
    public final float l;
    public final ev m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final io f68n;
    public final boolean o;
    private final boolean q;

    public m(int i, bs bsVar, int i2, int i3, int i4, float f, float f2, float f3, int i5, int i6, int i7, float f4, ev evVar, io ioVar, boolean z, boolean z2) {
        this.a = i;
        this.b = bsVar;
        this.c = i2;
        this.d = i3;
        this.e = i4;
        this.f = f;
        this.g = f2;
        this.h = f3;
        this.i = i5;
        this.j = i6;
        this.k = i7;
        this.l = f4;
        this.m = evVar;
        this.f68n = ioVar;
        this.o = z;
        this.q = z2;
    }

    @Override // com.google.android.libraries.geo.mapcore.internal.model.bz
    public final float a() {
        return this.l;
    }

    @Override // com.google.android.libraries.geo.mapcore.internal.model.bz
    public final float b() {
        return this.f;
    }

    @Override // com.google.android.libraries.geo.mapcore.internal.model.bz
    public final float c() {
        return this.g;
    }

    @Override // com.google.android.libraries.geo.mapcore.internal.model.bz
    public final float d() {
        return this.h;
    }

    @Override // com.google.android.libraries.geo.mapcore.internal.model.bz
    public final int e() {
        return this.k;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof bz) {
            bz bzVar = (bz) obj;
            if (this.a == bzVar.k() && this.b.equals(bzVar.l()) && this.c == bzVar.i() && this.d == bzVar.j() && this.e == bzVar.h() && Float.floatToIntBits(this.f) == Float.floatToIntBits(bzVar.b()) && Float.floatToIntBits(this.g) == Float.floatToIntBits(bzVar.c()) && Float.floatToIntBits(this.h) == Float.floatToIntBits(bzVar.d()) && this.i == bzVar.f() && this.j == bzVar.g() && this.k == bzVar.e() && Float.floatToIntBits(this.l) == Float.floatToIntBits(bzVar.a()) && hx.i(this.m, bzVar.m()) && this.f68n.equals(bzVar.n()) && this.o == bzVar.o() && this.q == bzVar.p()) {
                return true;
            }
        }
        return false;
    }

    @Override // com.google.android.libraries.geo.mapcore.internal.model.bz
    public final int f() {
        return this.i;
    }

    @Override // com.google.android.libraries.geo.mapcore.internal.model.bz
    public final int g() {
        return this.j;
    }

    @Override // com.google.android.libraries.geo.mapcore.internal.model.bz
    public final int h() {
        return this.e;
    }

    public final int hashCode() {
        return ((((((((((((((((((((((((((((((this.a ^ 1000003) * 1000003) ^ this.b.hashCode()) * 1000003) ^ this.c) * 1000003) ^ this.d) * 1000003) ^ this.e) * 1000003) ^ Float.floatToIntBits(this.f)) * 1000003) ^ Float.floatToIntBits(this.g)) * 1000003) ^ Float.floatToIntBits(this.h)) * 1000003) ^ this.i) * 1000003) ^ this.j) * 1000003) ^ this.k) * 1000003) ^ Float.floatToIntBits(this.l)) * 1000003) ^ this.m.hashCode()) * 1000003) ^ this.f68n.hashCode()) * 1000003) ^ (true != this.o ? 1237 : 1231)) * 1000003) ^ (true == this.q ? 1231 : 1237);
    }

    @Override // com.google.android.libraries.geo.mapcore.internal.model.bz
    public final int i() {
        return this.c;
    }

    @Override // com.google.android.libraries.geo.mapcore.internal.model.bz
    public final int j() {
        return this.d;
    }

    @Override // com.google.android.libraries.geo.mapcore.internal.model.bz
    public final int k() {
        return this.a;
    }

    @Override // com.google.android.libraries.geo.mapcore.internal.model.bz
    public final bs l() {
        return this.b;
    }

    @Override // com.google.android.libraries.geo.mapcore.internal.model.bz
    public final ev m() {
        return this.m;
    }

    @Override // com.google.android.libraries.geo.mapcore.internal.model.bz
    public final io n() {
        return this.f68n;
    }

    @Override // com.google.android.libraries.geo.mapcore.internal.model.bz
    public final boolean o() {
        return this.o;
    }

    @Override // com.google.android.libraries.geo.mapcore.internal.model.bz
    public final boolean p() {
        return this.q;
    }

    public final String toString() {
        io ioVar = this.f68n;
        ev evVar = this.m;
        return "{" + this.a + ", " + String.valueOf(this.b) + ", " + this.c + ", " + this.d + ", " + this.e + ", " + this.f + ", " + this.g + ", " + this.h + ", " + this.i + ", " + this.j + ", " + this.k + ", " + this.l + ", " + String.valueOf(evVar) + ", " + String.valueOf(ioVar) + ", " + this.o + ", " + this.q + "}";
    }
}
