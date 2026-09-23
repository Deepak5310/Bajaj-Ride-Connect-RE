package com.google.android.libraries.navigation.internal.bm;

import java.util.Objects;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class l implements com.google.android.libraries.navigation.internal.nt.t {
    final /* synthetic */ o a;

    public l(o oVar) {
        this.a = oVar;
    }

    @Override // com.google.android.libraries.navigation.internal.nt.t
    public final void a(com.google.android.libraries.navigation.internal.nt.m mVar) {
        if (mVar != null) {
            mVar.c();
        }
        final o oVar = this.a;
        Objects.requireNonNull(oVar);
        oVar.k.execute(new Runnable() { // from class: com.google.android.libraries.navigation.internal.bm.k
            @Override // java.lang.Runnable
            public final void run() {
                oVar.j();
            }
        });
        Boolean bool = (Boolean) mVar.c();
        com.google.android.libraries.navigation.internal.yx.ar.q(bool);
        o oVar2 = this.a;
        boolean zBooleanValue = bool.booleanValue();
        synchronized (oVar2.f346n) {
            ar arVar = this.a.o;
            if (arVar != null) {
                arVar.b(zBooleanValue);
            }
        }
    }
}
