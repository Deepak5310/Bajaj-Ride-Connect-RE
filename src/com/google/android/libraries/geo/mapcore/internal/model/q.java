package com.google.android.libraries.geo.mapcore.internal.model;

import java.util.Objects;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes2.dex */
public final class q extends cl {
    public final ck a;
    public final com.google.android.libraries.navigation.internal.yx.an b;

    public q(ck ckVar, com.google.android.libraries.navigation.internal.yx.an anVar) {
        Objects.requireNonNull(ckVar);
        this.a = ckVar;
        Objects.requireNonNull(anVar);
        this.b = anVar;
    }

    @Override // com.google.android.libraries.geo.mapcore.internal.model.cl
    public final ck a() {
        return this.a;
    }

    @Override // com.google.android.libraries.geo.mapcore.internal.model.cl
    public final com.google.android.libraries.navigation.internal.yx.an b() {
        return this.b;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof cl) {
            cl clVar = (cl) obj;
            if (this.a.equals(clVar.a()) && this.b.equals(clVar.b())) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return ((this.a.hashCode() ^ 1000003) * 1000003) ^ this.b.hashCode();
    }

    public final String toString() {
        com.google.android.libraries.navigation.internal.yx.an anVar = this.b;
        return "{" + String.valueOf(this.a) + ", " + anVar.toString() + "}";
    }
}
