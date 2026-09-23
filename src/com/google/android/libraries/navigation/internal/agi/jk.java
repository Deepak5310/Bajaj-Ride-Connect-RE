package com.google.android.libraries.navigation.internal.agi;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
abstract class jk {
    int b;
    final int c;
    int d;
    boolean e;
    boolean f;
    final /* synthetic */ jn g;

    public jk(jn jnVar) {
        this.g = jnVar;
        this.b = 0;
        this.c = jnVar.e;
        this.d = 0;
        this.e = jnVar.d;
        this.f = false;
    }

    public jk(jn jnVar, int i, int i2, boolean z) {
        this.g = jnVar;
        this.d = 0;
        this.b = i;
        this.c = i2;
        this.e = z;
        this.f = true;
    }

    public abstract jk a(int i, int i2, boolean z);

    public abstract void c(Object obj, int i);

    public final jk d() {
        int i;
        int i2 = this.c;
        int i3 = this.b;
        if (i3 >= i2 - 1 || (i = (i2 - i3) >> 1) <= 1) {
            return null;
        }
        int i4 = i + i3;
        jk jkVarA = a(i3, i4, this.e);
        this.b = i4;
        this.e = false;
        this.f = true;
        return jkVarA;
    }

    public final void e(Object obj) {
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

    public final long estimateSize() {
        if (!this.f) {
            return this.g.h - this.d;
        }
        jn jnVar = this.g;
        return Math.min(jnVar.h - this.d, ((long) ((((double) jnVar.e()) / ((double) this.g.e)) * ((double) (this.c - this.b)))) + (this.e ? 1L : 0L));
    }

    public final boolean f(Object obj) {
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
