package com.google.android.libraries.navigation.internal.ky;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class j extends t {
    public final com.google.android.libraries.navigation.internal.afk.f a;

    public j(com.google.android.libraries.navigation.internal.afk.f fVar) {
        this.a = fVar;
    }

    @Override // com.google.android.libraries.navigation.internal.ky.t
    public final com.google.android.libraries.navigation.internal.afk.f a() {
        return this.a;
    }

    @Override // com.google.android.libraries.navigation.internal.ky.t
    public final void b() {
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof t) {
            t tVar = (t) obj;
            tVar.b();
            if (this.a.equals(tVar.a())) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return this.a.hashCode() ^ (-615537384);
    }

    public final String toString() {
        return "ComplianceProductData{productId=79508299, productIdOrigin=" + this.a.toString() + "}";
    }
}
