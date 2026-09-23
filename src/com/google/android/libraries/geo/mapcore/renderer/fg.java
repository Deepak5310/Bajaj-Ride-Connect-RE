package com.google.android.libraries.geo.mapcore.renderer;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes2.dex */
public final class fg {
    public final int a;
    public final int b;
    public final int c;
    public final int d;

    public fg(int i, int i2, int i3) {
        this(i, i2, 0, i3);
    }

    public fg(int i, int i2, int i3, int i4) {
        this.a = i;
        this.b = i2;
        this.c = i3;
        this.d = i4;
    }

    public final fg a(int i) {
        return new fg(this.a, this.b, i, this.d);
    }

    public final String toString() {
        return this.a + "," + this.b + "," + this.d + "," + this.c;
    }
}
