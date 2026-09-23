package com.google.android.libraries.navigation.internal.agg;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
abstract class cv {
    int b;
    final int c;
    int d;
    boolean e;
    boolean f;
    final /* synthetic */ cy g;

    public cv(cy cyVar) {
        this.g = cyVar;
        this.b = 0;
        this.c = cyVar.e;
        this.d = 0;
        this.e = cyVar.d;
        this.f = false;
    }

    public cv(cy cyVar, int i, int i2, boolean z) {
        this.g = cyVar;
        this.d = 0;
        this.b = i;
        this.c = i2;
        this.e = z;
        this.f = true;
    }

    public abstract cv a(int i, int i2, boolean z);

    public abstract void c(Object obj, int i);

    public final cv e() {
        int i;
        int i2 = this.c;
        int i3 = this.b;
        if (i3 >= i2 - 1 || (i = (i2 - i3) >> 1) <= 1) {
            return null;
        }
        int i4 = i + i3;
        cv cvVarA = a(i3, i4, this.e);
        this.b = i4;
        this.e = false;
        this.f = true;
        return cvVarA;
    }

    public final long estimateSize() {
        if (!this.f) {
            return this.g.h - this.d;
        }
        cy cyVar = this.g;
        return Math.min(cyVar.h - this.d, ((long) ((((double) cyVar.j()) / ((double) this.g.e)) * ((double) (this.c - this.b)))) + (this.e ? 1L : 0L));
    }

    public final void forEachRemaining(Object obj) {
        if (this.e) {
            this.e = false;
            this.d++;
            c(obj, this.g.e);
        }
        int[] iArr = this.g.a;
        while (true) {
            int i = this.b;
            if (i >= this.c) {
                return;
            }
            if (iArr[i] != 0) {
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
        int[] iArr = this.g.a;
        while (true) {
            int i = this.b;
            if (i >= this.c) {
                return false;
            }
            int i2 = i + 1;
            if (iArr[i] != 0) {
                this.d++;
                this.b = i2;
                c(obj, i);
                return true;
            }
            this.b = i2;
        }
    }
}
