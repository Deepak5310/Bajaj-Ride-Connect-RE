package com.google.android.libraries.navigation.internal.vw;

import com.google.android.libraries.navigation.internal.bp.ai;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class p implements com.google.android.libraries.navigation.internal.vp.f {
    final /* synthetic */ com.google.android.libraries.navigation.internal.vp.h a;
    final /* synthetic */ com.google.android.libraries.navigation.internal.vq.b b;
    final /* synthetic */ q c;

    public p(q qVar, com.google.android.libraries.navigation.internal.vp.h hVar, com.google.android.libraries.navigation.internal.vq.b bVar) {
        this.a = hVar;
        this.b = bVar;
        this.c = qVar;
    }

    @Override // com.google.android.libraries.navigation.internal.vp.f
    public final void a(com.google.android.libraries.navigation.internal.vp.c cVar) {
        this.b.d(cVar);
    }

    @Override // com.google.android.libraries.navigation.internal.vp.f
    public final void b(ai aiVar) {
        synchronized (this.c) {
            q qVar = this.c;
            qVar.i(com.google.android.libraries.navigation.internal.vv.a.b(aiVar, qVar.a), this.a);
        }
        this.b.d(com.google.android.libraries.navigation.internal.vp.c.OK);
    }
}
