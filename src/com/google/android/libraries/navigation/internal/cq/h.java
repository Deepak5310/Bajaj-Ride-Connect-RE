package com.google.android.libraries.navigation.internal.cq;

import com.google.android.libraries.navigation.internal.yz.ev;
import com.google.android.libraries.navigation.internal.yz.hx;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class h extends ag {
    private final long a;
    private final ev b;

    public h(long j, ev evVar) {
        this.a = j;
        this.b = evVar;
    }

    @Override // com.google.android.libraries.navigation.internal.cq.ag
    public final long a() {
        return this.a;
    }

    @Override // com.google.android.libraries.navigation.internal.cq.ag
    public final ev b() {
        return this.b;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof ag) {
            ag agVar = (ag) obj;
            if (this.a == agVar.a() && hx.i(this.b, agVar.b())) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        long j = this.a;
        return ((((int) (j ^ (j >>> 32))) ^ 1000003) * 1000003) ^ this.b.hashCode();
    }

    public final String toString() {
        return "{" + this.a + ", " + String.valueOf(this.b) + "}";
    }
}
