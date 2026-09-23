package com.google.android.libraries.navigation.internal.pg;

import com.google.android.libraries.geo.mapcore.internal.model.ct;
import com.google.android.libraries.navigation.internal.adi.an;
import com.google.android.libraries.navigation.internal.yx.br;
import com.google.android.libraries.navigation.internal.yx.bw;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class d extends g {
    private f a;

    public d(final ct ctVar) {
        super(bw.a(new br() { // from class: com.google.android.libraries.navigation.internal.pg.c
            @Override // com.google.android.libraries.navigation.internal.yx.br
            public final Object a() {
                return ctVar;
            }
        }));
    }

    @Override // com.google.android.libraries.navigation.internal.pg.g, com.google.android.libraries.navigation.internal.pg.h
    public final synchronized f a(an anVar, int i, boolean z, com.google.android.libraries.navigation.internal.yx.an anVar2) {
        if (this.a == null) {
            this.a = super.a(anVar, i, z, anVar2);
        }
        return this.a;
    }
}
