package com.google.android.libraries.navigation.internal.agh;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
abstract class cs {
    int b;
    final int c;
    int d;
    boolean e;
    boolean f;
    final /* synthetic */ cv g;

    public cs(cv cvVar) {
        this.g = cvVar;
        this.b = 0;
        this.c = cvVar.f;
        this.d = 0;
        this.e = cvVar.e;
        this.f = false;
    }

    public cs(cv cvVar, int i, int i2, boolean z) {
        this.g = cvVar;
        this.d = 0;
        this.b = i;
        this.c = i2;
        this.e = z;
        this.f = true;
    }

    public abstract cs a(int i, int i2, boolean z);

    public abstract void c(Object obj, int i);

    public final cs e() {
        int i;
        int i2 = this.c;
        int i3 = this.b;
        if (i3 >= i2 - 1 || (i = (i2 - i3) >> 1) <= 1) {
            return null;
        }
        int i4 = i + i3;
        cs csVarA = a(i3, i4, this.e);
        this.b = i4;
        this.e = false;
        this.f = true;
        return csVarA;
    }

    public final long estimateSize() {
        if (!this.f) {
            return this.g.i - this.d;
        }
        cv cvVar = this.g;
        return Math.min(cvVar.i - this.d, ((long) ((((double) cvVar.v()) / ((double) this.g.f)) * ((double) (this.c - this.b)))) + (this.e ? 1L : 0L));
    }

    public final void forEachRemaining(Object obj) {
        if (this.e) {
            this.e = false;
            this.d++;
            c(obj, this.g.f);
        }
        long[] jArr = this.g.b;
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
            c(obj, this.g.f);
            return true;
        }
        long[] jArr = this.g.b;
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
