package com.google.android.libraries.navigation.internal.sk;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class eq implements c {
    private final com.google.android.libraries.navigation.internal.ia.e a;
    private final com.google.android.libraries.navigation.internal.sm.f b;

    public eq(com.google.android.libraries.navigation.internal.ia.e eVar, long[] jArr, int i, String str) {
        this.a = eVar;
        this.b = new com.google.android.libraries.navigation.internal.sm.f(jArr);
    }

    @Override // com.google.android.libraries.navigation.internal.sk.c
    public final long a() {
        return -1L;
    }

    @Override // com.google.android.libraries.navigation.internal.sk.c
    public final void b() {
    }

    @Override // com.google.android.libraries.navigation.internal.sk.c
    public final void c(a aVar) {
        if (aVar != null) {
            aVar.b(this);
        }
        this.a.a(this.b);
        if (aVar != null) {
            aVar.a(this);
        }
    }

    @Override // com.google.android.libraries.navigation.internal.sk.c
    public final boolean d() {
        return true;
    }

    @Override // com.google.android.libraries.navigation.internal.sk.c
    public final int e() {
        return b.d;
    }
}
