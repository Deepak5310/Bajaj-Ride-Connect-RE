package com.google.android.libraries.navigation.internal.sv;

import java.util.concurrent.Executor;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class e extends com.google.android.libraries.navigation.internal.ia.k {
    public e(Class cls, c cVar, com.google.android.libraries.navigation.internal.hx.ap apVar, Executor executor) {
        super(cls, cVar, apVar, executor);
    }

    @Override // com.google.android.libraries.navigation.internal.ia.k
    protected final void a(com.google.android.libraries.navigation.internal.ic.a aVar) {
        c cVar = (c) this.c;
        com.google.android.libraries.navigation.internal.db.s sVar = (com.google.android.libraries.navigation.internal.db.s) aVar;
        cVar.a = sVar.d();
        if (sVar.d() != null) {
            while (!cVar.b.isEmpty()) {
                ((com.google.android.libraries.navigation.internal.aac.bk) cVar.b.remove()).run();
            }
        }
    }
}
