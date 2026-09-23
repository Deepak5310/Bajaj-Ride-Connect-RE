package com.google.android.libraries.geo.mapcore.internal.vector.gl;

import java.util.Objects;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes2.dex */
public final class a extends n {
    public final String a;
    private final o c;

    public a(String str, o oVar) {
        Objects.requireNonNull(str);
        this.a = str;
        Objects.requireNonNull(oVar);
        this.c = oVar;
    }

    @Override // com.google.android.libraries.geo.mapcore.internal.vector.gl.n
    public final o a() {
        return this.c;
    }

    @Override // com.google.android.libraries.geo.mapcore.internal.vector.gl.n
    public final String b() {
        return this.a;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof n) {
            n nVar = (n) obj;
            if (this.a.equals(nVar.b()) && this.c.equals(nVar.a())) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return ((this.a.hashCode() ^ 1000003) * 1000003) ^ this.c.hashCode();
    }

    public final String toString() {
        return "{" + this.a + ", " + String.valueOf(this.c) + "}";
    }
}
