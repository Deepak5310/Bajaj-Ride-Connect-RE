package com.google.android.libraries.navigation.internal.adi;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class ag extends com.google.android.libraries.navigation.internal.ael.bd implements com.google.android.libraries.navigation.internal.ael.bf {
    public ag() {
        super(aj.a);
    }

    public final x c(int i) {
        return (x) ((aj) this.b).d.get(i);
    }

    public final void d(x xVar) {
        if (!this.b.H()) {
            v();
        }
        aj ajVar = (aj) this.b;
        aj ajVar2 = aj.a;
        xVar.getClass();
        ajVar.c();
        ajVar.d.add(xVar);
    }

    public final void e(bd bdVar) {
        if (!this.b.H()) {
            v();
        }
        aj ajVar = (aj) this.b;
        aj ajVar2 = aj.a;
        bdVar.getClass();
        com.google.android.libraries.navigation.internal.ael.bz bzVar = ajVar.c;
        if (!bzVar.c()) {
            ajVar.c = com.google.android.libraries.navigation.internal.ael.bi.A(bzVar);
        }
        ajVar.c.add(bdVar);
    }

    public final void f(com.google.android.libraries.navigation.internal.adf.b bVar) {
        if (!this.b.H()) {
            v();
        }
        aj ajVar = (aj) this.b;
        aj ajVar2 = aj.a;
        bVar.getClass();
        com.google.android.libraries.navigation.internal.adf.b bVar2 = ajVar.k;
        if (bVar2 != null && bVar2 != com.google.android.libraries.navigation.internal.adf.b.a) {
            com.google.android.libraries.navigation.internal.adf.a aVar = (com.google.android.libraries.navigation.internal.adf.a) com.google.android.libraries.navigation.internal.adf.b.a.r(ajVar.k);
            aVar.x(bVar);
            bVar = (com.google.android.libraries.navigation.internal.adf.b) aVar.u();
        }
        ajVar.k = bVar;
        ajVar.b |= 2097152;
    }

    public final void g(int i, u uVar) {
        if (!this.b.H()) {
            v();
        }
        aj ajVar = (aj) this.b;
        x xVar = (x) uVar.t();
        aj ajVar2 = aj.a;
        xVar.getClass();
        ajVar.c();
        ajVar.d.set(i, xVar);
    }

    public final void h(int i, x xVar) {
        if (!this.b.H()) {
            v();
        }
        aj ajVar = (aj) this.b;
        aj ajVar2 = aj.a;
        xVar.getClass();
        ajVar.c();
        ajVar.d.set(i, xVar);
    }
}
