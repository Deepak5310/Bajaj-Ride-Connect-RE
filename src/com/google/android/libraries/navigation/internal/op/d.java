package com.google.android.libraries.navigation.internal.op;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class d extends l {
    public final float a;
    public final float b;
    public final float c;
    public final float d;

    public d(float f, float f2, float f3, float f4) {
        this.a = f;
        this.b = f2;
        this.c = f3;
        this.d = f4;
    }

    @Override // com.google.android.libraries.navigation.internal.op.l
    public final float a() {
        return this.d;
    }

    @Override // com.google.android.libraries.navigation.internal.op.l
    public final float b() {
        return this.a;
    }

    @Override // com.google.android.libraries.navigation.internal.op.l
    public final float c() {
        return this.c;
    }

    @Override // com.google.android.libraries.navigation.internal.op.l
    public final float d() {
        return this.b;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof l) {
            l lVar = (l) obj;
            if (Float.floatToIntBits(this.a) == Float.floatToIntBits(lVar.b()) && Float.floatToIntBits(this.b) == Float.floatToIntBits(lVar.d()) && Float.floatToIntBits(this.c) == Float.floatToIntBits(lVar.c()) && Float.floatToIntBits(this.d) == Float.floatToIntBits(lVar.a())) {
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
