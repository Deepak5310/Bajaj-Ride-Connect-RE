package com.google.android.libraries.navigation.internal.xe;

import android.content.res.Configuration;
import android.os.Bundle;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public class du implements com.google.android.libraries.navigation.internal.ms.cs, com.google.android.libraries.navigation.internal.uh.o, com.google.android.libraries.navigation.internal.uh.v, com.google.android.libraries.navigation.internal.rw.c {
    private Executor b;
    private com.google.android.libraries.navigation.internal.uj.d c;
    private com.google.android.libraries.navigation.internal.uz.d d;
    private com.google.android.libraries.navigation.internal.uh.w e;
    private com.google.android.libraries.navigation.internal.rw.f h;
    public boolean a = false;
    private boolean f = false;
    private boolean g = false;

    private final void d() {
        if (this.g) {
            if (this.f && this.a) {
                return;
            }
            this.e.l();
            this.e.o(null);
            this.g = false;
        }
    }

    @Override // com.google.android.libraries.navigation.internal.uh.v
    public void a(com.google.android.libraries.navigation.internal.ui.a aVar) {
    }

    @Override // com.google.android.libraries.navigation.internal.uh.c
    public void aC() {
        this.h.d(this);
    }

    @Override // com.google.android.libraries.navigation.internal.uh.c
    public void ay(Configuration configuration) {
    }

    public void b(Executor executor, com.google.android.libraries.navigation.internal.uj.d dVar, com.google.android.libraries.navigation.internal.uh.w wVar, com.google.android.libraries.navigation.internal.uz.d dVar2, com.google.android.libraries.navigation.internal.rw.f fVar) {
        this.b = executor;
        this.c = dVar;
        this.d = dVar2;
        this.e = wVar;
        this.h = fVar;
        dVar.k(com.google.android.libraries.navigation.internal.aac.bw.a);
    }

    public final void c() {
        if (this.f && this.a && !this.g) {
            this.e.k();
            this.e.n();
            this.g = true;
        }
    }

    @Override // com.google.android.libraries.navigation.internal.uh.o
    public void f(com.google.android.libraries.navigation.internal.ui.a aVar, com.google.android.libraries.navigation.internal.ui.a aVar2) {
        if (aVar.c()) {
            this.c.l(aVar);
            this.d.e(aVar.h, aVar.i, this.c.g(), this);
        } else {
            this.a = false;
            d();
        }
    }

    @Override // com.google.android.libraries.navigation.internal.uh.c
    public void h(Bundle bundle) {
        this.h.c(this, this.b);
        if (com.google.android.libraries.navigation.internal.rw.p.GUIDING.equals(this.h.b())) {
            this.a = true;
            c();
        }
    }

    @Override // com.google.android.libraries.navigation.internal.rw.c
    public void i(com.google.android.libraries.navigation.internal.rw.p pVar, com.google.android.libraries.navigation.internal.rw.p pVar2) {
        if (com.google.android.libraries.navigation.internal.rw.p.GUIDING.equals(pVar2)) {
            this.b.execute(new dt(this));
        }
    }

    @Override // com.google.android.libraries.navigation.internal.uh.c
    public void j(Bundle bundle) {
        com.google.android.libraries.navigation.internal.uh.w wVar = this.e;
        if (wVar != null) {
            wVar.j(bundle);
        }
    }

    @Override // com.google.android.libraries.navigation.internal.uh.c
    public void k() {
        this.f = true;
        c();
    }

    @Override // com.google.android.libraries.navigation.internal.uh.c
    public void l() {
        this.f = false;
        d();
    }
}
