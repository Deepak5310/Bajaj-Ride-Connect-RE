package com.google.android.libraries.navigation.internal.ta;

import com.google.android.libraries.navigation.internal.yz.ev;
import java.util.Set;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class m implements com.google.android.libraries.navigation.internal.afr.f {
    private final com.google.android.libraries.navigation.internal.agl.a a;
    private final com.google.android.libraries.navigation.internal.agl.a b;

    public m(com.google.android.libraries.navigation.internal.agl.a aVar, com.google.android.libraries.navigation.internal.agl.a aVar2) {
        this.a = aVar;
        this.b = aVar2;
    }

    @Override // com.google.android.libraries.navigation.internal.agl.a, com.google.android.libraries.navigation.internal.agk.a
    public final /* bridge */ /* synthetic */ Object a() {
        Set setA = ((com.google.android.libraries.navigation.internal.afr.p) this.a).a();
        return new r(ev.o(setA), (com.google.android.libraries.navigation.internal.so.f) this.b.a());
    }
}
