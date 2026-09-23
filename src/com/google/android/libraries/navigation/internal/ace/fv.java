package com.google.android.libraries.navigation.internal.ace;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class fv extends com.google.android.libraries.navigation.internal.ael.bb implements com.google.android.libraries.navigation.internal.ael.cz {
    public fv() {
        super(fw.a);
    }

    public final void c(Iterable iterable) {
        if (!this.b.H()) {
            v();
        }
        fw fwVar = (fw) this.b;
        fw fwVar2 = fw.a;
        fwVar.c();
        com.google.android.libraries.navigation.internal.ael.b.m(iterable, fwVar.b);
    }

    public final void d(String str) {
        if (!this.b.H()) {
            v();
        }
        fw fwVar = (fw) this.b;
        fw fwVar2 = fw.a;
        fwVar.c();
        fwVar.b.add(str);
    }
}
