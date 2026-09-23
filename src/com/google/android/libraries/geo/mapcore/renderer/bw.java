package com.google.android.libraries.geo.mapcore.renderer;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes2.dex */
public final class bw {
    public static final bw a = new bw(0);
    final int d;
    bw b = null;
    bw c = null;
    int e = 0;
    int f = 0;
    boolean g = false;
    boolean h = false;

    public bw(int i) {
        this.d = i;
    }

    final void a(bw bwVar, bw bwVar2) {
        if (bwVar != null) {
            bwVar.c = this;
        }
        if (bwVar2 != null) {
            bwVar2.b = this;
        }
        this.b = bwVar;
        this.c = bwVar2;
        this.g = true;
    }

    public final boolean b() {
        return this.d != 0 && this.g;
    }
}
