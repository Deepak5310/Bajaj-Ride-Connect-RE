package com.google.android.libraries.navigation.internal.sk;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class bw implements c {
    public final c[] a;

    public bw(c[] cVarArr) {
        this.a = cVarArr;
    }

    @Override // com.google.android.libraries.navigation.internal.sk.c
    public final long a() {
        if (e() == b.d) {
            return -1L;
        }
        long j = 0;
        for (c cVar : this.a) {
            long jA = cVar.a();
            if (jA != -1) {
                j += jA;
            }
        }
        return j;
    }

    @Override // com.google.android.libraries.navigation.internal.sk.c
    public final void b() {
        for (c cVar : this.a) {
            cVar.b();
        }
    }

    @Override // com.google.android.libraries.navigation.internal.sk.c
    public final void c(a aVar) {
        new bv(this, aVar).c();
    }

    @Override // com.google.android.libraries.navigation.internal.sk.c
    public final boolean d() {
        for (c cVar : this.a) {
            if (!cVar.d()) {
                return false;
            }
        }
        return true;
    }

    @Override // com.google.android.libraries.navigation.internal.sk.c
    public final int e() {
        for (c cVar : this.a) {
            if (cVar.e() != b.d) {
                return cVar.e();
            }
        }
        return b.d;
    }
}
