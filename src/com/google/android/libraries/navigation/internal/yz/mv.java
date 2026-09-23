package com.google.android.libraries.navigation.internal.yz;

import java.util.Map;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class mv extends dm {
    final /* synthetic */ Map.Entry a;

    public mv(Map.Entry entry) {
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
    public final boolean equals(Object obj) {
        if (!(obj instanceof Map.Entry)) {
            return false;
        }
        Map.Entry entry = (Map.Entry) obj;
        return com.google.android.libraries.navigation.internal.yx.am.a(getKey(), entry.getKey()) && com.google.android.libraries.navigation.internal.yx.am.a(getValue(), entry.getValue());
    }

    @Override // com.google.android.libraries.navigation.internal.yz.dm, java.util.Map.Entry
    public final Object setValue(Object obj) {
        com.google.android.libraries.navigation.internal.yx.ar.q(obj);
        return super.setValue(obj);
    }
}
