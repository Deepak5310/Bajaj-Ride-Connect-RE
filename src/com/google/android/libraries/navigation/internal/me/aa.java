package com.google.android.libraries.navigation.internal.me;

import com.google.android.libraries.navigation.internal.lh.be;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class aa {
    public final ae a = new ae();

    public aa() {
    }

    public aa(a aVar) {
        ((c) aVar).a.j(new b(new z(this)));
    }

    public final void a(Exception exc) {
        this.a.l(exc);
    }

    public final void b(Object obj) {
        this.a.m(obj);
    }

    public final void c(Exception exc) {
        be.k(exc, "Exception must not be null");
        ae aeVar = this.a;
        synchronized (aeVar.a) {
            if (aeVar.c) {
                return;
            }
            aeVar.c = true;
            aeVar.e = exc;
            aeVar.b.b(aeVar);
        }
    }
}
