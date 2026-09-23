package com.google.android.libraries.navigation.internal.afr;

import java.util.List;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class o {
    private final List a;
    private final List b;

    public o(int i, int i2) {
        this.a = c.c(i);
        this.b = c.c(i2);
    }

    public final p a() {
        return new p(this.a, this.b);
    }

    public final void b(k kVar) {
        this.b.add(kVar);
    }

    public final void c(k kVar) {
        this.a.add(kVar);
    }
}
