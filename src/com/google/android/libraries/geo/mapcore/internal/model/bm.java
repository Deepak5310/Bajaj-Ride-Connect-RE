package com.google.android.libraries.geo.mapcore.internal.model;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes2.dex */
final class bm {
    public int a;
    public int b;
    public int c;
    public int d;

    public bm(bm bmVar) {
        this.a = bmVar.a;
        this.b = bmVar.b;
        this.c = bmVar.c;
        this.d = bmVar.d;
    }

    public bm(com.google.android.libraries.navigation.internal.oe.x xVar) {
        int i = xVar.a;
        this.a = i;
        int i2 = xVar.b;
        this.b = i2;
        this.c = i;
        this.d = i2;
    }

    final void a(int i, int i2) {
        if (i < this.a) {
            this.a = i;
        }
        if (i2 < this.b) {
            this.b = i2;
        }
        if (i > this.c) {
            this.c = i;
        }
        if (i2 > this.d) {
            this.d = i2;
        }
    }

    public final String toString() {
        return "[(" + this.a + "," + this.b + "),(" + this.c + "," + this.d + ")]";
    }
}
