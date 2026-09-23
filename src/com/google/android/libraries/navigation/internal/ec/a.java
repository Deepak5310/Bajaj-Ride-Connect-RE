package com.google.android.libraries.navigation.internal.ec;

import com.google.android.libraries.navigation.internal.nt.m;
import com.google.android.libraries.navigation.internal.nt.t;
import com.google.android.libraries.navigation.internal.yx.an;
import com.google.android.libraries.navigation.internal.yx.ar;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class a implements t {
    final /* synthetic */ c a;

    public a(c cVar) {
        this.a = cVar;
    }

    @Override // com.google.android.libraries.navigation.internal.nt.t
    public final void a(m mVar) {
        if (mVar.i()) {
            an anVar = (an) mVar.c();
            ar.q(anVar);
            if (anVar.g()) {
                c cVar = this.a;
                an anVar2 = (an) mVar.c();
                ar.q(anVar2);
                cVar.i = (com.google.android.libraries.navigation.internal.ed.a) anVar2.c();
                com.google.android.libraries.navigation.internal.ed.a aVar = this.a.i;
                this.a.b();
            }
        }
    }
}
