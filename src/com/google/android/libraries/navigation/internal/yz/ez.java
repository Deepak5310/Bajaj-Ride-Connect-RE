package com.google.android.libraries.navigation.internal.yz;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public class ez {
    Object[] a;
    int b;
    ey c;

    public ez() {
        this(4);
    }

    private final fd h(boolean z) {
        ey eyVar;
        ey eyVar2;
        if (z && (eyVar2 = this.c) != null) {
            throw eyVar2.a();
        }
        ma maVarP = ma.p(this.b, this.a, this);
        if (!z || (eyVar = this.c) == null) {
            return maVarP;
        }
        throw eyVar.a();
    }

    public ez a(Iterable iterable) {
        if (iterable instanceof Collection) {
            e(this.b + ((Collection) iterable).size());
        }
        Iterator it2 = iterable.iterator();
        while (it2.hasNext()) {
            g((Map.Entry) it2.next());
        }
        return this;
    }

    public final ez b(Map map) {
        return a(map.entrySet());
    }

    public final fd c() {
        return h(false);
    }

    public fd d() {
        return h(true);
    }

    public final void e(int i) {
        Object[] objArr = this.a;
        int length = objArr.length;
        int i2 = i + i;
        if (i2 > length) {
            this.a = Arrays.copyOf(objArr, ej.f(length, i2));
        }
    }

    public void f(Object obj, Object obj2) {
        e(this.b + 1);
        bs.a(obj, obj2);
        Object[] objArr = this.a;
        int i = this.b;
        int i2 = i + i;
        objArr[i2] = obj;
        objArr[i2 + 1] = obj2;
        this.b = i + 1;
    }

    public void g(Map.Entry entry) {
        f(entry.getKey(), entry.getValue());
    }

    public ez(int i) {
        this.a = new Object[i + i];
        this.b = 0;
    }
}
