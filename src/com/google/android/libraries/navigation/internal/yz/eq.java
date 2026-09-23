package com.google.android.libraries.navigation.internal.yz;

import java.util.Iterator;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class eq extends ei {
    public eq() {
        super(4);
    }

    @Override // com.google.android.libraries.navigation.internal.yz.ei, com.google.android.libraries.navigation.internal.yz.ej
    public final /* synthetic */ void c(Object obj) {
        super.b(obj);
    }

    public final ev g() {
        this.c = true;
        return ev.l(this.a, this.b);
    }

    public final void h(Object obj) {
        super.b(obj);
    }

    public final void i(Object... objArr) {
        super.d(objArr);
    }

    public final void j(Iterable iterable) {
        super.e(iterable);
    }

    public final void k(Iterator it2) {
        while (it2.hasNext()) {
            c(it2.next());
        }
    }

    public eq(int i) {
        super(i);
    }
}
