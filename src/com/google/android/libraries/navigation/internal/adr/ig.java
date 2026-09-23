package com.google.android.libraries.navigation.internal.adr;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class ig extends com.google.android.libraries.navigation.internal.ael.bb implements com.google.android.libraries.navigation.internal.ael.cz {
    public ig() {
        super(ii.a);
    }

    public final gv c(int i) {
        return (gv) ((ii) this.b).c.get(i);
    }

    public final void d(gs gsVar) {
        if (!this.b.H()) {
            v();
        }
        ii iiVar = (ii) this.b;
        gv gvVar = (gv) gsVar.t();
        ii iiVar2 = ii.a;
        gvVar.getClass();
        iiVar.c();
        iiVar.c.add(gvVar);
    }

    public final void e() {
        if (!this.b.H()) {
            v();
        }
        ii iiVar = (ii) this.b;
        ii iiVar2 = ii.a;
        iiVar.c();
        iiVar.c.remove(0);
    }

    public final void f(int i, gs gsVar) {
        if (!this.b.H()) {
            v();
        }
        ii iiVar = (ii) this.b;
        gv gvVar = (gv) gsVar.t();
        ii iiVar2 = ii.a;
        gvVar.getClass();
        iiVar.c();
        iiVar.c.set(i, gvVar);
    }
}
