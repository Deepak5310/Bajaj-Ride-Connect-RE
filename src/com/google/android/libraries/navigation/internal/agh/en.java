package com.google.android.libraries.navigation.internal.agh;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
abstract class en {
    int b;
    final int c;
    int d;
    boolean e;
    boolean f;
    final /* synthetic */ eq g;

    public en(eq eqVar) {
        this.g = eqVar;
        this.b = 0;
        this.c = eqVar.e;
        this.d = 0;
        this.e = eqVar.d;
        this.f = false;
    }

    public en(eq eqVar, int i, int i2, boolean z) {
        this.g = eqVar;
        this.d = 0;
        this.b = i;
        this.c = i2;
        this.e = z;
        this.f = true;
    }

    public abstract en a(int i, int i2, boolean z);

    public abstract void c(Object obj, int i);

    public final en e() {
        int i;
        int i2 = this.c;
        int i3 = this.b;
        if (i3 >= i2 - 1 || (i = (i2 - i3) >> 1) <= 1) {
            return null;
        }
        int i4 = i + i3;
        en enVarA = a(i3, i4, this.e);
        this.b = i4;
        this.e = false;
        this.f = true;
        return enVarA;
    }

    public final long estimateSize() {
        if (!this.f) {
            return this.g.h - this.d;
        }
        eq eqVar = this.g;
        return Math.min(eqVar.h - this.d, ((long) ((((double) eqVar.h()) / ((double) this.g.e)) * ((double) (this.c - this.b)))) + (this.e ? 1L : 0L));
    }

    public final void forEachRemaining(Object obj) {
        if (this.e) {
            this.e = false;
            this.d++;
            c(obj, this.g.e);
        }
        long[] jArr = this.g.a;
        while (true) {
            int i = this.b;
            if (i >= this.c) {
                return;
            }
            if (jArr[i] != 0) {
                c(obj, i);
                this.d++;
            }
            this.b++;
        }
    }

    public final boolean tryAdvance(Object obj) {
        if (this.e) {
            this.e = false;
            this.d++;
            c(obj, this.g.e);
            return true;
        }
        long[] jArr = this.g.a;
        while (true) {
            int i = this.b;
            if (i >= this.c) {
                return false;
            }
            int i2 = i + 1;
            if (jArr[i] != 0) {
                this.d++;
                this.b = i2;
                c(obj, i);
                return true;
            }
            this.b = i2;
        }
    }
}
