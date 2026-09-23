package com.google.android.libraries.navigation.internal.adr;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class hw extends com.google.android.libraries.navigation.internal.ael.bd implements com.google.android.libraries.navigation.internal.ael.bf {
    public hw() {
        super(ib.a);
    }

    public final hv c(int i) {
        return (hv) ((ib) this.b).d.get(i);
    }

    public final void d(int i, gw gwVar) {
        if (!this.b.H()) {
            v();
        }
        ib ibVar = (ib) this.b;
        hv hvVar = (hv) gwVar.t();
        ib ibVar2 = ib.a;
        hvVar.getClass();
        ibVar.c();
        ibVar.d.set(i, hvVar);
    }

    public final void e(int i, hv hvVar) {
        if (!this.b.H()) {
            v();
        }
        ib ibVar = (ib) this.b;
        ib ibVar2 = ib.a;
        hvVar.getClass();
        ibVar.c();
        ibVar.d.set(i, hvVar);
    }
}
