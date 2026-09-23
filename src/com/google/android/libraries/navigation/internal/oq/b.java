package com.google.android.libraries.navigation.internal.oq;

import com.google.android.libraries.navigation.internal.oe.r;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class b extends f {
    public final r a;
    public final float b;
    public final float c;
    public final j d;
    public final float e;

    public b(r rVar, float f, float f2, j jVar, float f3) {
        this.a = rVar;
        this.b = f;
        this.c = f2;
        this.d = jVar;
        this.e = f3;
    }

    @Override // com.google.android.libraries.navigation.internal.oq.f
    public final float a() {
        return this.b;
    }

    @Override // com.google.android.libraries.navigation.internal.oq.f
    public final float b() {
        return this.c;
    }

    @Override // com.google.android.libraries.navigation.internal.oq.f
    public final float c() {
        return this.e;
    }

    @Override // com.google.android.libraries.navigation.internal.oq.f
    public final r d() {
        return this.a;
    }

    @Override // com.google.android.libraries.navigation.internal.oq.f
    public final e e() {
        return new a(this);
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof f) {
            f fVar = (f) obj;
            if (this.a.equals(fVar.d()) && Float.floatToIntBits(this.b) == Float.floatToIntBits(fVar.a()) && Float.floatToIntBits(this.c) == Float.floatToIntBits(fVar.b()) && this.d.equals(fVar.f()) && Float.floatToIntBits(this.e) == Float.floatToIntBits(fVar.c())) {
                return true;
            }
        }
        return false;
    }

    @Override // com.google.android.libraries.navigation.internal.oq.f
    public final j f() {
        return this.d;
    }

    public final int hashCode() {
        return ((((((((this.a.hashCode() ^ 1000003) * 1000003) ^ Float.floatToIntBits(this.b)) * 1000003) ^ Float.floatToIntBits(this.c)) * 1000003) ^ this.d.hashCode()) * 1000003) ^ Float.floatToIntBits(this.e);
    }

    public final String toString() {
        j jVar = this.d;
        return "{" + String.valueOf(this.a) + ", " + this.b + ", " + this.c + ", " + String.valueOf(jVar) + ", " + this.e + "}";
    }
}
