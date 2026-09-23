package com.google.android.libraries.navigation.internal.rz;

import com.google.android.libraries.navigation.internal.yz.ev;
import com.google.android.libraries.navigation.internal.yz.hx;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class d extends v {
    private final ev a;

    public d(ev evVar) {
        this.a = evVar;
    }

    @Override // com.google.android.libraries.navigation.internal.rz.v
    public final ev a() {
        return this.a;
    }

    @Override // com.google.android.libraries.navigation.internal.rz.v
    public final void b() {
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof v) {
            v vVar = (v) obj;
            if (hx.i(this.a, vVar.a())) {
                int iFloatToIntBits = Float.floatToIntBits(0.0f);
                vVar.b();
                if (iFloatToIntBits == Float.floatToIntBits(0.0f)) {
                    return true;
                }
            }
        }
        return false;
    }

    public final int hashCode() {
        return ((this.a.hashCode() ^ 1000003) * 1000003) ^ Float.floatToIntBits(0.0f);
    }

    public final String toString() {
        return "{" + String.valueOf(this.a) + ", 0.0}";
    }
}
