package com.google.android.libraries.navigation.internal.cn;

import com.google.android.libraries.navigation.internal.yz.ev;
import com.google.android.libraries.navigation.internal.yz.hx;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class f extends s {
    private final int a;
    private final ev b;

    public f(int i, ev evVar) {
        this.a = i;
        this.b = evVar;
    }

    @Override // com.google.android.libraries.navigation.internal.cn.s
    public final int a() {
        return this.a;
    }

    @Override // com.google.android.libraries.navigation.internal.cn.s
    public final ev b() {
        return this.b;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof s) {
            s sVar = (s) obj;
            if (this.a == sVar.a() && hx.i(this.b, sVar.b())) {
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
