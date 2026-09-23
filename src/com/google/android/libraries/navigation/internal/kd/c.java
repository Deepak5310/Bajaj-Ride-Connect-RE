package com.google.android.libraries.navigation.internal.kd;

import com.google.android.libraries.navigation.internal.yz.ev;
import com.google.android.libraries.navigation.internal.yz.hx;
import com.google.android.libraries.navigation.internal.zp.ce;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class c extends i {
    public final ev a;
    public final ce b;

    public c(ev evVar, ce ceVar) {
        this.a = evVar;
        this.b = ceVar;
    }

    @Override // com.google.android.libraries.navigation.internal.kd.i
    public final ev a() {
        return this.a;
    }

    @Override // com.google.android.libraries.navigation.internal.kd.i
    public final ce b() {
        return this.b;
    }

    @Override // com.google.android.libraries.navigation.internal.kd.i
    public final void c() {
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof i) {
            i iVar = (i) obj;
            if (hx.i(this.a, iVar.a()) && this.b.equals(iVar.b())) {
                iVar.c();
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return (((this.a.hashCode() ^ 1000003) * 1000003) ^ this.b.hashCode()) * 1000003;
    }

    public final String toString() {
        ce ceVar = this.b;
        return "{" + String.valueOf(this.a) + ", " + String.valueOf(ceVar) + ", null}";
    }
}
