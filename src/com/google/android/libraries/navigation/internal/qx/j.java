package com.google.android.libraries.navigation.internal.qx;

import com.bumptech.glide.Glide;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class j implements com.google.android.libraries.navigation.internal.fq.p {
    final /* synthetic */ q a;

    public j(q qVar) {
        this.a = qVar;
    }

    @Override // com.google.android.libraries.navigation.internal.fq.p
    public final String a() {
        return null;
    }

    @Override // com.google.android.libraries.navigation.internal.fq.p
    public final void h(float f) {
        q qVar = this.a;
        synchronized (qVar.h) {
            ((com.google.android.libraries.navigation.internal.fq.k) qVar.h.a()).k();
        }
        synchronized (qVar.g) {
            ((com.google.android.libraries.navigation.internal.fq.k) qVar.g.a()).k();
        }
        if (qVar.l != null) {
            com.google.android.libraries.navigation.internal.qv.b bVar = qVar.l;
        }
        final com.google.android.libraries.navigation.internal.ie.b bVarA = ((com.google.android.libraries.navigation.internal.ie.c) qVar.e).a();
        bVarA.b.execute(new Runnable() { // from class: com.google.android.libraries.navigation.internal.ie.a
            @Override // java.lang.Runnable
            public final void run() {
                Glide.get(bVarA.a).clearMemory();
            }
        });
    }
}
