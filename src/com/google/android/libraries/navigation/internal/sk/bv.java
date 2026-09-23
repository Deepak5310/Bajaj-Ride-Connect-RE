package com.google.android.libraries.navigation.internal.sk;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class bv implements a {
    final /* synthetic */ bw a;
    private final a b;
    private int c;

    public bv(bw bwVar, a aVar) {
        this.a = bwVar;
        this.b = aVar;
    }

    @Override // com.google.android.libraries.navigation.internal.sk.a
    public final void a(c cVar) {
        if (c()) {
            return;
        }
        this.b.a(this.a);
    }

    @Override // com.google.android.libraries.navigation.internal.sk.a
    public final void b(c cVar) {
        bw bwVar = this.a;
        if (cVar == bwVar.a[0]) {
            this.b.b(bwVar);
        }
    }

    public final boolean c() {
        c[] cVarArr = this.a.a;
        int i = this.c;
        if (i >= cVarArr.length) {
            return false;
        }
        c cVar = cVarArr[i];
        this.c = i + 1;
        cVar.c(this);
        return true;
    }
}
