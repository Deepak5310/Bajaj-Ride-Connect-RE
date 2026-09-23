package com.google.android.libraries.navigation.internal.og;

import android.os.Looper;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class d implements b {
    public final com.google.android.libraries.navigation.internal.afo.a a;
    public final Set b;
    private final com.google.android.libraries.navigation.internal.afo.a c;
    private final com.google.android.libraries.navigation.internal.afo.a d;
    private final com.google.android.libraries.navigation.internal.afo.a e;

    public d(com.google.android.libraries.navigation.internal.afo.a aVar, com.google.android.libraries.navigation.internal.afo.a aVar2, com.google.android.libraries.navigation.internal.afo.a aVar3, com.google.android.libraries.navigation.internal.afo.a aVar4) {
        new HashSet();
        this.b = new HashSet();
        this.a = aVar;
        this.c = aVar2;
        this.d = aVar3;
        this.e = aVar4;
    }

    @Override // com.google.android.libraries.navigation.internal.og.b
    public final void a(com.google.android.libraries.navigation.internal.pb.c cVar) {
        d(cVar);
    }

    @Override // com.google.android.libraries.navigation.internal.og.b
    public final void b(com.google.android.libraries.navigation.internal.pc.e eVar) {
        if (!e()) {
            ((com.google.android.libraries.navigation.internal.vu.a) this.a).a.s(eVar);
        } else {
            synchronized (this) {
                this.b.remove(eVar);
            }
        }
    }

    @Override // com.google.android.libraries.navigation.internal.og.b
    public final void c(com.google.android.libraries.navigation.internal.pc.c cVar) {
        if (e()) {
            ((com.google.android.libraries.navigation.internal.vu.h) this.c).a.a.a(cVar);
        } else {
            ((com.google.android.libraries.navigation.internal.oa.f) ((com.google.android.libraries.navigation.internal.vu.a) this.a).a.c.a()).e().d(cVar);
        }
    }

    @Override // com.google.android.libraries.navigation.internal.og.b
    public final void d(final com.google.android.libraries.navigation.internal.pb.c cVar) {
        if (e()) {
            synchronized (this) {
            }
        } else {
            if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
                ((com.google.android.libraries.navigation.internal.vu.a) this.a).a.L(cVar);
                return;
            }
            com.google.android.libraries.navigation.internal.afo.a aVar = this.e;
            ((com.google.android.libraries.navigation.internal.vu.j) aVar).a.execute(new Runnable() { // from class: com.google.android.libraries.navigation.internal.og.c
                @Override // java.lang.Runnable
                public final void run() {
                    ((com.google.android.libraries.navigation.internal.vu.a) this.a.a).a.L(cVar);
                }
            });
        }
    }

    public final boolean e() {
        return ((com.google.android.libraries.navigation.internal.vu.i) this.d).a.s().a();
    }
}
