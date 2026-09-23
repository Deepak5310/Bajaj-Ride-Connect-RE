package com.google.android.libraries.navigation.internal.bo;

import com.google.android.libraries.navigation.internal.adr.el;
import com.google.android.libraries.navigation.internal.ol.ar;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class w extends ar {
    final /* synthetic */ el a;
    final /* synthetic */ com.google.android.libraries.navigation.internal.ol.n b;
    final /* synthetic */ z c;

    public w(z zVar, el elVar, com.google.android.libraries.navigation.internal.ol.n nVar) {
        this.a = elVar;
        this.b = nVar;
        this.c = zVar;
    }

    @Override // com.google.android.libraries.navigation.internal.ol.as
    public final /* bridge */ /* synthetic */ void C(Object obj) {
        z zVar = this.c;
        final com.google.android.libraries.navigation.internal.bm.ai aiVar = zVar.s;
        final el elVar = this.a;
        final com.google.android.libraries.navigation.internal.ol.n nVar = this.b;
        zVar.p.execute(new Runnable() { // from class: com.google.android.libraries.navigation.internal.bo.v
            @Override // java.lang.Runnable
            public final void run() {
                aiVar.a(elVar, nVar.g());
            }
        });
    }
}
