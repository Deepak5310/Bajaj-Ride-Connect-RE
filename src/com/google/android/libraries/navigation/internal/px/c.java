package com.google.android.libraries.navigation.internal.px;

import com.google.android.libraries.navigation.internal.agi.kw;
import java.util.Collection;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class c {
    ek a;
    final kw b;
    int c;

    public c(ek ekVar, Collection collection, int i) {
        kw kwVar = new kw();
        this.b = kwVar;
        this.a = ekVar;
        kwVar.addAll(collection);
        this.c = i;
    }
}
