package com.google.android.libraries.navigation.internal.ace;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class fa implements dr {
    private final dq a;
    private final com.google.android.libraries.navigation.internal.hp.d b;
    private final com.google.android.libraries.navigation.internal.hp.e c;

    public fa(dq dqVar, com.google.android.libraries.navigation.internal.hp.d dVar, com.google.android.libraries.navigation.internal.hp.e eVar) {
        this.a = dqVar;
        this.b = dVar;
        this.c = eVar;
    }

    @Override // com.google.android.libraries.navigation.internal.ace.dr
    public final bm a() {
        this.b.a(19).c(this.c);
        bm bmVarB = bm.b(this.a.b);
        return bmVarB == null ? bm.UNKNOWN_ENABLED_STATE : bmVarB;
    }

    @Override // com.google.android.libraries.navigation.internal.ael.cz
    public final /* bridge */ /* synthetic */ com.google.android.libraries.navigation.internal.ael.cy al() {
        throw null;
    }

    @Override // com.google.android.libraries.navigation.internal.ael.cz
    public final boolean am() {
        return this.a.am();
    }
}
