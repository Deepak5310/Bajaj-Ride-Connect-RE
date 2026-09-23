package com.google.android.libraries.navigation.internal.yz;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class gg extends ez {
    private transient Object[] d;
    private transient Object[] e;
    private final Comparator f;

    public gg(Comparator comparator) {
        com.google.android.libraries.navigation.internal.yx.ar.q(comparator);
        this.f = comparator;
        this.d = new Object[4];
        this.e = new Object[4];
    }

    @Override // com.google.android.libraries.navigation.internal.yz.ez
    public final /* synthetic */ ez a(Iterable iterable) {
        super.a(iterable);
        return this;
    }

    @Override // com.google.android.libraries.navigation.internal.yz.ez
    public final /* synthetic */ void g(Map.Entry entry) {
        super.g(entry);
    }

    @Override // com.google.android.libraries.navigation.internal.yz.ez
    /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
    public final void f(Object obj, Object obj2) {
        int i = this.b + 1;
        int length = this.d.length;
        if (i > length) {
            int iF = ej.f(length, i);
            this.d = Arrays.copyOf(this.d, iF);
            this.e = Arrays.copyOf(this.e, iF);
        }
        bs.a(obj, obj2);
        Object[] objArr = this.d;
        int i2 = this.b;
        objArr[i2] = obj;
        this.e[i2] = obj2;
        this.b = i2 + 1;
    }

    @Override // com.google.android.libraries.navigation.internal.yz.ez
    /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
    public final gi d() {
        int i = this.b;
        if (i == 0) {
            return gi.a(this.f);
        }
        if (i == 1) {
            return gi.r(this.f, Objects.requireNonNull(this.d[0]), Objects.requireNonNull(this.e[0]));
        }
        Object[] objArrCopyOf = Arrays.copyOf(this.d, i);
        Arrays.sort(objArrCopyOf, this.f);
        Object[] objArr = new Object[this.b];
        for (int i2 = 0; i2 < this.b; i2++) {
            if (i2 > 0) {
                int i3 = i2 - 1;
                if (this.f.compare(objArrCopyOf[i3], objArrCopyOf[i2]) == 0) {
                    throw new IllegalArgumentException("keys required to be distinct but compared as equal: " + String.valueOf(objArrCopyOf[i3]) + " and " + String.valueOf(objArrCopyOf[i2]));
                }
            }
            objArr[Arrays.binarySearch(objArrCopyOf, Objects.requireNonNull(this.d[i2]), this.f)] = Objects.requireNonNull(this.e[i2]);
        }
        return new gi(new mc(ev.k(objArrCopyOf), this.f), ev.k(objArr));
    }
}
