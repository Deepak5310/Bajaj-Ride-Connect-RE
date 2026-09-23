package com.google.android.libraries.navigation.internal.cq;

import com.google.android.libraries.navigation.internal.yz.ev;
import com.google.android.libraries.navigation.internal.yz.hx;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class d extends m {
    private final int a;
    private final ev b;

    public d(int i, ev evVar) {
        this.a = i;
        this.b = evVar;
    }

    @Override // com.google.android.libraries.navigation.internal.cq.m
    public final int a() {
        return this.a;
    }

    @Override // com.google.android.libraries.navigation.internal.cq.m
    public final ev b() {
        return this.b;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof m) {
            m mVar = (m) obj;
            if (this.a == mVar.a() && hx.i(this.b, mVar.b())) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return ((this.a ^ 1000003) * 1000003) ^ this.b.hashCode();
    }

    public final String toString() {
        return "{" + this.a + ", " + String.valueOf(this.b) + "}";
    }
}
