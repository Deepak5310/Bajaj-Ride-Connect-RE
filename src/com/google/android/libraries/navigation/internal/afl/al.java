package com.google.android.libraries.navigation.internal.afl;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class al extends com.google.android.libraries.navigation.internal.ael.bb implements an {
    public al() {
        super(am.a);
    }

    public final void c(Iterable iterable) {
        if (!this.b.H()) {
            v();
        }
        am amVar = (am) this.b;
        am amVar2 = am.a;
        amVar.e();
        com.google.android.libraries.navigation.internal.ael.b.m(iterable, amVar.c);
    }

    public final void d(hb hbVar) {
        if (!this.b.H()) {
            v();
        }
        am amVar = (am) this.b;
        am amVar2 = am.a;
        hbVar.getClass();
        amVar.e();
        amVar.c.add(hbVar);
    }
}
