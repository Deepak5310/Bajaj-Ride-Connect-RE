package com.google.android.libraries.navigation.internal.fw;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class n {
    public final u a = new u();
    public final v b;
    public final com.google.android.libraries.navigation.internal.mj.a c;
    public long d;
    public int e;
    public long f;
    private long g;

    public n(v vVar, com.google.android.libraries.navigation.internal.mj.a aVar) {
        this.b = vVar;
        this.c = aVar;
    }

    public final void a(int i, boolean z) {
        this.e = i - ((int) this.d);
        this.c.a();
        u uVar = this.a;
        long j = uVar.b;
        int i2 = this.e;
        uVar.b = j + ((long) i2);
        uVar.d++;
        this.b.i(i2, z);
        if (z) {
            u uVar2 = this.a;
            uVar2.c += (long) this.e;
            uVar2.e++;
        }
    }

    public final void b(long j) {
        this.c.a();
        long j2 = j - this.d;
        this.f = j2;
        this.a.a += j2;
        this.b.h(j2);
    }

    public final void c(long j) {
        this.d = j;
        this.g = this.c.a();
    }
}
