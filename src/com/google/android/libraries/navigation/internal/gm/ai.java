package com.google.android.libraries.navigation.internal.gm;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class ai extends com.google.android.libraries.navigation.internal.ia.k {
    private final int f;

    public ai(int i, Class cls, ag agVar, com.google.android.libraries.navigation.internal.hx.ap apVar) {
        super(cls, agVar, apVar, null);
        this.f = i;
    }

    @Override // com.google.android.libraries.navigation.internal.ia.k
    protected final void a(com.google.android.libraries.navigation.internal.ic.a aVar) {
        com.google.android.libraries.navigation.internal.db.ab abVarA;
        if (this.f != 0) {
            ag agVar = (ag) this.c;
            com.google.android.libraries.navigation.internal.db.ab abVar = (com.google.android.libraries.navigation.internal.db.ab) ((com.google.android.libraries.navigation.internal.db.ac) aVar).d();
            if (abVar != null) {
                agVar.c(abVar);
                return;
            }
            return;
        }
        ag agVar2 = (ag) this.c;
        com.google.android.libraries.navigation.internal.db.n nVar = (com.google.android.libraries.navigation.internal.db.n) ((com.google.android.libraries.navigation.internal.db.o) aVar).d();
        if (nVar == null || (abVarA = nVar.a()) == null) {
            return;
        }
        agVar2.c(abVarA);
    }
}
