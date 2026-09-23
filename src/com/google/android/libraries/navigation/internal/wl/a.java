package com.google.android.libraries.navigation.internal.wl;

import com.google.android.libraries.navigation.internal.ade.n;
import com.google.android.libraries.navigation.internal.bp.bg;
import java.util.Objects;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class a extends c {
    private final bg a;
    private final n b;

    public a(bg bgVar, n nVar) {
        Objects.requireNonNull(bgVar);
        this.a = bgVar;
        Objects.requireNonNull(nVar);
        this.b = nVar;
    }

    @Override // com.google.android.libraries.navigation.internal.wl.c
    public final bg a() {
        return this.a;
    }

    @Override // com.google.android.libraries.navigation.internal.wl.c
    public final n b() {
        return this.b;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof c) {
            c cVar = (c) obj;
            if (this.a.equals(cVar.a()) && this.b.equals(cVar.b())) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int iN;
        int iHashCode = this.a.hashCode() ^ 1000003;
        n nVar = this.b;
        if (nVar.H()) {
            iN = nVar.n();
        } else {
            int iN2 = nVar.ak;
            if (iN2 == 0) {
                iN2 = nVar.n();
                nVar.ak = iN2;
            }
            iN = iN2;
        }
        return (iHashCode * 1000003) ^ iN;
    }

    public final String toString() {
        n nVar = this.b;
        return "{" + String.valueOf(this.a) + ", " + String.valueOf(nVar) + "}";
    }
}
