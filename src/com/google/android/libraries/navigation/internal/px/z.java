package com.google.android.libraries.navigation.internal.px;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class z extends ej {
    public final int a;
    public final int b;

    public z(int i, int i2) {
        this.a = i;
        this.b = i2;
    }

    @Override // com.google.android.libraries.navigation.internal.px.ej
    public final int a() {
        return this.b;
    }

    @Override // com.google.android.libraries.navigation.internal.px.ej
    public final int b() {
        return this.a;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof ej) {
            ej ejVar = (ej) obj;
            if (this.a == ejVar.b() && this.b == ejVar.a()) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return ((this.a ^ 1000003) * 1000003) ^ this.b;
    }

    public final String toString() {
        return "{" + this.a + ", " + this.b + "}";
    }
}
