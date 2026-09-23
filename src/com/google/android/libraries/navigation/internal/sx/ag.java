package com.google.android.libraries.navigation.internal.sx;

import com.google.android.libraries.navigation.internal.afl.lz;
import com.google.android.libraries.navigation.internal.afl.mf;
import java.util.Objects;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class ag implements com.google.android.libraries.navigation.internal.bi.h {
    final /* synthetic */ boolean a;
    final /* synthetic */ long b;
    final /* synthetic */ ai c;

    public ag(ai aiVar, boolean z, long j) {
        this.a = z;
        this.b = j;
        this.c = aiVar;
    }

    @Override // com.google.android.libraries.navigation.internal.gg.e
    public final void a(com.google.android.libraries.navigation.internal.gg.i iVar, com.google.android.libraries.navigation.internal.gg.o oVar) {
        u uVarB = e.b(q.f, oVar);
        ai aiVar = this.c;
        aiVar.g.a(uVarB);
        com.google.android.libraries.navigation.internal.fw.g gVar = oVar.p;
        if (gVar == com.google.android.libraries.navigation.internal.fw.g.HTTP_BAD_REQUEST) {
            aiVar.d = new an(com.google.android.libraries.navigation.internal.fw.g.HTTP_BAD_REQUEST);
        } else {
            aiVar.c = new am((com.google.android.libraries.navigation.internal.bi.j) Objects.requireNonNull(aiVar.f), aiVar.a, gVar);
        }
        aiVar.e.run();
    }

    @Override // com.google.android.libraries.navigation.internal.gg.e
    public final /* bridge */ /* synthetic */ void b(com.google.android.libraries.navigation.internal.gg.i iVar, Object obj) {
        com.google.android.libraries.navigation.internal.bp.af afVar = (com.google.android.libraries.navigation.internal.bp.af) obj;
        n nVar = (n) u.a.q();
        int i = q.d;
        if (!nVar.b.H()) {
            nVar.v();
        }
        u uVar = (u) nVar.b;
        uVar.c = q.a(i);
        uVar.b |= 1;
        mf mfVar = afVar.a;
        if (!nVar.b.H()) {
            nVar.v();
        }
        ai aiVar = this.c;
        long j = this.b;
        boolean z = this.a;
        u uVar2 = (u) nVar.b;
        mfVar.getClass();
        uVar2.e = mfVar;
        uVar2.b |= 4;
        aiVar.g.a((u) nVar.t());
        lz lzVar = (lz) iVar.a;
        aiVar.b = as.c(lzVar, j, afVar, aiVar.a, z, com.google.android.libraries.navigation.internal.bi.m.c(lzVar));
        aiVar.e.run();
    }
}
