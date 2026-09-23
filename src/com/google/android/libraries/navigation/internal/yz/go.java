package com.google.android.libraries.navigation.internal.yz;

import java.util.Iterator;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class go extends de {
    final /* synthetic */ Iterable a;
    final /* synthetic */ com.google.android.libraries.navigation.internal.yx.as b;

    public go(Iterable iterable, com.google.android.libraries.navigation.internal.yx.as asVar) {
        this.a = iterable;
        this.b = asVar;
    }

    @Override // java.lang.Iterable
    public final Iterator iterator() {
        Iterator it2 = this.a.iterator();
        com.google.android.libraries.navigation.internal.yx.ar.q(it2);
        com.google.android.libraries.navigation.internal.yx.as asVar = this.b;
        com.google.android.libraries.navigation.internal.yx.ar.q(asVar);
        return new gu(it2, asVar);
    }
}
