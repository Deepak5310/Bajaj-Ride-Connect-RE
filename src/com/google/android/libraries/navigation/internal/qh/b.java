package com.google.android.libraries.navigation.internal.qh;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class b {
    public int e;
    public int f;
    public int g;
    public int h;
    public int i;
    public int j;
    public int k;
    public int l;
    public int m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f555n;
    public Integer o = null;
    public int a = 0;
    public int b = 0;
    public boolean c = false;
    public boolean d = false;

    public static int a(int i, int i2) {
        return ((Math.min(256, i) - 1) << 8) | (Math.min(256, i2) - 1);
    }

    public static int c(int i, int i2, int i3) {
        if (i == 0) {
            throw null;
        }
        int i4 = i - 1;
        int i5 = i2 - 1;
        if (i2 == 0) {
            throw null;
        }
        int i6 = i4 << 8;
        int i7 = i5 << 4;
        int i8 = i3 - 1;
        if (i3 != 0) {
            return i6 | i7 | i8;
        }
        throw null;
    }

    public final void b(int i, int i2) {
        this.a = i;
        this.b = i2;
    }
}
