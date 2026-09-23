package com.google.android.libraries.navigation.internal.yz;

import java.io.Serializable;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class fu implements Serializable {
    private final ev a;

    public fu(ev evVar) {
        this.a = evVar;
    }

    Object readResolve() {
        if (this.a.isEmpty()) {
            return fv.a;
        }
        return hx.i(this.a, ev.q(lr.a)) ? fv.b : new fv(this.a);
    }
}
