package com.google.android.libraries.navigation.internal.yz;

import java.util.Map;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class jl extends aj {
    final /* synthetic */ Map.Entry a;
    final /* synthetic */ js b;

    public jl(Map.Entry entry, js jsVar) {
        this.a = entry;
        this.b = jsVar;
    }

    @Override // com.google.android.libraries.navigation.internal.yz.aj, java.util.Map.Entry
    public final Object getKey() {
        return this.a.getKey();
    }

    @Override // com.google.android.libraries.navigation.internal.yz.aj, java.util.Map.Entry
    public final Object getValue() {
        Map.Entry entry = this.a;
        entry.getKey();
        return this.b.a(entry.getValue());
    }
}
