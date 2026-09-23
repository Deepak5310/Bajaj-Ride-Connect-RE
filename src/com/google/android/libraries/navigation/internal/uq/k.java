package com.google.android.libraries.navigation.internal.uq;

import android.content.res.Configuration;
import android.os.Bundle;
import com.google.android.libraries.navigation.internal.sv.by;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class k implements com.google.android.libraries.navigation.internal.uh.o {
    private final g a;
    private final by b;

    public k(g gVar, by byVar) {
        this.a = gVar;
        this.b = byVar;
    }

    @Override // com.google.android.libraries.navigation.internal.uh.c
    public final /* synthetic */ void aC() {
    }

    @Override // com.google.android.libraries.navigation.internal.uh.c
    public final /* synthetic */ void ay(Configuration configuration) {
    }

    @Override // com.google.android.libraries.navigation.internal.uh.o
    public final void f(com.google.android.libraries.navigation.internal.ui.a aVar, com.google.android.libraries.navigation.internal.ui.a aVar2) {
    }

    @Override // com.google.android.libraries.navigation.internal.uh.c
    public final /* synthetic */ void h(Bundle bundle) {
    }

    @Override // com.google.android.libraries.navigation.internal.uh.c
    public final /* synthetic */ void j(Bundle bundle) {
    }

    @Override // com.google.android.libraries.navigation.internal.uh.c
    public final void k() {
        this.a.k();
        by byVar = this.b;
        if (byVar.j) {
            return;
        }
        byVar.j = true;
        byVar.h = 0;
        byVar.i = 0L;
        byVar.f581n.clear();
        byVar.m.clear();
        byVar.g.c(byVar.o, byVar.a);
    }

    @Override // com.google.android.libraries.navigation.internal.uh.c
    public final void l() {
        this.a.l();
        by byVar = this.b;
        byVar.j = false;
        byVar.g.d(byVar.o);
    }
}
