package com.google.android.libraries.navigation.internal.adr;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class kb extends com.google.android.libraries.navigation.internal.ael.bb implements com.google.android.libraries.navigation.internal.ael.cz {
    public kb() {
        super(ki.a);
    }

    public final gj c(int i) {
        return (gj) ((ki) this.b).h.get(i);
    }

    public final void d() {
        if (!this.b.H()) {
            v();
        }
        ki kiVar = (ki) this.b;
        ki kiVar2 = ki.a;
        kiVar.c();
        kiVar.h.remove(0);
    }

    public final void e(int i, gi giVar) {
        if (!this.b.H()) {
            v();
        }
        ki kiVar = (ki) this.b;
        gj gjVar = (gj) giVar.t();
        ki kiVar2 = ki.a;
        gjVar.getClass();
        kiVar.c();
        kiVar.h.set(i, gjVar);
    }

    public final void f(int i, gj gjVar) {
        if (!this.b.H()) {
            v();
        }
        ki kiVar = (ki) this.b;
        ki kiVar2 = ki.a;
        gjVar.getClass();
        kiVar.c();
        kiVar.h.set(i, gjVar);
    }
}
