package com.google.android.libraries.navigation.internal.hf;

import java.util.Objects;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class a extends i {
    public final h a;
    private final int c;
    private final double d;

    public a(h hVar, int i, double d) {
        Objects.requireNonNull(hVar);
        this.a = hVar;
        this.c = i;
        this.d = d;
    }

    @Override // com.google.android.libraries.navigation.internal.hf.i
    public final double a() {
        return this.d;
    }

    @Override // com.google.android.libraries.navigation.internal.hf.i
    public final int b() {
        return this.c;
    }

    @Override // com.google.android.libraries.navigation.internal.hf.i
    public final h c() {
        return this.a;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof i) {
            i iVar = (i) obj;
            if (this.a.equals(iVar.c()) && this.c == iVar.b() && Double.doubleToLongBits(this.d) == Double.doubleToLongBits(iVar.a())) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int iHashCode = this.a.hashCode() ^ 1000003;
        double d = this.d;
        return (((iHashCode * 1000003) ^ this.c) * 1000003) ^ ((int) (Double.doubleToLongBits(d) ^ (Double.doubleToLongBits(d) >>> 32)));
    }

    public final String toString() {
        return "{" + String.valueOf(this.a) + ", " + this.c + ", " + this.d + "}";
    }
}
