package com.google.android.libraries.navigation.internal.yz;

import java.util.Map;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class jm implements com.google.android.libraries.navigation.internal.yx.aa {
    final /* synthetic */ js a;

    public jm(js jsVar) {
        this.a = jsVar;
    }

    @Override // com.google.android.libraries.navigation.internal.yx.aa
    public final /* bridge */ /* synthetic */ Object ak(Object obj) {
        Map.Entry entry = (Map.Entry) obj;
        js jsVar = this.a;
        com.google.android.libraries.navigation.internal.yx.ar.q(jsVar);
        com.google.android.libraries.navigation.internal.yx.ar.q(entry);
        return new jl(entry, jsVar);
    }
}
