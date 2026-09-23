package com.google.android.libraries.navigation.internal.adg;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class gl extends com.google.android.libraries.navigation.internal.ael.bb implements com.google.android.libraries.navigation.internal.ael.cz {
    public gl() {
        super(gm.a);
    }

    public final void c(Iterable iterable) {
        if (!this.b.H()) {
            v();
        }
        gm gmVar = (gm) this.b;
        gm gmVar2 = gm.a;
        gmVar.c();
        com.google.android.libraries.navigation.internal.ael.b.m(iterable, gmVar.e);
    }

    public final void d(float f) {
        if (!this.b.H()) {
            v();
        }
        gm gmVar = (gm) this.b;
        gm gmVar2 = gm.a;
        gmVar.c();
        gmVar.e.h(f);
    }

    public final void e(int i) {
        if (!this.b.H()) {
            v();
        }
        gm gmVar = (gm) this.b;
        gm gmVar2 = gm.a;
        com.google.android.libraries.navigation.internal.ael.bq bqVar = gmVar.i;
        if (!bqVar.c()) {
            gmVar.i = com.google.android.libraries.navigation.internal.ael.bi.w(bqVar);
        }
        gmVar.i.i(i);
    }
}
