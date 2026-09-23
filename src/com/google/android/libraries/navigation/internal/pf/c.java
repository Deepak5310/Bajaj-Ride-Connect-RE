package com.google.android.libraries.navigation.internal.pf;

import com.google.android.libraries.navigation.internal.adr.ah;
import com.google.android.libraries.navigation.internal.adr.el;
import com.google.android.libraries.navigation.internal.jy.p;
import com.google.android.libraries.navigation.internal.oe.ad;
import com.google.android.libraries.navigation.internal.oe.x;
import com.google.android.libraries.navigation.internal.tt.d;
import com.google.android.libraries.navigation.internal.yx.an;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class c extends b {
    public final d a;

    public c(x xVar, d dVar, p pVar) {
        super(((com.google.android.libraries.navigation.internal.tt.b) dVar).b, xVar);
        this.a = dVar;
    }

    public static c a(el elVar, ad adVar, an anVar) {
        ah ahVar = elVar.w;
        if (ahVar == null) {
            ahVar = ah.a;
        }
        if (ahVar.e.size() == 0) {
            return null;
        }
        x xVar = new x();
        adVar.i(0.5f, xVar);
        return new c(xVar, d.I(elVar), (p) anVar.f());
    }
}
