package com.google.android.libraries.navigation.internal.gk;

import com.google.android.libraries.navigation.internal.aac.as;
import com.google.android.libraries.navigation.internal.ael.cy;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class m implements as {
    final /* synthetic */ String a;
    final /* synthetic */ cy b;
    final /* synthetic */ com.google.android.libraries.navigation.internal.gm.an c;
    final /* synthetic */ com.google.android.libraries.navigation.internal.gg.e d;
    final /* synthetic */ com.google.android.libraries.navigation.internal.gg.n e;
    final /* synthetic */ p f;

    public m(p pVar, String str, cy cyVar, com.google.android.libraries.navigation.internal.gm.an anVar, com.google.android.libraries.navigation.internal.gg.e eVar, com.google.android.libraries.navigation.internal.gg.n nVar) {
        this.a = str;
        this.b = cyVar;
        this.c = anVar;
        this.d = eVar;
        this.e = nVar;
        this.f = pVar;
    }

    @Override // com.google.android.libraries.navigation.internal.aac.as
    public final void a(Throwable th) {
        this.f.e.b();
        this.f.e(th, this.b, this.c, 1, this.d, this.e);
    }

    @Override // com.google.android.libraries.navigation.internal.aac.as
    public final /* bridge */ /* synthetic */ void b(Object obj) {
    }
}
