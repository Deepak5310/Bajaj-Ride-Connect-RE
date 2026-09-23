package com.google.android.libraries.navigation.internal.om;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class b extends j {
    public final float a;
    private final boolean b;

    public b(float f, boolean z) {
        this.a = f;
        this.b = z;
    }

    @Override // com.google.android.libraries.navigation.internal.om.j
    public final float a() {
        return this.a;
    }

    @Override // com.google.android.libraries.navigation.internal.om.j
    public final boolean b() {
        return this.b;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof j) {
            j jVar = (j) obj;
            if (Float.floatToIntBits(this.a) == Float.floatToIntBits(jVar.a()) && this.b == jVar.b()) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return ((Float.floatToIntBits(this.a) ^ 1000003) * 1000003) ^ (true != this.b ? 1237 : 1231);
    }

    public final String toString() {
        return "{" + this.a + ", " + this.b + "}";
    }
}
