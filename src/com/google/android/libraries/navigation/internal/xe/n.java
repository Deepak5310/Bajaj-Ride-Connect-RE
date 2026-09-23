package com.google.android.libraries.navigation.internal.xe;

import com.google.android.libraries.navigation.internal.adr.hs;
import com.google.android.libraries.navigation.internal.adr.hu;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
class n extends o {
    private final hu d;

    public n(com.google.android.libraries.navigation.internal.aap.l lVar, hs hsVar, hu huVar, int i) {
        super(lVar, hsVar, i);
        this.d = huVar;
    }

    @Override // com.google.android.libraries.navigation.internal.xe.o
    public final boolean a(com.google.android.libraries.navigation.internal.bp.bq bqVar) {
        return this.d == bqVar.f && super.a(bqVar);
    }
}
