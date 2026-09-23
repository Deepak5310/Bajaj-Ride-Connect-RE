package com.google.android.libraries.navigation.internal.pb;

import com.google.android.libraries.navigation.internal.oe.al;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class e extends c {
    final /* synthetic */ al c;
    final /* synthetic */ int d;
    final /* synthetic */ int e;
    final /* synthetic */ int f;
    final /* synthetic */ int g;

    public e(al alVar, int i, int i2, int i3, int i4) {
        this.c = alVar;
        this.d = i;
        this.e = i2;
        this.f = i3;
        this.g = i4;
    }

    @Override // com.google.android.libraries.navigation.internal.pb.c
    public final void a(b bVar) {
        com.google.android.libraries.navigation.internal.oe.x xVar = new com.google.android.libraries.navigation.internal.oe.x();
        al alVar = this.c;
        alVar.d(xVar);
        int iB = bVar.b() - (this.d + this.e);
        int iA = bVar.a() - (this.f + this.g);
        al alVar2 = this.c;
        float fMax = Math.max(-1.0f, 30.0f - ((float) (Math.log(((double) Math.max(alVar2.b / iB, alVar2.c / iA)) * ((double) (bVar.c().n() * 256.0f))) / Math.log(2.0d))));
        com.google.android.libraries.navigation.internal.pd.e eVarC = com.google.android.libraries.navigation.internal.pd.e.c(((bVar.b() - this.e) + this.d) / 2.0f, ((bVar.a() - this.g) + this.f) / 2.0f, bVar.b(), bVar.a());
        com.google.android.libraries.navigation.internal.pd.d dVar = com.google.android.libraries.navigation.internal.pd.d.a;
        com.google.android.libraries.navigation.internal.pd.a aVar = new com.google.android.libraries.navigation.internal.pd.a();
        aVar.e(xVar);
        aVar.f = eVarC;
        aVar.e = alVar.d;
        aVar.c = fMax;
        bVar.d(aVar.a(), this.a, this.b);
    }
}
