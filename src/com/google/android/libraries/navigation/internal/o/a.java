package com.google.android.libraries.navigation.internal.o;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class a extends c {
    private final int a;
    private final int b;
    private final int c;
    private final int d;

    public a(int i, int i2, int i3, int i4) {
        this.a = i;
        this.b = i2;
        this.c = i3;
        this.d = i4;
    }

    @Override // com.google.android.libraries.navigation.internal.o.c
    public final int a() {
        return this.d;
    }

    @Override // com.google.android.libraries.navigation.internal.o.c
    public final int b() {
        return this.a;
    }

    @Override // com.google.android.libraries.navigation.internal.o.c
    public final int c() {
        return this.c;
    }

    @Override // com.google.android.libraries.navigation.internal.o.c
    public final int d() {
        return this.b;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof c) {
            c cVar = (c) obj;
            if (this.a == cVar.b() && this.b == cVar.d() && this.c == cVar.c() && this.d == cVar.a()) {
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
