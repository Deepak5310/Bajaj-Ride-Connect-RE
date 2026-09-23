package com.google.android.libraries.navigation.internal.zz;

import com.google.android.libraries.navigation.internal.yz.lo;
import java.util.Comparator;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class k extends lo {
    final /* synthetic */ Comparator a;
    final /* synthetic */ Map b;

    public k(Comparator comparator, Map map) {
        this.a = comparator;
        this.b = map;
    }

    @Override // com.google.android.libraries.navigation.internal.yz.lo, java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        return this.a.compare(Objects.requireNonNull(this.b.get(obj)), Objects.requireNonNull(this.b.get(obj2)));
    }
}
