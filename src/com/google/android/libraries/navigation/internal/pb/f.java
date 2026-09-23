package com.google.android.libraries.navigation.internal.pb;

import android.graphics.Rect;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class f extends c {
    final /* synthetic */ com.google.android.libraries.navigation.internal.oe.r c;
    final /* synthetic */ float d;
    final /* synthetic */ Rect e;

    public f(com.google.android.libraries.navigation.internal.oe.r rVar, float f, Rect rect) {
        this.c = rVar;
        this.d = f;
        this.e = rect;
    }

    @Override // com.google.android.libraries.navigation.internal.pb.c
    public final void a(b bVar) {
        com.google.android.libraries.navigation.internal.pd.d dVar = com.google.android.libraries.navigation.internal.pd.d.a;
        com.google.android.libraries.navigation.internal.pd.a aVar = new com.google.android.libraries.navigation.internal.pd.a();
        aVar.d(this.c);
        aVar.c = this.d;
        aVar.f = com.google.android.libraries.navigation.internal.pd.e.c(this.e.exactCenterX(), this.e.exactCenterY(), bVar.b(), bVar.a());
        bVar.d(aVar.a(), this.a, this.b);
    }
}
