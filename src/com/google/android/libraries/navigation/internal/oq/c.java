package com.google.android.libraries.navigation.internal.oq;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class c extends j {
    public final float a;
    public final float b;

    public c(float f, float f2) {
        this.a = f;
        this.b = f2;
    }

    @Override // com.google.android.libraries.navigation.internal.oq.j
    public final float a() {
        return this.a;
    }

    @Override // com.google.android.libraries.navigation.internal.oq.j
    public final float b() {
        return this.b;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof j) {
            j jVar = (j) obj;
            if (Float.floatToIntBits(this.a) == Float.floatToIntBits(jVar.a()) && Float.floatToIntBits(this.b) == Float.floatToIntBits(jVar.b())) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return ((Float.floatToIntBits(this.a) ^ 1000003) * 1000003) ^ Float.floatToIntBits(this.b);
    }

    public final String toString() {
        return "{" + this.a + ", " + this.b + "}";
    }
}
