package com.google.android.libraries.navigation.internal.wb;

import com.google.android.libraries.navigation.internal.pi.x;
import com.google.android.libraries.navigation.internal.xe.bp;
import com.google.android.libraries.navigation.internal.yx.ar;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class t implements com.google.android.libraries.navigation.internal.pi.o, com.google.android.libraries.navigation.internal.pj.a {
    public com.google.android.libraries.navigation.internal.pi.s a;
    public Executor b;
    public com.google.android.libraries.navigation.internal.ua.a c;
    public Boolean d;
    private com.google.android.libraries.navigation.internal.tt.d e;

    private final void d(com.google.android.libraries.navigation.internal.tt.d dVar) {
        this.e = dVar;
        com.google.android.libraries.navigation.internal.ua.a aVar = this.c;
        ar.q(aVar);
        bp bpVar = (bp) aVar;
        com.google.android.libraries.navigation.internal.tt.d dVar2 = bpVar.f647n;
        if (dVar2 == null || ((com.google.android.libraries.navigation.internal.tt.b) dVar).a != ((com.google.android.libraries.navigation.internal.tt.b) dVar2).a) {
            bpVar.h(dVar);
            bpVar.l.X(true);
        }
    }

    public final void a(boolean z) {
        this.d = Boolean.valueOf(z);
    }

    @Override // com.google.android.libraries.navigation.internal.pi.o
    public final void b(x xVar) {
        Boolean bool = this.d;
        ar.q(bool);
        if (bool.booleanValue()) {
            com.google.android.libraries.navigation.internal.ua.a aVar = this.c;
            ar.q(aVar);
            if (((bp) aVar).k) {
                return;
            }
            com.google.android.libraries.navigation.internal.pf.a aVar2 = xVar.a;
            com.google.android.libraries.navigation.internal.ua.a aVar3 = this.c;
            ar.q(aVar3);
            boolean zD = aVar3.d();
            com.google.android.libraries.navigation.internal.tt.d dVar = ((com.google.android.libraries.navigation.internal.pf.c) aVar2).a;
            if (!zD) {
                d(dVar);
                return;
            }
            com.google.android.libraries.navigation.internal.tt.d dVar2 = this.e;
            ar.q(dVar2);
            if (((com.google.android.libraries.navigation.internal.tt.b) dVar2).a != ((com.google.android.libraries.navigation.internal.tt.b) dVar).a) {
                d(dVar);
            }
        }
    }

    public final void c() {
        com.google.android.libraries.navigation.internal.ua.a aVar = this.c;
        ar.q(aVar);
        if (aVar.d()) {
            com.google.android.libraries.navigation.internal.ua.a aVar2 = this.c;
            ar.q(aVar2);
            aVar2.b();
        }
    }
}
