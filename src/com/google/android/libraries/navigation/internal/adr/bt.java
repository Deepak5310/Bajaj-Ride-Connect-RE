package com.google.android.libraries.navigation.internal.adr;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class bt extends com.google.android.libraries.navigation.internal.ael.bb implements com.google.android.libraries.navigation.internal.ael.cz {
    public bt() {
        super(by.a);
    }

    public final void c(bx bxVar) {
        if (!this.b.H()) {
            v();
        }
        by byVar = (by) this.b;
        by byVar2 = by.a;
        bxVar.getClass();
        byVar.c();
        byVar.f.add(bxVar);
    }

    public final void d(int i) {
        if (!this.b.H()) {
            v();
        }
        by byVar = (by) this.b;
        by byVar2 = by.a;
        byVar.c();
        byVar.f.remove(i);
    }
}
