package com.google.android.libraries.navigation.internal.px;

import com.google.android.libraries.navigation.internal.adg.hg;
import java.util.Iterator;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class f implements Iterable {
    public final com.google.android.libraries.navigation.internal.yz.ek a;
    final /* synthetic */ g b;

    public f(g gVar, com.google.android.libraries.navigation.internal.yz.ek ekVar) {
        this.b = gVar;
        this.a = ekVar;
    }

    final int a(hg hgVar) {
        return this.b.a.o(hgVar);
    }

    @Override // java.lang.Iterable
    public final /* synthetic */ Iterator iterator() {
        return new e(this);
    }
}
