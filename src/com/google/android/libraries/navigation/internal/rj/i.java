package com.google.android.libraries.navigation.internal.rj;

import com.google.android.libraries.navigation.internal.adg.bf;
import com.google.android.libraries.navigation.internal.adg.bg;
import com.google.android.libraries.navigation.internal.adg.ef;
import com.google.android.libraries.navigation.internal.adg.eg;
import com.google.android.libraries.navigation.internal.adg.eh;
import com.google.android.libraries.navigation.internal.adg.jr;
import com.google.android.libraries.navigation.internal.ot.q;
import com.google.android.libraries.navigation.internal.rh.o;
import com.google.android.libraries.navigation.internal.rh.p;
import com.google.android.libraries.navigation.internal.rh.r;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class i implements q {
    private final com.google.android.libraries.navigation.internal.or.c a;
    private r b;

    public i(ef efVar, com.google.android.libraries.navigation.internal.ot.g gVar, com.google.android.libraries.navigation.internal.rl.d dVar, p pVar) {
        bf bfVar = (bf) bg.a.q();
        eg egVar = (eg) eh.a.q();
        egVar.d(efVar);
        if (!bfVar.b.H()) {
            bfVar.v();
        }
        bg bgVar = (bg) bfVar.b;
        eh ehVar = (eh) egVar.t();
        ehVar.getClass();
        bgVar.f = ehVar;
        bgVar.b |= 32;
        jr jrVar = ((com.google.android.libraries.navigation.internal.ot.b) gVar).a;
        if (!bfVar.b.H()) {
            bfVar.v();
        }
        bg bgVar2 = (bg) bfVar.b;
        bgVar2.c = jrVar.f;
        bgVar2.b |= 1;
        r rVarA = pVar.a((bg) bfVar.t(), dVar);
        this.b = rVarA;
        this.a = ((o) rVarA).c;
    }

    @Override // com.google.android.libraries.navigation.internal.ot.q
    public final com.google.android.libraries.navigation.internal.or.c a() {
        return this.a;
    }

    @Override // com.google.android.libraries.navigation.internal.ot.q
    public final synchronized void b() {
        r rVar = this.b;
        if (rVar != null) {
            rVar.a();
        }
    }

    @Override // com.google.android.libraries.navigation.internal.ot.q
    public final synchronized void c() {
        r rVar = this.b;
        if (rVar != null) {
            rVar.b();
            this.b = null;
        }
    }

    @Override // com.google.android.libraries.navigation.internal.ot.q
    public final synchronized void d() {
        r rVar = this.b;
        if (rVar != null) {
            rVar.c();
        }
    }
}
