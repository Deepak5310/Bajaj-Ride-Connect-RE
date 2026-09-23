package com.google.android.libraries.navigation.internal.zx;

import com.google.android.libraries.navigation.internal.yz.dm;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class b extends dm {
    final /* synthetic */ Map.Entry a;

    public b(Map.Entry entry) {
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
    public final /* bridge */ /* synthetic */ Object getValue() {
        return new i((List) this.a.getValue());
    }
}
