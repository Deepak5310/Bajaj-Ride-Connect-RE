package com.google.android.libraries.navigation.internal.zx;

import com.google.android.libraries.navigation.internal.yx.ar;
import com.google.android.libraries.navigation.internal.yz.dm;
import java.util.Map;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class g extends dm {
    final /* synthetic */ Map.Entry a;

    public g(Map.Entry entry) {
        this.a = entry;
    }

    @Override // com.google.android.libraries.navigation.internal.yz.dm
    protected final Map.Entry a() {
        return this.a;
    }

    @Override // com.google.android.libraries.navigation.internal.yz.dm, com.google.android.libraries.navigation.internal.yz.Cdo
    protected final /* synthetic */ Object aF() {
        return this.a;
    }

    @Override // com.google.android.libraries.navigation.internal.yz.dm, java.util.Map.Entry
    public final Object setValue(Object obj) {
        ar.t(obj, "null value in entry (%s, %s)", getKey(), obj);
        return this.a.setValue(obj);
    }
}
