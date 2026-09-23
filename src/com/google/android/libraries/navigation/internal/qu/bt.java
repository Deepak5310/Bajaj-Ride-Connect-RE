package com.google.android.libraries.navigation.internal.qu;

import android.content.Context;
import java.io.File;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class bt implements com.google.android.libraries.navigation.internal.afr.f {
    private final com.google.android.libraries.navigation.internal.agl.a a;
    private final com.google.android.libraries.navigation.internal.agl.a b;
    private final com.google.android.libraries.navigation.internal.agl.a c;
    private final com.google.android.libraries.navigation.internal.agl.a d;
    private final com.google.android.libraries.navigation.internal.agl.a e;
    private final com.google.android.libraries.navigation.internal.agl.a f;
    private final com.google.android.libraries.navigation.internal.agl.a g;
    private final com.google.android.libraries.navigation.internal.agl.a h;
    private final com.google.android.libraries.navigation.internal.agl.a i;
    private final com.google.android.libraries.navigation.internal.agl.a j;

    public bt(com.google.android.libraries.navigation.internal.agl.a aVar, com.google.android.libraries.navigation.internal.agl.a aVar2, com.google.android.libraries.navigation.internal.agl.a aVar3, com.google.android.libraries.navigation.internal.agl.a aVar4, com.google.android.libraries.navigation.internal.agl.a aVar5, com.google.android.libraries.navigation.internal.agl.a aVar6, com.google.android.libraries.navigation.internal.agl.a aVar7, com.google.android.libraries.navigation.internal.agl.a aVar8, com.google.android.libraries.navigation.internal.agl.a aVar9, com.google.android.libraries.navigation.internal.agl.a aVar10) {
        this.a = aVar;
        this.b = aVar2;
        this.c = aVar3;
        this.d = aVar4;
        this.e = aVar5;
        this.f = aVar6;
        this.g = aVar7;
        this.h = aVar8;
        this.i = aVar9;
        this.j = aVar10;
    }

    @Override // com.google.android.libraries.navigation.internal.agl.a, com.google.android.libraries.navigation.internal.agk.a
    public final /* bridge */ /* synthetic */ Object a() {
        Context context = (Context) this.a.a();
        com.google.android.libraries.navigation.internal.mj.a aVar = (com.google.android.libraries.navigation.internal.mj.a) this.b.a();
        com.google.android.libraries.navigation.internal.afo.a aVarC = com.google.android.libraries.navigation.internal.afr.e.c(this.c);
        bs bsVar = (bs) this.d.a();
        com.google.android.libraries.navigation.internal.no.a aVar2 = (com.google.android.libraries.navigation.internal.no.a) this.e.a();
        br brVar = (br) this.f.a();
        com.google.android.libraries.navigation.internal.ra.a aVar3 = (com.google.android.libraries.navigation.internal.ra.a) this.g.a();
        final com.google.android.libraries.geo.mapcore.internal.store.diskcache.k kVar = new com.google.android.libraries.geo.mapcore.internal.store.diskcache.k(context, (com.google.android.libraries.navigation.internal.id.d) this.j.a(), bsVar, (com.google.android.libraries.navigation.internal.oe.at) this.h.a(), aVar, aVar3, aVarC, ((com.google.android.libraries.navigation.internal.nj.b) this.i).a(), new com.google.android.libraries.geo.mapcore.internal.store.diskcache.c(), aVar2, brVar);
        kVar.d.a(new Runnable() { // from class: com.google.android.libraries.geo.mapcore.internal.store.diskcache.i
            @Override // java.lang.Runnable
            public final void run() {
                k kVar2 = kVar;
                k.j(kVar2.f(true), false);
                k.j(kVar2.f(false), false);
                k.j(new File(kVar2.b.getFilesDir(), "gst"), true);
            }
        });
        return kVar;
    }
}
