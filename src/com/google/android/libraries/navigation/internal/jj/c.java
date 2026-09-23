package com.google.android.libraries.navigation.internal.jj;

import com.google.android.libraries.navigation.internal.qz.k;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class c implements com.google.android.libraries.navigation.internal.qz.g {
    final /* synthetic */ f a;

    public c(f fVar) {
        this.a = fVar;
    }

    @Override // com.google.android.libraries.navigation.internal.qz.g
    public final void a(final k kVar) {
        if (this.a.q.a()) {
            f fVar = this.a;
            fVar.c.execute(new Runnable() { // from class: com.google.android.libraries.navigation.internal.jj.b
                @Override // java.lang.Runnable
                public final void run() {
                    c cVar = this.a;
                    cVar.a.h = com.google.android.libraries.navigation.internal.jk.a.b(kVar);
                    f fVar2 = cVar.a;
                    fVar2.e.a(fVar2);
                }
            });
        }
    }
}
