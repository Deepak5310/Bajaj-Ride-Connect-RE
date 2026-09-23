package com.google.android.libraries.navigation.internal.bp;

import com.google.android.libraries.navigation.internal.yz.ev;
import com.google.android.libraries.navigation.internal.yz.hx;
import java.util.Objects;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class m extends bh {
    public final int a;
    private final ev c;
    private final com.google.android.libraries.navigation.internal.ady.al d;

    public m(ev evVar, int i, com.google.android.libraries.navigation.internal.ady.al alVar) {
        Objects.requireNonNull(evVar);
        this.c = evVar;
        this.a = i;
        this.d = alVar;
    }

    @Override // com.google.android.libraries.navigation.internal.bp.bh
    public final int a() {
        return this.a;
    }

    @Override // com.google.android.libraries.navigation.internal.bp.bh
    public final ev b() {
        return this.c;
    }

    @Override // com.google.android.libraries.navigation.internal.bp.bh
    public final com.google.android.libraries.navigation.internal.ady.al c() {
        return this.d;
    }

    public final boolean equals(Object obj) {
        com.google.android.libraries.navigation.internal.ady.al alVar;
        if (obj == this) {
            return true;
        }
        if (obj instanceof bh) {
            bh bhVar = (bh) obj;
            if (hx.i(this.c, bhVar.b()) && this.a == bhVar.a() && ((alVar = this.d) != null ? alVar.equals(bhVar.c()) : bhVar.c() == null)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int iHashCode = this.c.hashCode() ^ 1000003;
        com.google.android.libraries.navigation.internal.ady.al alVar = this.d;
        return (((iHashCode * 1000003) ^ this.a) * 1000003) ^ (alVar == null ? 0 : alVar.hashCode());
    }

    public final String toString() {
        com.google.android.libraries.navigation.internal.ady.al alVar = this.d;
        return "{" + String.valueOf(this.c) + ", " + this.a + ", " + String.valueOf(alVar) + "}";
    }
}
