package com.google.android.libraries.navigation.internal.afl;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class lw extends com.google.android.libraries.navigation.internal.ael.bd implements com.google.android.libraries.navigation.internal.ael.bf {
    public lw() {
        super(lz.a);
    }

    public final void c(int i) {
        if (!this.b.H()) {
            v();
        }
        lz lzVar = (lz) this.b;
        lz lzVar2 = lz.a;
        if (i == 0) {
            throw null;
        }
        com.google.android.libraries.navigation.internal.ael.bq bqVar = lzVar.e;
        if (!bqVar.c()) {
            lzVar.e = com.google.android.libraries.navigation.internal.ael.bi.w(bqVar);
        }
        com.google.android.libraries.navigation.internal.ael.bq bqVar2 = lzVar.e;
        if (i == 0) {
            throw null;
        }
        bqVar2.i(i);
    }
}
