package com.google.android.libraries.geo.mapcore.internal.model;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes2.dex */
public final class j extends aa {
    public final int a;
    public final int b;
    public final int c;
    public final int d;

    public j(int i, int i2, int i3, int i4) {
        this.a = i;
        this.b = i2;
        this.c = i3;
        this.d = i4;
    }

    @Override // com.google.android.libraries.geo.mapcore.internal.model.aa
    public final int a() {
        return this.d;
    }

    @Override // com.google.android.libraries.geo.mapcore.internal.model.aa
    public final int b() {
        return this.a;
    }

    @Override // com.google.android.libraries.geo.mapcore.internal.model.aa
    public final int c() {
        return this.c;
    }

    @Override // com.google.android.libraries.geo.mapcore.internal.model.aa
    public final int d() {
        return this.b;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof aa) {
            aa aaVar = (aa) obj;
            if (this.a == aaVar.b() && this.b == aaVar.d() && this.c == aaVar.c() && this.d == aaVar.a()) {
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
