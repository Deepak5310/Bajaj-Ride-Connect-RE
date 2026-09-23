package com.google.android.libraries.navigation.internal.yz;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
class ei extends ej {
    Object[] a;
    int b;
    boolean c;

    public ei(int i) {
        bs.d(i, "initialCapacity");
        this.a = new Object[i];
        this.b = 0;
    }

    private final void g(int i) {
        int length = this.a.length;
        int iF = f(length, this.b + i);
        if (iF > length || this.c) {
            this.a = Arrays.copyOf(this.a, iF);
            this.c = false;
        }
    }

    final void a(Object[] objArr, int i) {
        lj.d(objArr, i);
        g(i);
        System.arraycopy(objArr, 0, this.a, this.b, i);
        this.b += i;
    }

    public final void b(Object obj) {
        com.google.android.libraries.navigation.internal.yx.ar.q(obj);
        g(1);
        Object[] objArr = this.a;
        int i = this.b;
        this.b = i + 1;
        objArr[i] = obj;
    }

    @Override // com.google.android.libraries.navigation.internal.yz.ej
    public /* bridge */ /* synthetic */ void c(Object obj) {
        throw null;
    }

    public final void d(Object... objArr) {
        a(objArr, objArr.length);
    }

    public final void e(Iterable iterable) {
        if (iterable instanceof Collection) {
            Collection collection = (Collection) iterable;
            g(collection.size());
            if (collection instanceof ek) {
                this.b = ((ek) collection).a(this.a, this.b);
                return;
            }
        }
        Iterator it2 = iterable.iterator();
        while (it2.hasNext()) {
            c(it2.next());
        }
    }
}
