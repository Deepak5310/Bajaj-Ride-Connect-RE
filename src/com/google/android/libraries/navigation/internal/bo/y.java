package com.google.android.libraries.navigation.internal.bo;

import com.google.android.libraries.navigation.internal.adr.el;
import com.google.android.libraries.navigation.internal.ol.ar;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class y extends ar {
    final /* synthetic */ el a;
    final /* synthetic */ z b;

    public y(z zVar, el elVar) {
        this.a = elVar;
        this.b = zVar;
    }

    @Override // com.google.android.libraries.navigation.internal.ol.as
    public final /* bridge */ /* synthetic */ void C(Object obj) {
        z zVar = this.b;
        final com.google.android.libraries.navigation.internal.bm.ai aiVar = zVar.s;
        final el elVar = this.a;
        zVar.p.execute(new Runnable() { // from class: com.google.android.libraries.navigation.internal.bo.x
            @Override // java.lang.Runnable
            public final void run() {
                aiVar.a(elVar, com.google.android.libraries.navigation.internal.yx.a.a);
            }
        });
    }
}
