package com.google.android.libraries.geo.mapcore.renderer;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes2.dex */
public final class g extends eg {
    public final int a;
    public final int b;

    public g(int i, int i2) {
        this.a = i;
        this.b = i2;
    }

    @Override // com.google.android.libraries.geo.mapcore.renderer.eg
    public final int a() {
        return this.b;
    }

    @Override // com.google.android.libraries.geo.mapcore.renderer.eg
    public final int b() {
        return this.a;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof eg) {
            eg egVar = (eg) obj;
            if (this.a == egVar.b() && this.b == egVar.a()) {
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
