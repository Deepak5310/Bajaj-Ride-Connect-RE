package com.google.android.libraries.navigation.internal.so;

import com.google.android.libraries.navigation.internal.bp.bh;
import com.google.android.libraries.navigation.internal.yx.ar;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class e {
    public final com.google.android.libraries.navigation.internal.si.e a;
    public final boolean b;
    public final String c;
    public final boolean d;
    private bh e;
    private final com.google.android.libraries.navigation.internal.su.d f;

    public e(d dVar) {
        com.google.android.libraries.navigation.internal.si.e eVar = dVar.a;
        this.a = eVar;
        this.e = dVar.b;
        this.b = dVar.c;
        this.c = dVar.d;
        com.google.android.libraries.navigation.internal.su.d dVar2 = dVar.e;
        this.f = dVar2;
        this.d = dVar.f;
        if (eVar == com.google.android.libraries.navigation.internal.si.e.GUIDED_NAV) {
            ar.q(this.e);
        } else {
            if (eVar != com.google.android.libraries.navigation.internal.si.e.FREE_NAV) {
                throw new IllegalStateException("Unrecognized mode: ".concat(String.valueOf(String.valueOf(eVar))));
            }
            ar.q(dVar2);
        }
    }

    public final com.google.android.libraries.navigation.internal.su.d a() {
        com.google.android.libraries.navigation.internal.su.d dVar = this.f;
        ar.q(dVar);
        return dVar;
    }

    public final bh b() {
        ar.q(this.e);
        return this.e;
    }
}
