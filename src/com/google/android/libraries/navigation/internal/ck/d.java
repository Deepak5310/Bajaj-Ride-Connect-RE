package com.google.android.libraries.navigation.internal.ck;

import com.google.android.libraries.navigation.internal.yz.ev;
import com.google.android.libraries.navigation.internal.yz.hx;
import java.util.Objects;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class d extends bf {
    public final bi a;
    public final com.google.android.libraries.navigation.internal.ady.al b;
    public final ev c;
    public final boolean d;

    public d(bi biVar, com.google.android.libraries.navigation.internal.ady.al alVar, ev evVar, boolean z) {
        Objects.requireNonNull(biVar);
        this.a = biVar;
        Objects.requireNonNull(alVar);
        this.b = alVar;
        Objects.requireNonNull(evVar);
        this.c = evVar;
        this.d = z;
    }

    @Override // com.google.android.libraries.navigation.internal.ck.bf
    public final bi a() {
        return this.a;
    }

    @Override // com.google.android.libraries.navigation.internal.ck.bf
    public final ev b() {
        return this.c;
    }

    @Override // com.google.android.libraries.navigation.internal.ck.bf
    public final com.google.android.libraries.navigation.internal.ady.al c() {
        return this.b;
    }

    @Override // com.google.android.libraries.navigation.internal.ck.bf
    public final boolean d() {
        return this.d;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof bf) {
            bf bfVar = (bf) obj;
            if (this.a.equals(bfVar.a()) && this.b.equals(bfVar.c()) && hx.i(this.c, bfVar.b()) && this.d == bfVar.d()) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return ((((((this.a.hashCode() ^ 1000003) * 1000003) ^ this.b.hashCode()) * 1000003) ^ this.c.hashCode()) * 1000003) ^ (true != this.d ? 1237 : 1231);
    }

    public final String toString() {
        ev evVar = this.c;
        com.google.android.libraries.navigation.internal.ady.al alVar = this.b;
        return "{" + this.a.toString() + ", " + String.valueOf(alVar) + ", " + String.valueOf(evVar) + ", " + this.d + "}";
    }
}
