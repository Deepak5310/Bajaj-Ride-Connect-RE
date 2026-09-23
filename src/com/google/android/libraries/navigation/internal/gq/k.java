package com.google.android.libraries.navigation.internal.gq;

import androidx.work.WorkRequest;
import com.google.android.libraries.navigation.internal.ael.dg;
import com.google.android.libraries.navigation.internal.afl.bd;
import com.google.android.libraries.navigation.internal.afl.mf;
import com.mappls.sdk.navigation.NavigationConstants;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class k implements j {
    public final com.google.android.libraries.navigation.internal.afo.a a;
    public final com.google.android.libraries.navigation.internal.gh.c b;

    public k(com.google.android.libraries.navigation.internal.afo.a aVar) {
        this.a = aVar;
        com.google.android.libraries.navigation.internal.xn.a aVar2 = com.google.android.libraries.navigation.internal.gh.d.a;
        com.google.android.libraries.navigation.internal.gh.c cVar = new com.google.android.libraries.navigation.internal.gh.c();
        this.b = cVar;
        bd bdVar = bd.TACTILE_DIRECTIONS_REQUEST;
        cVar.i = com.google.android.libraries.navigation.internal.gd.a.GMM_API;
        com.google.android.libraries.navigation.internal.gd.f fVar = (com.google.android.libraries.navigation.internal.gd.f) com.google.android.libraries.navigation.internal.gd.i.a.q();
        if (!fVar.b.H()) {
            fVar.v();
        }
        com.google.android.libraries.navigation.internal.gd.i iVar = (com.google.android.libraries.navigation.internal.gd.i) fVar.b;
        iVar.b |= 128;
        iVar.j = true;
        if (!fVar.b.H()) {
            fVar.v();
        }
        com.google.android.libraries.navigation.internal.gd.i iVar2 = (com.google.android.libraries.navigation.internal.gd.i) fVar.b;
        iVar2.b |= 512;
        iVar2.l = false;
        if (!fVar.b.H()) {
            fVar.v();
        }
        com.google.android.libraries.navigation.internal.gd.i iVar3 = (com.google.android.libraries.navigation.internal.gd.i) fVar.b;
        iVar3.b |= 1;
        iVar3.c = false;
        if (!fVar.b.H()) {
            fVar.v();
        }
        com.google.android.libraries.navigation.internal.gd.i iVar4 = (com.google.android.libraries.navigation.internal.gd.i) fVar.b;
        iVar4.b |= 8;
        iVar4.f = false;
        if (!fVar.b.H()) {
            fVar.v();
        }
        com.google.android.libraries.navigation.internal.gd.i iVar5 = (com.google.android.libraries.navigation.internal.gd.i) fVar.b;
        iVar5.b |= 2;
        iVar5.d = false;
        if (!fVar.b.H()) {
            fVar.v();
        }
        com.google.android.libraries.navigation.internal.gd.i iVar6 = (com.google.android.libraries.navigation.internal.gd.i) fVar.b;
        iVar6.b |= 32;
        iVar6.h = true;
        if (!fVar.b.H()) {
            fVar.v();
        }
        com.google.android.libraries.navigation.internal.gd.i iVar7 = (com.google.android.libraries.navigation.internal.gd.i) fVar.b;
        iVar7.b |= 64;
        iVar7.i = false;
        if (!fVar.b.H()) {
            fVar.v();
        }
        com.google.android.libraries.navigation.internal.gd.i.b((com.google.android.libraries.navigation.internal.gd.i) fVar.b);
        com.google.android.libraries.navigation.internal.gd.h hVar = com.google.android.libraries.navigation.internal.gd.h.UNSPECIFIED;
        if (!fVar.b.H()) {
            fVar.v();
        }
        com.google.android.libraries.navigation.internal.gd.i iVar8 = (com.google.android.libraries.navigation.internal.gd.i) fVar.b;
        iVar8.k = hVar.d;
        iVar8.b |= 256;
        if (!fVar.b.H()) {
            fVar.v();
        }
        com.google.android.libraries.navigation.internal.gd.i iVar9 = (com.google.android.libraries.navigation.internal.gd.i) fVar.b;
        iVar9.b |= 16;
        iVar9.g = false;
        cVar.a = (com.google.android.libraries.navigation.internal.gd.i) fVar.t();
        com.google.android.libraries.navigation.internal.gd.j jVar = (com.google.android.libraries.navigation.internal.gd.j) com.google.android.libraries.navigation.internal.gd.k.a.q();
        if (!jVar.b.H()) {
            jVar.v();
        }
        com.google.android.libraries.navigation.internal.gd.k kVar = (com.google.android.libraries.navigation.internal.gd.k) jVar.b;
        kVar.b |= 8;
        kVar.f = NavigationConstants.UI_HANDLER_LOCATION_SERVICE;
        if (!jVar.b.H()) {
            jVar.v();
        }
        com.google.android.libraries.navigation.internal.gd.k kVar2 = (com.google.android.libraries.navigation.internal.gd.k) jVar.b;
        kVar2.b |= 2;
        kVar2.d = 2;
        if (!jVar.b.H()) {
            jVar.v();
        }
        com.google.android.libraries.navigation.internal.gd.k.b((com.google.android.libraries.navigation.internal.gd.k) jVar.b);
        if (!jVar.b.H()) {
            jVar.v();
        }
        com.google.android.libraries.navigation.internal.gd.k kVar3 = (com.google.android.libraries.navigation.internal.gd.k) jVar.b;
        kVar3.b |= 4;
        kVar3.e = WorkRequest.DEFAULT_BACKOFF_DELAY_MILLIS;
        cVar.a((com.google.android.libraries.navigation.internal.gd.k) jVar.t());
        com.google.android.libraries.navigation.internal.gd.n nVar = (com.google.android.libraries.navigation.internal.gd.n) com.google.android.libraries.navigation.internal.gd.o.a.q();
        if (!nVar.b.H()) {
            nVar.v();
        }
        com.google.android.libraries.navigation.internal.gd.o.b((com.google.android.libraries.navigation.internal.gd.o) nVar.b);
        cVar.b((com.google.android.libraries.navigation.internal.gd.o) nVar.t());
        cVar.g = bdVar;
        cVar.h = (dg) mf.a.aH(7, null);
        com.google.android.libraries.navigation.internal.gd.b bVar = (com.google.android.libraries.navigation.internal.gd.b) com.google.android.libraries.navigation.internal.gd.e.a.q();
        int i = com.google.android.libraries.navigation.internal.gd.d.a;
        if (!bVar.b.H()) {
            bVar.v();
        }
        com.google.android.libraries.navigation.internal.gd.e eVar = (com.google.android.libraries.navigation.internal.gd.e) bVar.b;
        int i2 = i - 1;
        if (i == 0) {
            throw null;
        }
        eVar.d = i2;
        eVar.b |= 2;
        if (!bVar.b.H()) {
            bVar.v();
        }
        com.google.android.libraries.navigation.internal.gd.e eVar2 = (com.google.android.libraries.navigation.internal.gd.e) bVar.b;
        eVar2.b |= 4;
        eVar2.e = 0;
        cVar.d = (com.google.android.libraries.navigation.internal.gd.e) bVar.t();
    }

    @Override // com.google.android.libraries.navigation.internal.gg.f
    public final /* synthetic */ com.google.android.libraries.navigation.internal.gg.g a() {
        return new l(this);
    }

    @Override // com.google.android.libraries.navigation.internal.gg.f
    public final com.google.android.libraries.navigation.internal.gh.c b() {
        return this.b;
    }

    @Override // com.google.android.libraries.navigation.internal.gq.j
    public final /* synthetic */ l c() {
        return new l(this);
    }
}
