package com.google.android.libraries.navigation.internal.pg;

import com.google.android.libraries.geo.mapcore.internal.model.ct;
import com.google.android.libraries.navigation.internal.adi.an;
import com.google.android.libraries.navigation.internal.yx.br;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public class g implements h {
    private final br a;

    public g(br brVar) {
        this.a = brVar;
    }

    @Override // com.google.android.libraries.navigation.internal.pg.h
    public f a(an anVar, int i, boolean z, com.google.android.libraries.navigation.internal.yx.an anVar2) {
        return z ? new b(anVar, i, (ct) this.a.a()) : new e(anVar, (ct) this.a.a(), anVar2);
    }
}
