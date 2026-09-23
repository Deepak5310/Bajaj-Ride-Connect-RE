package com.google.android.libraries.navigation.internal.eo;

import com.google.android.apps.gmm.offline.settings.dataview.OfflineDataViewProvider;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class d implements com.google.android.libraries.navigation.internal.afr.f {
    public static OfflineDataViewProvider b() {
        int i = OfflineDataViewProvider.a;
        com.google.android.libraries.navigation.internal.ep.a aVar = (com.google.android.libraries.navigation.internal.ep.a) com.google.android.libraries.navigation.internal.ep.b.a.q();
        com.google.android.libraries.navigation.internal.acp.a aVar2 = (com.google.android.libraries.navigation.internal.acp.a) com.google.android.libraries.navigation.internal.acp.b.a.q();
        com.google.android.libraries.navigation.internal.acn.c cVar = (com.google.android.libraries.navigation.internal.acn.c) com.google.android.libraries.navigation.internal.acn.d.a.q();
        com.google.android.libraries.navigation.internal.acn.a aVar3 = (com.google.android.libraries.navigation.internal.acn.a) com.google.android.libraries.navigation.internal.acn.b.a.q();
        if (!aVar3.b.H()) {
            aVar3.v();
        }
        com.google.android.libraries.navigation.internal.acn.b bVar = (com.google.android.libraries.navigation.internal.acn.b) aVar3.b;
        bVar.b |= 1;
        bVar.c = "google/base";
        if (!cVar.b.H()) {
            cVar.v();
        }
        com.google.android.libraries.navigation.internal.acn.d dVar = (com.google.android.libraries.navigation.internal.acn.d) cVar.b;
        com.google.android.libraries.navigation.internal.acn.b bVar2 = (com.google.android.libraries.navigation.internal.acn.b) aVar3.t();
        bVar2.getClass();
        dVar.c = bVar2;
        dVar.b |= 1;
        if (!aVar2.b.H()) {
            aVar2.v();
        }
        com.google.android.libraries.navigation.internal.acp.b bVar3 = (com.google.android.libraries.navigation.internal.acp.b) aVar2.b;
        com.google.android.libraries.navigation.internal.acn.d dVar2 = (com.google.android.libraries.navigation.internal.acn.d) cVar.t();
        dVar2.getClass();
        bVar3.c = dVar2;
        bVar3.b |= 1;
        if (!aVar.b.H()) {
            aVar.v();
        }
        com.google.android.libraries.navigation.internal.ep.b bVar4 = (com.google.android.libraries.navigation.internal.ep.b) aVar.b;
        com.google.android.libraries.navigation.internal.acp.b bVar5 = (com.google.android.libraries.navigation.internal.acp.b) aVar2.t();
        bVar5.getClass();
        bVar4.c = bVar5;
        bVar4.b |= 2;
        com.google.android.libraries.navigation.internal.ep.b bVar6 = (com.google.android.libraries.navigation.internal.ep.b) aVar.t();
        return new OfflineDataViewProvider(new com.google.android.apps.gmm.offline.settings.dataview.a(bVar6), bVar6);
    }

    @Override // com.google.android.libraries.navigation.internal.agl.a, com.google.android.libraries.navigation.internal.agk.a
    public final /* synthetic */ Object a() {
        return b();
    }
}
