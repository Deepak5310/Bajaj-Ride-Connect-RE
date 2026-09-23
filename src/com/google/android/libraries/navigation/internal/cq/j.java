package com.google.android.libraries.navigation.internal.cq;

import com.google.android.libraries.navigation.internal.yz.ev;
import com.google.android.libraries.navigation.internal.yz.hx;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class j extends af {
    private final Integer a;
    private final com.google.android.libraries.navigation.internal.ot.k b;
    private final ev c;

    public j(Integer num, com.google.android.libraries.navigation.internal.ot.k kVar, ev evVar) {
        this.a = num;
        this.b = kVar;
        this.c = evVar;
    }

    @Override // com.google.android.libraries.navigation.internal.cq.af
    public final com.google.android.libraries.navigation.internal.ot.k a() {
        return this.b;
    }

    @Override // com.google.android.libraries.navigation.internal.cq.af
    public final ev b() {
        return this.c;
    }

    @Override // com.google.android.libraries.navigation.internal.cq.af
    public final Integer c() {
        return this.a;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof af) {
            af afVar = (af) obj;
            Integer num = this.a;
            if (num != null ? num.equals(afVar.c()) : afVar.c() == null) {
                com.google.android.libraries.navigation.internal.ot.k kVar = this.b;
                if (kVar != null ? kVar.equals(afVar.a()) : afVar.a() == null) {
                    if (hx.i(this.c, afVar.b())) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public final String toString() {
        ev evVar = this.c;
        return "{" + this.a + ", " + String.valueOf(this.b) + ", " + String.valueOf(evVar) + "}";
    }

    public final int hashCode() {
        Integer num = this.a;
        int iHashCode = num == null ? 0 : num.hashCode();
        com.google.android.libraries.navigation.internal.ot.k kVar = this.b;
        return ((((iHashCode ^ 1000003) * 1000003) ^ (kVar != null ? kVar.hashCode() : 0)) * 1000003) ^ this.c.hashCode();
    }
}
