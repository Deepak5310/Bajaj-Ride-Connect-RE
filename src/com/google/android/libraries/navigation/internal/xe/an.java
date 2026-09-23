package com.google.android.libraries.navigation.internal.xe;

import android.content.Context;
import com.google.android.libraries.navigation.NavigationView;
import com.google.android.libraries.navigation.internal.abh.Cdo;
import com.google.android.libraries.navigation.internal.abh.ht;
import com.google.android.libraries.navigation.internal.abh.id;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class an extends com.google.android.libraries.navigation.internal.abm.bk implements com.google.android.libraries.navigation.internal.abh.cn {
    public final com.google.android.libraries.navigation.environment.am a;
    public com.google.android.libraries.navigation.environment.aa b;
    private final dn d;
    private final ai e;
    private final am f;

    public an(com.google.android.libraries.navigation.environment.am amVar, dn dnVar, ai aiVar, am amVar2) {
        this.a = amVar;
        this.d = dnVar;
        this.e = aiVar;
        this.f = amVar2;
    }

    @Override // com.google.android.libraries.navigation.internal.abm.bk
    public final com.google.android.libraries.navigation.internal.ow.k a(com.google.android.libraries.navigation.internal.abh.be beVar, com.google.android.libraries.navigation.internal.abh.m mVar, com.google.android.libraries.navigation.internal.abh.fv fvVar) {
        return this.a;
    }

    @Override // com.google.android.libraries.navigation.internal.abm.bk
    public final com.google.android.libraries.navigation.internal.abh.bq b(Context context, com.google.android.libraries.navigation.internal.ni.a aVar, com.google.android.libraries.navigation.internal.ia.e eVar, com.google.android.libraries.navigation.internal.abh.ac acVar, com.google.android.libraries.navigation.internal.oa.k kVar, float f) {
        return new aj(this.e);
    }

    @Override // com.google.android.libraries.navigation.internal.abh.cn
    public final com.google.android.libraries.navigation.internal.abh.bv c(com.google.android.libraries.navigation.internal.abh.af afVar, com.google.android.libraries.navigation.internal.abh.ac acVar, com.google.android.libraries.navigation.internal.abh.bq bqVar, com.google.android.libraries.navigation.internal.abh.fe feVar) {
        ak akVar = new ak(afVar, acVar, bqVar, feVar, this.d);
        NavigationView navigationView = (NavigationView) ((com.google.android.libraries.navigation.as) this.f).a.get();
        if (navigationView != null) {
            navigationView.h = akVar;
        }
        return akVar;
    }

    @Override // com.google.android.libraries.navigation.internal.abh.cn
    public final Cdo d(Context context, id idVar) {
        return fj.a;
    }

    @Override // com.google.android.libraries.navigation.internal.abm.bk
    public final com.google.android.libraries.navigation.internal.abh.ef e(com.google.android.libraries.navigation.internal.ow.k kVar, com.google.android.libraries.navigation.internal.abn.as asVar, String str, Integer num, boolean z, boolean z2, com.google.android.libraries.navigation.internal.wd.g gVar, com.google.android.libraries.navigation.internal.abh.be beVar) {
        com.google.android.libraries.navigation.environment.h hVarBG = this.a.bG();
        hVarBG.b = asVar;
        hVarBG.c = str;
        hVarBG.d = num;
        hVarBG.f = Boolean.valueOf(z2);
        com.google.android.libraries.navigation.internal.afr.j.b(beVar);
        hVarBG.g = beVar;
        hVarBG.e = Boolean.valueOf(z);
        com.google.android.libraries.navigation.internal.afr.j.a(hVarBG.b, com.google.android.libraries.navigation.internal.pn.j.class);
        com.google.android.libraries.navigation.internal.afr.j.a(hVarBG.c, String.class);
        com.google.android.libraries.navigation.internal.afr.j.a(hVarBG.e, Boolean.class);
        com.google.android.libraries.navigation.internal.afr.j.a(hVarBG.f, Boolean.class);
        com.google.android.libraries.navigation.internal.afr.j.a(hVarBG.g, com.google.android.libraries.navigation.internal.abh.be.class);
        com.google.android.libraries.navigation.environment.i iVar = new com.google.android.libraries.navigation.environment.i(hVarBG.a, hVarBG.b, hVarBG.c, hVarBG.d, hVarBG.e, hVarBG.f, hVarBG.g);
        com.google.android.libraries.navigation.internal.yx.ar.k(this.b == null);
        this.b = iVar;
        return iVar;
    }

    @Override // com.google.android.libraries.navigation.internal.abh.cn
    public final com.google.android.libraries.navigation.internal.abh.fe f(com.google.android.libraries.navigation.internal.abh.be beVar, com.google.android.libraries.navigation.internal.abh.ac acVar, com.google.android.libraries.navigation.internal.abh.fc fcVar, com.google.android.libraries.navigation.internal.abh.fg fgVar, com.google.android.libraries.navigation.internal.ly.o oVar, ht htVar, com.google.android.libraries.navigation.internal.yx.br brVar, com.google.android.libraries.navigation.internal.abh.bq bqVar) {
        return new at(beVar, acVar, fcVar, fgVar, oVar, htVar, brVar, bqVar, this.a);
    }

    @Override // com.google.android.libraries.navigation.internal.abm.bk
    public final com.google.android.libraries.navigation.internal.abh.fg g(com.google.android.libraries.navigation.internal.ol.z zVar, com.google.android.libraries.navigation.internal.abh.be beVar, com.google.android.libraries.navigation.internal.abm.ap apVar, com.google.android.libraries.navigation.internal.on.h hVar, com.google.android.libraries.navigation.internal.abh.ac acVar, com.google.android.libraries.navigation.internal.ob.f fVar, com.google.android.libraries.navigation.internal.pi.s sVar) {
        as asVar = new as(this.a.bb(), sVar, this.a.B(), this.a.I(), this.a.am(), this.a.al(), fVar, new com.google.android.libraries.navigation.internal.pb.i(new com.google.android.libraries.navigation.internal.pb.m(beVar.a.getResources().getDisplayMetrics(), ((com.google.android.libraries.navigation.internal.om.b) this.a.J().a()).a)), acVar, com.google.android.libraries.navigation.internal.ih.a.b(new com.google.android.libraries.navigation.internal.yx.br() { // from class: com.google.android.libraries.navigation.internal.xe.al
            @Override // com.google.android.libraries.navigation.internal.yx.br
            public final Object a() {
                return this.a.a.ar().p();
            }
        }));
        NavigationView navigationView = (NavigationView) ((com.google.android.libraries.navigation.as) this.f).a.get();
        if (navigationView != null) {
            navigationView.g = asVar;
        }
        return new av(asVar);
    }
}
