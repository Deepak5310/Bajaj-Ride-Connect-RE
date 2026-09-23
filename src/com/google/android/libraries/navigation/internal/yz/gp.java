package com.google.android.libraries.navigation.internal.yz;

import java.util.Iterator;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class gp extends de {
    final /* synthetic */ Iterable a;
    final /* synthetic */ com.google.android.libraries.navigation.internal.yx.aa b;

    public gp(Iterable iterable, com.google.android.libraries.navigation.internal.yx.aa aaVar) {
        this.a = iterable;
        this.b = aaVar;
    }

    @Override // java.lang.Iterable
    public final Iterator iterator() {
        return hb.d(this.a.iterator(), this.b);
    }
}
