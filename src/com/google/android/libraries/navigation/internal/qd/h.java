package com.google.android.libraries.navigation.internal.qd;

import com.google.android.libraries.geo.mapcore.internal.model.ct;
import com.google.android.libraries.navigation.internal.adi.an;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class h implements com.google.android.libraries.navigation.internal.pg.h {
    public final com.google.android.libraries.navigation.internal.pg.h a;
    public final ct b;

    public h(com.google.android.libraries.navigation.internal.pg.h hVar, ct ctVar) {
        this.a = hVar;
        this.b = ctVar;
    }

    @Override // com.google.android.libraries.navigation.internal.pg.h
    public final com.google.android.libraries.navigation.internal.pg.f a(an anVar, int i, boolean z, com.google.android.libraries.navigation.internal.yx.an anVar2) {
        return new com.google.android.libraries.navigation.internal.ps.o(this.a.a(anVar, i, z, anVar2), this.b);
    }
}
