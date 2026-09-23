package com.google.android.libraries.navigation.internal.vd;

import com.google.android.libraries.navigation.internal.acd.ud;
import com.google.android.libraries.navigation.internal.adu.y;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class a implements com.google.android.libraries.navigation.internal.gg.e {
    final /* synthetic */ boolean a;
    final /* synthetic */ y b;
    final /* synthetic */ c c;
    final /* synthetic */ int d;

    public a(c cVar, boolean z, int i, y yVar) {
        this.a = z;
        this.d = i;
        this.b = yVar;
        this.c = cVar;
    }

    @Override // com.google.android.libraries.navigation.internal.gg.e
    public final void a(com.google.android.libraries.navigation.internal.gg.i iVar, com.google.android.libraries.navigation.internal.gg.o oVar) {
        int i = c.e;
        com.google.android.libraries.navigation.internal.fw.g gVar = oVar.p;
    }

    @Override // com.google.android.libraries.navigation.internal.gg.e
    public final /* bridge */ /* synthetic */ void b(com.google.android.libraries.navigation.internal.gg.i iVar, Object obj) {
        ud udVar = (ud) obj;
        if ((udVar.b & 4) != 0) {
            c cVar = this.c;
            cVar.d.add(udVar.c);
        }
        if (this.a) {
            this.c.h(this.d, this.b);
        }
    }
}
