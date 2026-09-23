package com.google.android.libraries.navigation.internal.ti;

import com.google.android.libraries.navigation.internal.hx.ap;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class j extends com.google.android.libraries.navigation.internal.ia.k {
    public j(Class cls, i iVar, ap apVar, Executor executor) {
        super(cls, iVar, apVar, executor);
    }

    @Override // com.google.android.libraries.navigation.internal.ia.k
    protected final void a(com.google.android.libraries.navigation.internal.ic.a aVar) {
        i iVar = (i) this.c;
        com.google.android.libraries.navigation.internal.dh.g gVar = (com.google.android.libraries.navigation.internal.dh.g) aVar;
        iVar.h = gVar.a;
        iVar.g = (int) Math.round(com.google.android.libraries.navigation.internal.dh.g.f(gVar.b) * 10.0d);
    }
}
