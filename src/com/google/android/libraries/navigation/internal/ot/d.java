package com.google.android.libraries.navigation.internal.ot;

import com.google.android.libraries.navigation.internal.ol.t;
import java.util.Objects;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class d extends p {
    public final t a;
    private final o b;

    public d(o oVar, t tVar) {
        Objects.requireNonNull(oVar);
        this.b = oVar;
        Objects.requireNonNull(tVar);
        this.a = tVar;
    }

    @Override // com.google.android.libraries.navigation.internal.ot.p
    public final t a() {
        return this.a;
    }

    @Override // com.google.android.libraries.navigation.internal.ot.p
    public final o b() {
        return this.b;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof p) {
            p pVar = (p) obj;
            if (this.b.equals(pVar.b()) && this.a.equals(pVar.a())) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return ((this.b.hashCode() ^ 1000003) * 1000003) ^ this.a.hashCode();
    }

    public final String toString() {
        t tVar = this.a;
        return "{" + String.valueOf(this.b) + ", " + tVar.toString() + "}";
    }
}
