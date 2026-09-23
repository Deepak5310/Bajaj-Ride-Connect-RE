package com.google.android.libraries.navigation.internal.xe;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class au extends com.google.android.libraries.navigation.internal.ia.k {
    private final int f;

    public au(int i, Class cls, at atVar, com.google.android.libraries.navigation.internal.hx.ap apVar) {
        super(cls, atVar, apVar, null);
        this.f = i;
    }

    @Override // com.google.android.libraries.navigation.internal.ia.k
    protected final void a(com.google.android.libraries.navigation.internal.ic.a aVar) {
        com.google.android.libraries.navigation.internal.db.r rVar;
        if (this.f != 0) {
            at atVar = (at) this.c;
            if (atVar.b) {
                return;
            }
            atVar.a.al().c();
            atVar.b = true;
            return;
        }
        at atVar2 = (at) this.c;
        com.google.android.libraries.navigation.internal.db.s sVar = (com.google.android.libraries.navigation.internal.db.s) aVar;
        if (sVar.d() == null || (rVar = sVar.d().k) == null) {
            return;
        }
        atVar2.f(com.google.android.libraries.navigation.internal.db.t.a(rVar));
    }
}
