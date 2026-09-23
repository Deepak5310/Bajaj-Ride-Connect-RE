package com.google.android.libraries.navigation.internal.gm;

import com.google.android.libraries.navigation.internal.aac.ca;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class w extends com.google.android.libraries.navigation.internal.ia.k {
    private final int f;

    public w(int i, Class cls, u uVar, com.google.android.libraries.navigation.internal.hx.ap apVar) {
        super(cls, uVar, apVar, null);
        this.f = i;
    }

    @Override // com.google.android.libraries.navigation.internal.ia.k
    protected final void a(com.google.android.libraries.navigation.internal.ic.a aVar) {
        com.google.android.libraries.navigation.internal.gh.b bVarC;
        ca caVar;
        int i = this.f;
        if (i != 0) {
            if (i != 1) {
                ((u) this.c).d = ((com.google.android.libraries.navigation.internal.db.ah) aVar).d();
                return;
            } else {
                ((u) this.c).c = (com.google.android.libraries.navigation.internal.db.al) ((com.google.android.libraries.navigation.internal.db.am) aVar).d();
                return;
            }
        }
        u uVar = (u) this.c;
        com.google.android.libraries.navigation.internal.db.o oVar = (com.google.android.libraries.navigation.internal.db.o) aVar;
        synchronized (uVar) {
            uVar.b = (com.google.android.libraries.navigation.internal.db.n) oVar.d();
            bVarC = uVar.c();
            caVar = null;
            if (bVarC != null) {
                ca caVar2 = uVar.a;
                uVar.a = null;
                caVar = caVar2;
            }
        }
        if (caVar != null) {
            caVar.d(bVarC);
        }
    }
}
