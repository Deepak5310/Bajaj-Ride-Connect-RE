package com.google.android.libraries.navigation.internal.wb;

import android.content.res.Configuration;
import android.os.Bundle;
import androidx.tracing.Trace;
import com.google.android.libraries.navigation.internal.cl.bd;
import com.google.android.libraries.navigation.internal.cl.be;
import com.google.android.libraries.navigation.internal.uh.w;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public class n implements com.google.android.libraries.navigation.internal.uh.o {
    public final com.google.android.libraries.navigation.internal.vl.c a;
    public final com.google.android.libraries.navigation.internal.ub.l b;
    private final List d;
    private final w e;
    private final com.google.android.libraries.navigation.internal.uh.l f;
    public boolean c = false;
    private boolean g = false;
    private boolean h = false;

    public n(List list, w wVar, com.google.android.libraries.navigation.internal.vl.c cVar, com.google.android.libraries.navigation.internal.ub.l lVar, com.google.android.libraries.navigation.internal.uh.l lVar2) {
        this.d = new ArrayList(list);
        this.e = wVar;
        this.a = cVar;
        this.b = lVar;
        this.f = lVar2;
    }

    public final void a() {
        if (this.h) {
            if (this.g && this.c) {
                return;
            }
            Iterator it2 = this.d.iterator();
            while (it2.hasNext()) {
                ((com.google.android.libraries.navigation.internal.uh.c) it2.next()).l();
            }
            this.e.o(null);
            this.h = false;
        }
    }

    @Override // com.google.android.libraries.navigation.internal.uh.c
    public final void aC() {
        Iterator it2 = this.d.iterator();
        while (it2.hasNext()) {
            ((com.google.android.libraries.navigation.internal.uh.c) it2.next()).aC();
        }
    }

    @Override // com.google.android.libraries.navigation.internal.uh.c
    public final void ay(Configuration configuration) {
        Iterator it2 = this.d.iterator();
        while (it2.hasNext()) {
            ((com.google.android.libraries.navigation.internal.uh.c) it2.next()).ay(configuration);
        }
    }

    public final void b() {
        if (this.g && this.c && !this.h) {
            Iterator it2 = this.d.iterator();
            while (it2.hasNext()) {
                ((com.google.android.libraries.navigation.internal.uh.c) it2.next()).k();
            }
            this.e.n();
            this.h = true;
        }
    }

    public final void c(bd bdVar) {
        com.google.android.libraries.navigation.internal.uh.l lVar = this.f;
        lVar.i = bdVar;
        if (lVar.o != null) {
            lVar.a();
        }
    }

    public final void d(be beVar) {
        com.google.android.libraries.navigation.internal.uh.l lVar = this.f;
        lVar.j = beVar;
        if (lVar.o != null) {
            lVar.k.b(((com.google.android.libraries.navigation.internal.uh.j) lVar.l).a());
        }
    }

    @Override // com.google.android.libraries.navigation.internal.uh.o
    public final void f(com.google.android.libraries.navigation.internal.ui.a aVar, com.google.android.libraries.navigation.internal.ui.a aVar2) {
        Iterator it2 = this.d.iterator();
        while (it2.hasNext()) {
            ((com.google.android.libraries.navigation.internal.uh.o) it2.next()).f(aVar, aVar2);
        }
    }

    @Override // com.google.android.libraries.navigation.internal.uh.c
    public final void h(Bundle bundle) {
        Iterator it2 = this.d.iterator();
        while (it2.hasNext()) {
            ((com.google.android.libraries.navigation.internal.uh.c) it2.next()).h(bundle);
        }
    }

    @Override // com.google.android.libraries.navigation.internal.uh.c
    public final void j(Bundle bundle) {
        Iterator it2 = this.d.iterator();
        while (it2.hasNext()) {
            ((com.google.android.libraries.navigation.internal.uh.c) it2.next()).j(bundle);
        }
    }

    @Override // com.google.android.libraries.navigation.internal.uh.c
    public final void k() {
        com.google.android.libraries.navigation.internal.nw.d dVarB = com.google.android.libraries.navigation.internal.nw.e.b("NavigationControllers.onHostStarted()");
        try {
            this.g = true;
            b();
            if (dVarB != null) {
                Trace.endSection();
            }
        } catch (Throwable th) {
            if (dVarB != null) {
                try {
                    Trace.endSection();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    @Override // com.google.android.libraries.navigation.internal.uh.c
    public final void l() {
        this.g = false;
        a();
    }
}
