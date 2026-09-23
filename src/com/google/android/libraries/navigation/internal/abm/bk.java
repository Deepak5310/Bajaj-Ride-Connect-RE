package com.google.android.libraries.navigation.internal.abm;

import android.content.Context;
import com.google.android.libraries.navigation.internal.abh.ef;
import com.google.android.libraries.navigation.internal.abh.fg;
import com.google.android.libraries.navigation.internal.abh.fv;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public class bk {
    public static final bk c = new bk();

    protected bk() {
    }

    public com.google.android.libraries.navigation.internal.ow.k a(com.google.android.libraries.navigation.internal.abh.be beVar, com.google.android.libraries.navigation.internal.abh.m mVar, fv fvVar) {
        return aq.a(beVar, mVar, fvVar);
    }

    public com.google.android.libraries.navigation.internal.abh.bq b(Context context, com.google.android.libraries.navigation.internal.ni.a aVar, com.google.android.libraries.navigation.internal.ia.e eVar, com.google.android.libraries.navigation.internal.abh.ac acVar, com.google.android.libraries.navigation.internal.oa.k kVar, float f) {
        return new com.google.android.libraries.navigation.internal.abh.br(context, aVar, eVar, acVar, kVar, f);
    }

    public ef e(com.google.android.libraries.navigation.internal.ow.k kVar, com.google.android.libraries.navigation.internal.abn.as asVar, String str, Integer num, boolean z, boolean z2, com.google.android.libraries.navigation.internal.wd.g gVar, com.google.android.libraries.navigation.internal.abh.be beVar) {
        bm bmVarB = aq.b();
        if (bmVarB == null) {
            return new at(new com.google.android.libraries.navigation.internal.ow.j(kVar, asVar, (com.google.android.libraries.navigation.internal.vu.t) kVar.b().f(), str, num, z, z2, gVar));
        }
        l lVar = new l(((p) bmVarB).a);
        lVar.b = asVar;
        lVar.c = str;
        lVar.d = num;
        lVar.e = Boolean.valueOf(z);
        lVar.f = Boolean.valueOf(z2);
        com.google.android.libraries.navigation.internal.afr.j.a(lVar.b, com.google.android.libraries.navigation.internal.pn.j.class);
        com.google.android.libraries.navigation.internal.afr.j.a(lVar.c, String.class);
        com.google.android.libraries.navigation.internal.afr.j.a(lVar.e, Boolean.class);
        com.google.android.libraries.navigation.internal.afr.j.a(lVar.f, Boolean.class);
        return new m(lVar.a, lVar.b, lVar.c, lVar.d, lVar.e, lVar.f);
    }

    public fg g(com.google.android.libraries.navigation.internal.ol.z zVar, com.google.android.libraries.navigation.internal.abh.be beVar, ap apVar, com.google.android.libraries.navigation.internal.on.h hVar, com.google.android.libraries.navigation.internal.abh.ac acVar, com.google.android.libraries.navigation.internal.ob.f fVar, com.google.android.libraries.navigation.internal.pi.s sVar) {
        return new dh(zVar, beVar, apVar, hVar);
    }
}
