package com.google.android.libraries.navigation.internal.bm;

import com.google.android.libraries.navigation.internal.bp.bh;
import com.google.android.libraries.navigation.internal.yz.ev;
import com.google.android.libraries.navigation.internal.yz.fy;
import com.google.android.libraries.navigation.internal.yz.lv;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class m {
    final /* synthetic */ o a;

    public m(o oVar) {
        this.a = oVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void a(com.google.android.libraries.navigation.internal.bt.h hVar, com.google.android.libraries.navigation.internal.bq.a aVar) {
        com.google.android.libraries.navigation.internal.hx.ap.UI_THREAD.f();
        com.google.android.libraries.navigation.internal.bt.b bVar = (com.google.android.libraries.navigation.internal.bt.b) hVar;
        bh bhVar = bVar.a;
        boolean z = bhVar.k() && bhVar.f().j == com.google.android.libraries.navigation.internal.ady.al.TRANSIT;
        this.a.l.d(bVar.w);
        this.a.l.c(z);
        o oVar = this.a;
        oVar.s = true;
        ev evVar = bVar.i;
        if (((lv) evVar).c == 1) {
            oVar.e.e((com.google.android.libraries.navigation.internal.ob.r) evVar.get(0));
            o oVar2 = this.a;
            oVar2.e.d(oVar2.p);
            this.a.p.clear();
        } else {
            ev evVarG = oVar.e.g(evVar, fy.o(oVar.p));
            this.a.p.clear();
            this.a.p.addAll(evVarG);
            this.a.e.c();
        }
        com.google.android.libraries.navigation.internal.oe.al alVar = aVar.b;
        o oVar3 = this.a;
        if (oVar3.q && alVar != null) {
            oVar3.e(alVar, bVar.d);
        }
        this.a.r = alVar;
    }
}
