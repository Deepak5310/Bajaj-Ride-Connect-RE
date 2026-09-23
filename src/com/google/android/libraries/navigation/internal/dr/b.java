package com.google.android.libraries.navigation.internal.dr;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class b extends y {
    private final int a;
    private final int b;

    public b(int i, int i2) {
        this.a = i;
        this.b = i2;
    }

    @Override // com.google.android.libraries.navigation.internal.dr.y
    public final int a() {
        return this.a;
    }

    @Override // com.google.android.libraries.navigation.internal.dr.y
    public final int b() {
        return this.b;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof y) {
            y yVar = (y) obj;
            if (this.a == yVar.a() && this.b == yVar.b()) {
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
