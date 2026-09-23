package com.google.android.libraries.navigation.internal.ael;

import java.util.Iterator;
import java.util.Map;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class dw implements Iterator {
    final /* synthetic */ dy a;
    private int b = -1;
    private boolean c;
    private Iterator d;

    public dw(dy dyVar) {
        this.a = dyVar;
    }

    private final Iterator a() {
        if (this.d == null) {
            this.d = this.a.c.entrySet().iterator();
        }
        return this.d;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        int i = this.b + 1;
        dy dyVar = this.a;
        if (i >= dyVar.b) {
            return !dyVar.c.isEmpty() && a().hasNext();
        }
        return true;
    }

    @Override // java.util.Iterator
    public final /* bridge */ /* synthetic */ Object next() {
        this.c = true;
        int i = this.b + 1;
        this.b = i;
        dy dyVar = this.a;
        return i < dyVar.b ? (dv) dyVar.a[i] : (Map.Entry) a().next();
    }

    @Override // java.util.Iterator
    public final void remove() {
        if (!this.c) {
            throw new IllegalStateException("remove() was called before next()");
        }
        this.c = false;
        this.a.e();
        int i = this.b;
        dy dyVar = this.a;
        if (i >= dyVar.b) {
            a().remove();
        } else {
            this.b = i - 1;
            dyVar.c(i);
        }
    }
}
