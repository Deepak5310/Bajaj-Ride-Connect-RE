package com.google.android.libraries.navigation.internal.agi;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
abstract class in {
    int b;
    final int c;
    int d;
    boolean e;
    boolean f;
    final /* synthetic */ iq g;

    public in(iq iqVar) {
        this.g = iqVar;
        this.b = 0;
        this.c = iqVar.e;
        this.d = 0;
        this.e = iqVar.d;
        this.f = false;
    }

    public in(iq iqVar, int i, int i2, boolean z) {
        this.g = iqVar;
        this.d = 0;
        this.b = i;
        this.c = i2;
        this.e = z;
        this.f = true;
    }

    public abstract in a(int i, int i2, boolean z);

    public abstract void c(Object obj, int i);

    public final in e() {
        int i;
        int i2 = this.c;
        int i3 = this.b;
        if (i3 >= i2 - 1 || (i = (i2 - i3) >> 1) <= 1) {
            return null;
        }
        int i4 = i + i3;
        in inVarA = a(i3, i4, this.e);
        this.b = i4;
        this.e = false;
        this.f = true;
        return inVarA;
    }

    public final long estimateSize() {
        if (!this.f) {
            return this.g.h - this.d;
        }
        iq iqVar = this.g;
        return Math.min(iqVar.h - this.d, ((long) ((((double) iqVar.q()) / ((double) this.g.e)) * ((double) (this.c - this.b)))) + (this.e ? 1L : 0L));
    }

    public final void forEachRemaining(Object obj) {
        if (this.e) {
            this.e = false;
            this.d++;
            c(obj, this.g.e);
        }
        Object[] objArr = this.g.a;
        while (true) {
            int i = this.b;
            if (i >= this.c) {
                return;
            }
            if (objArr[i] != null) {
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
        Object[] objArr = this.g.a;
        while (true) {
            int i = this.b;
            if (i >= this.c) {
                return false;
            }
            int i2 = i + 1;
            if (objArr[i] != null) {
                this.d++;
                this.b = i2;
                c(obj, i);
                return true;
            }
            this.b = i2;
        }
    }
}
