package com.google.android.libraries.navigation.internal.kg;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class d {
    private c a = null;
    private c b = null;
    private final com.google.android.libraries.navigation.internal.mj.a c;
    private final com.google.android.libraries.navigation.internal.kl.b d;

    public d(com.google.android.libraries.navigation.internal.mj.a aVar, com.google.android.libraries.navigation.internal.kl.b bVar) {
        this.c = aVar;
        this.d = bVar;
    }

    public final c a(int i) {
        if (i == 0) {
            throw null;
        }
        int i2 = i - 1;
        if (i2 == 0) {
            c cVar = new c(i, this.c, this.d);
            this.a = cVar;
            return cVar;
        }
        if (i2 != 1) {
            throw new IllegalStateException(String.format("Unexpected identifier: %s, is it added to FpsProfilers.createFpsProfiler()?", b.a(i)));
        }
        c cVar2 = new c(i, this.c, this.d);
        this.b = cVar2;
        return cVar2;
    }
}
