package com.google.android.libraries.navigation.internal.yz;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class lk extends kv {
    final Object a;
    int b;
    final /* synthetic */ ll c;

    public lk(ll llVar, int i) {
        this.c = llVar;
        this.a = llVar.a[i];
        this.b = i;
    }

    /* JADX WARN: Code duplicated, block: B:8:0x0017  */
    @Override // com.google.android.libraries.navigation.internal.yz.kt
    public final int a() {
        int i = this.b;
        if (i != -1) {
            ll llVar = this.c;
            if (i >= llVar.c || !com.google.android.libraries.navigation.internal.yx.am.a(this.a, llVar.a[i])) {
                this.b = this.c.e(this.a);
            }
        } else {
            this.b = this.c.e(this.a);
        }
        int i2 = this.b;
        if (i2 == -1) {
            return 0;
        }
        return this.c.b[i2];
    }

    @Override // com.google.android.libraries.navigation.internal.yz.kt
    public final Object b() {
        return this.a;
    }
}
