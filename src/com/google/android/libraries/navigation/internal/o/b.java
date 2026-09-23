package com.google.android.libraries.navigation.internal.o;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class b extends d {
    public final float a;
    public final float b;
    public final float c;
    public final float d;

    public b(float f, float f2, float f3, float f4) {
        this.a = f;
        this.b = f2;
        this.c = f3;
        this.d = f4;
    }

    @Override // com.google.android.libraries.navigation.internal.o.d
    public final float a() {
        return this.d;
    }

    @Override // com.google.android.libraries.navigation.internal.o.d
    public final float b() {
        return this.a;
    }

    @Override // com.google.android.libraries.navigation.internal.o.d
    public final float c() {
        return this.c;
    }

    @Override // com.google.android.libraries.navigation.internal.o.d
    public final float d() {
        return this.b;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof d) {
            d dVar = (d) obj;
            if (Float.floatToIntBits(this.a) == Float.floatToIntBits(dVar.b()) && Float.floatToIntBits(this.b) == Float.floatToIntBits(dVar.d()) && Float.floatToIntBits(this.c) == Float.floatToIntBits(dVar.c()) && Float.floatToIntBits(this.d) == Float.floatToIntBits(dVar.a())) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return ((((((Float.floatToIntBits(this.a) ^ 1000003) * 1000003) ^ Float.floatToIntBits(this.b)) * 1000003) ^ Float.floatToIntBits(this.c)) * 1000003) ^ Float.floatToIntBits(this.d);
    }

    public final String toString() {
        return "{" + this.a + ", " + this.b + ", " + this.c + ", " + this.d + "}";
    }
}
