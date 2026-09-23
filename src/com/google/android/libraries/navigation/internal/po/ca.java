package com.google.android.libraries.navigation.internal.po;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class ca implements af {
    public static final com.google.android.libraries.navigation.internal.qz.k b = new com.google.android.libraries.navigation.internal.qz.k(new Object());
    public final Executor c;
    public final com.google.android.libraries.navigation.internal.qy.h d;
    public volatile com.google.android.libraries.navigation.internal.pz.d e = com.google.android.libraries.navigation.internal.pz.d.a;
    private final com.google.android.libraries.navigation.internal.qc.g f;

    public ca(Executor executor, com.google.android.libraries.navigation.internal.qy.h hVar, com.google.android.libraries.navigation.internal.qc.g gVar) {
        this.c = executor;
        this.d = hVar;
        this.f = gVar;
    }

    private static void c(com.google.android.libraries.navigation.internal.qc.g gVar, com.google.android.libraries.navigation.internal.adg.dt dtVar, com.google.android.libraries.navigation.internal.px.ek ekVar, List list) {
        for (int i = 0; i < dtVar.c.size(); i++) {
            com.google.android.libraries.navigation.internal.adg.dp dpVar = (com.google.android.libraries.navigation.internal.adg.dp) dtVar.c.get(i);
            com.google.android.libraries.geo.mapcore.internal.model.ai aiVarA = gVar.a(dpVar, ekVar, ekVar.Y());
            if (aiVarA.i() && !aiVarA.t.c()) {
                list.add(new bz(dpVar.c, aiVarA.t, aiVarA));
            }
        }
        com.google.android.libraries.geo.mapcore.internal.model.ai aiVarC = gVar.c(dtVar, ekVar, ekVar.Y());
        if (!aiVarC.i() || aiVarC.t.c()) {
            return;
        }
        list.add(new bz("", aiVarC.t, aiVarC));
    }

    @Override // com.google.android.libraries.navigation.internal.po.af
    public final com.google.android.libraries.navigation.internal.aac.bj a(com.google.android.libraries.navigation.internal.px.ek ekVar) {
        final ArrayList arrayList = new ArrayList(3);
        com.google.android.libraries.navigation.internal.px.b bVar = (com.google.android.libraries.navigation.internal.px.b) ekVar;
        com.google.android.libraries.navigation.internal.adg.dt dtVar = bVar.a.c;
        if (dtVar == null) {
            dtVar = com.google.android.libraries.navigation.internal.adg.dt.a;
        }
        com.google.android.libraries.navigation.internal.qc.g gVar = this.f;
        c(gVar, dtVar, ekVar, arrayList);
        com.google.android.libraries.navigation.internal.adg.dt dtVar2 = bVar.a.d;
        if (dtVar2 == null) {
            dtVar2 = com.google.android.libraries.navigation.internal.adg.dt.a;
        }
        c(gVar, dtVar2, ekVar, arrayList);
        if (arrayList.isEmpty()) {
            return null;
        }
        final com.google.android.libraries.navigation.internal.aac.ca caVar = new com.google.android.libraries.navigation.internal.aac.ca();
        this.c.execute(new Runnable() { // from class: com.google.android.libraries.navigation.internal.po.bx
            @Override // java.lang.Runnable
            public final void run() {
                ca caVar2 = this.a;
                com.google.android.libraries.navigation.internal.pz.d dVar = caVar2.e;
                Executor executor = caVar2.c;
                com.google.android.libraries.navigation.internal.aac.ca caVar3 = caVar;
                List<bz> list = arrayList;
                by byVar = new by(executor, caVar3, list.size());
                int i = 0;
                for (bz bzVar : list) {
                    if (com.google.android.libraries.navigation.internal.pz.a.a(bzVar.a, bzVar.b, bzVar.c, dVar, caVar2.d, "prefetch", byVar) != null) {
                        i++;
                    }
                }
                for (int i2 = 0; i2 < i; i2++) {
                    byVar.a(ca.b);
                }
            }
        });
        return caVar;
    }

    @Override // com.google.android.libraries.navigation.internal.po.af
    public final void b(com.google.android.libraries.navigation.internal.pz.d dVar) {
        this.e = dVar;
    }
}
