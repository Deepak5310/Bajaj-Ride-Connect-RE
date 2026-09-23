package com.google.android.libraries.navigation.internal.km;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class ab {
    public final com.google.android.libraries.navigation.internal.kk.n a;
    private final com.google.android.libraries.navigation.internal.ih.a b = com.google.android.libraries.navigation.internal.ih.a.b(new aa(this));
    private boolean c;

    public ab(com.google.android.libraries.navigation.internal.kk.n nVar) {
        this.a = nVar;
    }

    public final synchronized void a() {
        if (this.c) {
            return;
        }
        ((com.google.android.libraries.navigation.internal.kk.m) this.b.a()).b();
        ((com.google.android.libraries.navigation.internal.kk.m) this.b.a()).a();
    }

    public final synchronized void b() {
        ((com.google.android.libraries.navigation.internal.kk.m) this.b.a()).b();
        this.c = true;
    }

    public final synchronized void c() {
        if (this.c) {
            ((com.google.android.libraries.navigation.internal.kk.m) this.b.a()).a();
            this.c = false;
        }
    }

    public final synchronized void d() {
        this.c = false;
    }

    public final synchronized boolean e() {
        return this.c;
    }
}
