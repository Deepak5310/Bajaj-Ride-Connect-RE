package com.google.android.libraries.navigation.internal.po;

import java.util.Objects;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class f extends ep {
    private com.google.android.libraries.navigation.internal.qq.f a;
    private int b;
    private byte c;

    public f() {
    }

    public f(eq eqVar) {
        g gVar = (g) eqVar;
        this.a = gVar.a;
        this.b = gVar.b;
        this.c = (byte) 1;
    }

    @Override // com.google.android.libraries.navigation.internal.po.ep
    public final eq a() {
        com.google.android.libraries.navigation.internal.qq.f fVar;
        if (this.c != 1 || (fVar = this.a) == null) {
            throw new IllegalStateException();
        }
        return new g(fVar, this.b);
    }

    @Override // com.google.android.libraries.navigation.internal.po.ep
    public final void b(com.google.android.libraries.navigation.internal.qq.f fVar) {
        Objects.requireNonNull(fVar);
        this.a = fVar;
    }

    @Override // com.google.android.libraries.navigation.internal.po.ep
    public final void c(int i) {
        this.b = i;
        this.c = (byte) 1;
    }
}
