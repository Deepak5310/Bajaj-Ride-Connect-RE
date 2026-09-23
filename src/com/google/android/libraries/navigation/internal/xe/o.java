package com.google.android.libraries.navigation.internal.xe;

import com.google.android.libraries.navigation.internal.adr.hs;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
class o {
    com.google.android.libraries.navigation.internal.aap.l a;
    protected final hs b;
    protected final int c;

    public o(com.google.android.libraries.navigation.internal.aap.l lVar, hs hsVar, int i) {
        this.a = lVar;
        this.b = hsVar;
        this.c = i;
    }

    public boolean a(com.google.android.libraries.navigation.internal.bp.bq bqVar) {
        if (this.a != bqVar.d) {
            return false;
        }
        return this.b == hs.SIDE_UNSPECIFIED || this.b == bqVar.e;
    }
}
