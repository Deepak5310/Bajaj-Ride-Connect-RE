package com.google.android.libraries.navigation.internal.yz;

import java.util.Map;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class lb extends dm {
    final /* synthetic */ Map.Entry a;

    public lb(Map.Entry entry) {
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
        lf.b((Class) getKey(), obj);
        return super.setValue(obj);
    }
}
