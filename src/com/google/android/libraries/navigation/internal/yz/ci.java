package com.google.android.libraries.navigation.internal.yz;

import java.util.Comparator;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class ci extends ck {
    public static final ck h(int i) {
        if (i < 0) {
            return ck.c;
        }
        return i > 0 ? ck.d : ck.b;
    }

    @Override // com.google.android.libraries.navigation.internal.yz.ck
    public final int a() {
        return 0;
    }

    @Override // com.google.android.libraries.navigation.internal.yz.ck
    public final ck b(float f, float f2) {
        return h(Float.compare(f, f2));
    }

    @Override // com.google.android.libraries.navigation.internal.yz.ck
    public final ck c(int i, int i2) {
        return h(Integer.compare(i, i2));
    }

    @Override // com.google.android.libraries.navigation.internal.yz.ck
    public final ck d(long j, long j2) {
        return h(Long.compare(j, j2));
    }

    @Override // com.google.android.libraries.navigation.internal.yz.ck
    public final ck e(Comparable comparable, Comparable comparable2) {
        return h(comparable.compareTo(comparable2));
    }

    @Override // com.google.android.libraries.navigation.internal.yz.ck
    public final ck f(Object obj, Object obj2, Comparator comparator) {
        return h(comparator.compare(obj, obj2));
    }

    @Override // com.google.android.libraries.navigation.internal.yz.ck
    public final ck g(boolean z, boolean z2) {
        return h(Boolean.compare(z, z2));
    }
}
