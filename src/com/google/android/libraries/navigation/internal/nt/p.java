package com.google.android.libraries.navigation.internal.nt;

import com.google.android.libraries.navigation.internal.yx.am;
import com.google.android.libraries.navigation.internal.yx.br;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class p implements br {
    public final o a;
    private final AtomicReference b;

    public p() {
        this.b = new AtomicReference(null);
        this.a = new o();
    }

    private final Object d(Object obj) {
        o oVar = this.a;
        Object andSet = this.b.getAndSet(obj);
        if (!oVar.i()) {
            this.a.n(this);
        }
        return andSet;
    }

    @Override // com.google.android.libraries.navigation.internal.yx.br
    public final Object a() {
        return this.b.get();
    }

    public final synchronized void b(Object obj) {
        d(obj);
        this.a.j();
    }

    public final synchronized void c(Object obj) {
        if (am.a(d(obj), obj)) {
            return;
        }
        this.a.j();
    }

    public p(Object obj) {
        this.b = new AtomicReference(obj);
        this.a = new o(this);
    }
}
