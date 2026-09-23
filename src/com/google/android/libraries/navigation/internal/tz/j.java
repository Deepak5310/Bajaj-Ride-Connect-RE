package com.google.android.libraries.navigation.internal.tz;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class j extends t {
    private final int a;
    private final int b;
    private final int c;
    private final int d;

    public j(int i, int i2, int i3, int i4) {
        this.a = i;
        this.b = i2;
        this.c = i3;
        this.d = i4;
    }

    @Override // com.google.android.libraries.navigation.internal.tz.t
    public final int a() {
        return this.c;
    }

    @Override // com.google.android.libraries.navigation.internal.tz.t
    public final int b() {
        return this.d;
    }

    @Override // com.google.android.libraries.navigation.internal.tz.t
    public final int c() {
        return this.b;
    }

    @Override // com.google.android.libraries.navigation.internal.tz.t
    public final int d() {
        return this.a;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof t) {
            t tVar = (t) obj;
            if (this.a == tVar.d() && this.b == tVar.c() && this.c == tVar.a() && this.d == tVar.b()) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return ((((((this.a ^ 1000003) * 1000003) ^ this.b) * 1000003) ^ this.c) * 1000003) ^ this.d;
    }

    public final String toString() {
        return "{" + this.a + ", " + this.b + ", " + this.c + ", " + this.d + "}";
    }
}
