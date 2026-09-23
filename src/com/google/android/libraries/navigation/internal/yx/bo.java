package com.google.android.libraries.navigation.internal.yx;

import java.util.Set;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class bo {
    final boolean[] a = new boolean[256];
    final Set b;

    public bo(Set set) {
        this.b = set;
        for (int i = 0; i < 256; i++) {
            this.a[i] = this.b.contains(Integer.valueOf(i));
        }
    }
}
