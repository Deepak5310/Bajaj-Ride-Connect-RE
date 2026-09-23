package com.google.android.libraries.navigation.internal.adr;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class gi extends com.google.android.libraries.navigation.internal.ael.bb implements com.google.android.libraries.navigation.internal.ael.cz {
    public gi() {
        super(gj.a);
    }

    public final ib c(int i) {
        return (ib) ((gj) this.b).e.get(i);
    }

    public final void d(int i, hw hwVar) {
        if (!this.b.H()) {
            v();
        }
        gj gjVar = (gj) this.b;
        ib ibVar = (ib) hwVar.t();
        gj gjVar2 = gj.a;
        ibVar.getClass();
        gjVar.c();
        gjVar.e.set(i, ibVar);
    }

    public final void e(int i, ib ibVar) {
        if (!this.b.H()) {
            v();
        }
        gj gjVar = (gj) this.b;
        gj gjVar2 = gj.a;
        ibVar.getClass();
        gjVar.c();
        gjVar.e.set(i, ibVar);
    }
}
