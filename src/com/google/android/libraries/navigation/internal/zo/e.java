package com.google.android.libraries.navigation.internal.zo;

import com.google.android.libraries.navigation.internal.yx.ar;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
class e extends g {
    final int a = g.d(3);

    @Override // com.google.android.libraries.navigation.internal.zo.g
    public final long a(int i) {
        return b(i) ? 0L : -1L;
    }

    @Override // com.google.android.libraries.navigation.internal.zo.g
    public final boolean b(int i) {
        ar.h(i >= 0, "%s (%s) must be >= 0", "tries", i);
        return i < this.a;
    }

    public final boolean equals(Object obj) {
        return (obj instanceof e) && this.a == ((e) obj).a;
    }

    public final int hashCode() {
        return this.a;
    }
}
