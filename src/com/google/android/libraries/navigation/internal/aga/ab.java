package com.google.android.libraries.navigation.internal.aga;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class ab implements de {
    public Runnable a;
    public Runnable b;
    private final Executor e;
    private final com.google.android.libraries.navigation.internal.afx.cq f;
    private final com.google.android.libraries.navigation.internal.afx.aj c = com.google.android.libraries.navigation.internal.afx.aj.a(ab.class, null);
    private final Object d = new Object();
    private Collection g = new LinkedHashSet();
    private volatile aa h = new aa(null);

    public ab(Executor executor, com.google.android.libraries.navigation.internal.afx.cq cqVar) {
        this.e = executor;
        this.f = cqVar;
    }

    @Override // com.google.android.libraries.navigation.internal.aga.de
    public final Runnable a(dd ddVar) {
        throw null;
    }

    @Override // com.google.android.libraries.navigation.internal.afx.al
    public final com.google.android.libraries.navigation.internal.afx.aj b() {
        return this.c;
    }

    @Override // com.google.android.libraries.navigation.internal.aga.de
    public final void c(com.google.android.libraries.navigation.internal.afx.cl clVar) {
        throw null;
    }

    final void d(com.google.android.libraries.navigation.internal.afx.ax axVar) {
        synchronized (this.d) {
            com.google.android.libraries.navigation.internal.afx.cl clVar = this.h.a;
            this.h = new aa(null);
            if (axVar != null && e()) {
                ArrayList arrayList = new ArrayList(this.g);
                ArrayList arrayList2 = new ArrayList();
                if (arrayList.size() > 0) {
                    com.google.android.libraries.navigation.internal.afx.at atVar = ((z) arrayList.get(0)).a;
                    throw null;
                }
                synchronized (this.d) {
                    if (e()) {
                        this.g.removeAll(arrayList2);
                        if (this.g.isEmpty()) {
                            this.g = new LinkedHashSet();
                        }
                        if (!e()) {
                            this.f.c(this.a);
                            com.google.android.libraries.navigation.internal.afx.cl clVar2 = this.h.a;
                        }
                        this.f.b();
                    }
                }
            }
        }
    }

    public final boolean e() {
        boolean z;
        synchronized (this.d) {
            z = !this.g.isEmpty();
        }
        return z;
    }
}
