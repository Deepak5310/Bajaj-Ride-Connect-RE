package com.google.android.libraries.navigation.internal.sk;

import android.content.res.Resources;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class dq implements z {
    private final Resources a;
    private final ce b;
    private final com.google.android.libraries.navigation.internal.iv.f c;

    public dq(Resources resources, ce ceVar, com.google.android.libraries.navigation.internal.iv.f fVar) {
        this.a = resources;
        this.b = ceVar;
        this.c = fVar;
    }

    @Override // com.google.android.libraries.navigation.internal.sk.z
    public final c a(com.google.android.libraries.navigation.internal.vn.d dVar) {
        int i = dVar.e;
        com.google.android.libraries.navigation.internal.sl.s sVarA = com.google.android.libraries.navigation.internal.sl.s.a(this.c);
        if (i != -1) {
            return this.b.a(this.a, i, sVarA);
        }
        return null;
    }

    @Override // com.google.android.libraries.navigation.internal.sk.z
    public final void b() {
        throw null;
    }
}
