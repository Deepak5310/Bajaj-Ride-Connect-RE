package com.google.android.libraries.navigation.internal.afl;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class lb extends com.google.android.libraries.navigation.internal.ael.bb implements com.google.android.libraries.navigation.internal.ael.cz {
    public lb() {
        super(lh.a);
    }

    public final com.google.android.libraries.navigation.internal.adr.ki c(int i) {
        return (com.google.android.libraries.navigation.internal.adr.ki) ((lh) this.b).d.get(i);
    }

    public final la d(int i) {
        return (la) ((lh) this.b).i.get(i);
    }

    public final void e(la laVar) {
        if (!this.b.H()) {
            v();
        }
        lh lhVar = (lh) this.b;
        lh lhVar2 = lh.a;
        laVar.getClass();
        com.google.android.libraries.navigation.internal.ael.bz bzVar = lhVar.i;
        if (!bzVar.c()) {
            lhVar.i = com.google.android.libraries.navigation.internal.ael.bi.A(bzVar);
        }
        lhVar.i.add(laVar);
    }

    public final void f(com.google.android.libraries.navigation.internal.adr.kb kbVar) {
        if (!this.b.H()) {
            v();
        }
        lh lhVar = (lh) this.b;
        com.google.android.libraries.navigation.internal.adr.ki kiVar = (com.google.android.libraries.navigation.internal.adr.ki) kbVar.t();
        lh lhVar2 = lh.a;
        kiVar.getClass();
        lhVar.e();
        lhVar.d.add(kiVar);
    }

    public final void g(com.google.android.libraries.navigation.internal.adr.ki kiVar) {
        if (!this.b.H()) {
            v();
        }
        lh lhVar = (lh) this.b;
        lh lhVar2 = lh.a;
        kiVar.getClass();
        lhVar.e();
        lhVar.d.add(kiVar);
    }

    public final void h(int i, com.google.android.libraries.navigation.internal.adr.ki kiVar) {
        if (!this.b.H()) {
            v();
        }
        lh lhVar = (lh) this.b;
        lh lhVar2 = lh.a;
        kiVar.getClass();
        lhVar.e();
        lhVar.d.set(i, kiVar);
    }
}
