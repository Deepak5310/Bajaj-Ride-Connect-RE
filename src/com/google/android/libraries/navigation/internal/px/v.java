package com.google.android.libraries.navigation.internal.px;

import com.google.android.libraries.navigation.internal.yz.ev;
import com.google.android.libraries.navigation.internal.yz.hx;
import java.util.Objects;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class v extends ef {
    public final ev a;
    public final ev b;
    public final ev c;

    public v(ev evVar, ev evVar2, ev evVar3) {
        Objects.requireNonNull(evVar);
        this.a = evVar;
        Objects.requireNonNull(evVar2);
        this.b = evVar2;
        Objects.requireNonNull(evVar3);
        this.c = evVar3;
    }

    @Override // com.google.android.libraries.navigation.internal.px.ef
    public final ev a() {
        return this.b;
    }

    @Override // com.google.android.libraries.navigation.internal.px.ef
    public final ev b() {
        return this.a;
    }

    @Override // com.google.android.libraries.navigation.internal.px.ef
    public final ev c() {
        return this.c;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof ef) {
            ef efVar = (ef) obj;
            if (hx.i(this.a, efVar.b()) && hx.i(this.b, efVar.a()) && hx.i(this.c, efVar.c())) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return ((((this.a.hashCode() ^ 1000003) * 1000003) ^ this.b.hashCode()) * 1000003) ^ this.c.hashCode();
    }

    public final String toString() {
        ev evVar = this.c;
        ev evVar2 = this.b;
        return "{" + String.valueOf(this.a) + ", " + String.valueOf(evVar2) + ", " + String.valueOf(evVar) + "}";
    }
}
