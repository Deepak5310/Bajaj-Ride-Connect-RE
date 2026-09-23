package com.google.android.libraries.navigation.internal.yz;

import java.util.Set;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class jz extends jy implements Set {
    public jz(Set set) {
        super(set);
    }

    @Override // java.util.Collection, java.util.Set
    public final boolean equals(Object obj) {
        return mp.j(this, obj);
    }

    @Override // java.util.Collection, java.util.Set
    public final int hashCode() {
        return mp.a(this);
    }
}
