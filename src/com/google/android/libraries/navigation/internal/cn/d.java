package com.google.android.libraries.navigation.internal.cn;

import com.google.android.libraries.navigation.internal.yz.ev;
import com.google.android.libraries.navigation.internal.yz.hx;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class d extends q {
    public final ev a;
    private final ev b;

    public d(ev evVar, ev evVar2) {
        this.b = evVar;
        this.a = evVar2;
    }

    @Override // com.google.android.libraries.navigation.internal.cn.q
    public final ev a() {
        return this.a;
    }

    @Override // com.google.android.libraries.navigation.internal.cn.q
    public final ev b() {
        return this.b;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof q) {
            q qVar = (q) obj;
            if (hx.i(this.b, qVar.b()) && hx.i(this.a, qVar.a())) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return ((this.b.hashCode() ^ 1000003) * 1000003) ^ this.a.hashCode();
    }

    public final String toString() {
        ev evVar = this.a;
        return "{" + String.valueOf(this.b) + ", " + String.valueOf(evVar) + "}";
    }
}
