package com.google.android.libraries.navigation.internal.sx;

import android.content.Context;
import com.google.android.libraries.navigation.internal.afl.lz;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class k implements com.google.android.libraries.navigation.internal.bi.h {
    final /* synthetic */ long a;
    final /* synthetic */ Context b;
    final /* synthetic */ boolean c;
    final /* synthetic */ com.google.android.libraries.navigation.internal.gg.e d;

    public k(long j, Context context, boolean z, com.google.android.libraries.navigation.internal.gg.e eVar) {
        this.a = j;
        this.b = context;
        this.c = z;
        this.d = eVar;
    }

    @Override // com.google.android.libraries.navigation.internal.gg.e
    public final void a(com.google.android.libraries.navigation.internal.gg.i iVar, com.google.android.libraries.navigation.internal.gg.o oVar) {
        this.d.a(iVar, oVar);
    }

    @Override // com.google.android.libraries.navigation.internal.gg.e
    public final /* bridge */ /* synthetic */ void b(com.google.android.libraries.navigation.internal.gg.i iVar, Object obj) {
        lz lzVar = (lz) iVar.a;
        int iC = com.google.android.libraries.navigation.internal.bi.m.c(lzVar);
        Context context = this.b;
        this.d.b(iVar, as.c(lzVar, this.a, (com.google.android.libraries.navigation.internal.bp.af) obj, context, this.c, iC));
    }
}
