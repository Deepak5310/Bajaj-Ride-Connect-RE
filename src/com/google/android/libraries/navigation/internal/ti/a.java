package com.google.android.libraries.navigation.internal.ti;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class a extends ab {
    private final int b;
    private final int c;

    public a(int i, int i2) {
        this.b = i;
        this.c = i2;
    }

    @Override // com.google.android.libraries.navigation.internal.ti.ab
    public final int a() {
        return this.b;
    }

    @Override // com.google.android.libraries.navigation.internal.ti.ab
    public final int b() {
        return this.c;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof ab) {
            ab abVar = (ab) obj;
            if (this.b == abVar.a() && this.c == abVar.b()) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return ((this.b ^ 1000003) * 1000003) ^ this.c;
    }

    public final String toString() {
        return "{" + this.b + ", " + this.c + "}";
    }
}
