package com.google.android.libraries.navigation.internal.kh;

import com.google.android.libraries.navigation.internal.yz.ev;
import com.google.android.libraries.navigation.internal.yz.hx;
import java.util.Objects;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class b extends o {
    public final com.google.android.libraries.navigation.internal.hj.i a;
    public final ev b;
    public final y c;

    public b(com.google.android.libraries.navigation.internal.hj.i iVar, ev evVar, y yVar) {
        Objects.requireNonNull(iVar);
        this.a = iVar;
        Objects.requireNonNull(evVar);
        this.b = evVar;
        Objects.requireNonNull(yVar);
        this.c = yVar;
    }

    @Override // com.google.android.libraries.navigation.internal.kh.o
    public final com.google.android.libraries.navigation.internal.hj.i a() {
        return this.a;
    }

    @Override // com.google.android.libraries.navigation.internal.kh.o
    public final y b() {
        return this.c;
    }

    @Override // com.google.android.libraries.navigation.internal.kh.o
    public final ev c() {
        return this.b;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof o) {
            o oVar = (o) obj;
            if (this.a.equals(oVar.a()) && hx.i(this.b, oVar.c()) && this.c.equals(oVar.b())) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return ((((this.a.hashCode() ^ 1000003) * 1000003) ^ this.b.hashCode()) * 1000003) ^ this.c.hashCode();
    }

    public final String toString() {
        y yVar = this.c;
        ev evVar = this.b;
        return "{" + String.valueOf(this.a) + ", " + String.valueOf(evVar) + ", " + String.valueOf(yVar) + "}";
    }
}
