package com.google.android.libraries.navigation.internal.br;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class b extends e {
    private final int a;
    private final int b;

    public b(int i, int i2) {
        this.a = i;
        this.b = i2;
    }

    @Override // com.google.android.libraries.navigation.internal.br.e
    public final int a() {
        return this.a;
    }

    @Override // com.google.android.libraries.navigation.internal.br.e
    public final int b() {
        return this.b;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof e) {
            e eVar = (e) obj;
            if (this.a == eVar.a() && this.b == eVar.b()) {
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
