package com.google.android.libraries.navigation.internal.sv;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public abstract class a {
    protected final com.google.android.libraries.navigation.internal.ia.e a;
    private final aw b;

    protected a(aw awVar, com.google.android.libraries.navigation.internal.ia.e eVar) {
        this.b = awVar;
        this.a = eVar;
    }

    protected abstract com.google.android.libraries.navigation.internal.tj.w c();

    protected abstract void d();

    protected final void e() {
        c().a = 3;
        this.a.a(new com.google.android.libraries.navigation.internal.sr.m(c()));
    }

    public final void f() {
        if (c().a == 1) {
            d();
        }
        this.b.c(c());
    }
}
