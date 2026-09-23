package com.google.android.libraries.navigation.internal.vx;

import com.google.android.libraries.navigation.internal.aac.bk;
import com.google.android.libraries.navigation.internal.hx.ap;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class g extends com.google.android.libraries.navigation.internal.ia.k {
    public g(Class cls, e eVar, ap apVar) {
        super(cls, eVar, apVar, null);
    }

    @Override // com.google.android.libraries.navigation.internal.ia.k
    protected final void a(com.google.android.libraries.navigation.internal.ic.a aVar) {
        final e eVar = (e) this.c;
        final com.google.android.libraries.navigation.internal.cw.f fVar = (com.google.android.libraries.navigation.internal.cw.f) aVar;
        eVar.c.execute(new Runnable() { // from class: com.google.android.libraries.navigation.internal.vx.c
            @Override // java.lang.Runnable
            public final void run() {
                e eVar2 = eVar;
                eVar2.a = fVar.a;
                while (!eVar2.b.isEmpty()) {
                    ((bk) eVar2.b.remove()).run();
                }
            }
        });
    }
}
