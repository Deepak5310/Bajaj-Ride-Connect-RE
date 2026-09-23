package com.google.android.libraries.navigation.internal.xh;

import com.google.android.libraries.navigation.internal.ael.bs;
import com.google.android.libraries.navigation.internal.aer.l;
import com.google.android.libraries.navigation.internal.aer.m;
import com.google.android.libraries.navigation.internal.aer.n;
import com.google.android.libraries.navigation.internal.gg.i;
import com.google.android.libraries.navigation.internal.gg.o;
import com.google.android.libraries.navigation.internal.iv.ab;
import com.google.android.libraries.navigation.internal.iv.f;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class d implements com.google.android.libraries.navigation.internal.gg.e {
    final /* synthetic */ e a;

    public d(e eVar) {
        this.a = eVar;
    }

    @Override // com.google.android.libraries.navigation.internal.gg.e
    public final void a(i iVar, o oVar) {
        synchronized (this.a) {
            this.a.c(oVar);
        }
    }

    @Override // com.google.android.libraries.navigation.internal.gg.e
    public final /* bridge */ /* synthetic */ void b(i iVar, Object obj) {
        l lVar = (l) obj;
        synchronized (this.a) {
            int iA = n.a(lVar.c);
            if (iA == 0) {
                iA = n.e;
            }
            if (iA != n.b) {
                this.a.c(o.j);
                return;
            }
            bs bsVar = new bs(lVar.d, l.a);
            a aVar = new a(bsVar.contains(m.CONTRACT_HAPPY_MEAL), bsVar.contains(m.ALLOWLIST_TOS), lVar.e);
            f fVar = this.a.a;
            fVar.n(ab.bf, aVar.a);
            fVar.n(ab.be, aVar.b);
            fVar.r(ab.bg, aVar.c);
            this.a.b.d(aVar);
        }
    }
}
