package com.google.android.libraries.navigation.internal.yz;

import java.util.Iterator;
import java.util.Map;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class ju extends jt {
    final /* synthetic */ jv a;

    public ju(jv jvVar) {
        this.a = jvVar;
    }

    @Override // com.google.android.libraries.navigation.internal.yz.jt
    public final Map a() {
        return this.a;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public final Iterator iterator() {
        return this.a.a();
    }
}
