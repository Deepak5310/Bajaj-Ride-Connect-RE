package com.google.android.libraries.navigation.internal.aga;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class ed {
    final int a;
    final int b;
    final AtomicInteger c;

    public ed(float f, float f2) {
        AtomicInteger atomicInteger = new AtomicInteger();
        this.c = atomicInteger;
        this.b = (int) (f2 * 1000.0f);
        int i = (int) (f * 1000.0f);
        this.a = i;
        atomicInteger.set(i);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ed)) {
            return false;
        }
        ed edVar = (ed) obj;
        return this.a == edVar.a && this.b == edVar.b;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.a), Integer.valueOf(this.b)});
    }
}
