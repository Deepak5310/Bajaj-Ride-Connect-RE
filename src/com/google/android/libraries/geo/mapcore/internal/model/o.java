package com.google.android.libraries.geo.mapcore.internal.model;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes2.dex */
public final class o extends cb {
    public final int a;
    public final int b;
    public final int c;
    public final float d;
    public final float e;
    public final float f;
    public final int g;
    public final boolean h;

    public o(int i, int i2, int i3, float f, float f2, float f3, int i4, boolean z) {
        this.a = i;
        this.b = i2;
        this.c = i3;
        this.d = f;
        this.e = f2;
        this.f = f3;
        this.g = i4;
        this.h = z;
    }

    @Override // com.google.android.libraries.geo.mapcore.internal.model.cb
    public final float a() {
        return this.e;
    }

    @Override // com.google.android.libraries.geo.mapcore.internal.model.cb
    public final float b() {
        return this.d;
    }

    @Override // com.google.android.libraries.geo.mapcore.internal.model.cb
    public final float c() {
        return this.f;
    }

    @Override // com.google.android.libraries.geo.mapcore.internal.model.cb
    public final int d() {
        return this.g;
    }

    @Override // com.google.android.libraries.geo.mapcore.internal.model.cb
    public final int e() {
        return this.a;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof cb) {
            cb cbVar = (cb) obj;
            if (this.a == cbVar.e() && this.b == cbVar.f() && this.c == cbVar.g() && Float.floatToIntBits(this.d) == Float.floatToIntBits(cbVar.b()) && Float.floatToIntBits(this.e) == Float.floatToIntBits(cbVar.a()) && Float.floatToIntBits(this.f) == Float.floatToIntBits(cbVar.c()) && this.g == cbVar.d() && this.h == cbVar.h()) {
                return true;
            }
        }
        return false;
    }

    @Override // com.google.android.libraries.geo.mapcore.internal.model.cb
    public final int f() {
        return this.b;
    }

    @Override // com.google.android.libraries.geo.mapcore.internal.model.cb
    public final int g() {
        return this.c;
    }

    @Override // com.google.android.libraries.geo.mapcore.internal.model.cb
    public final boolean h() {
        return this.h;
    }

    public final int hashCode() {
        return ((((((((((((((this.a ^ 1000003) * 1000003) ^ this.b) * 1000003) ^ this.c) * 1000003) ^ Float.floatToIntBits(this.d)) * 1000003) ^ Float.floatToIntBits(this.e)) * 1000003) ^ Float.floatToIntBits(this.f)) * 1000003) ^ this.g) * 1000003) ^ (true != this.h ? 1237 : 1231);
    }
}
