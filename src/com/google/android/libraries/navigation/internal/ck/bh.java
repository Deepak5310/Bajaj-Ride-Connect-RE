package com.google.android.libraries.navigation.internal.ck;

import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class bh implements Iterable {
    private final List a;

    public bh(List list) {
        this.a = list;
    }

    @Override // java.lang.Iterable
    public final Iterator iterator() {
        return this.a.iterator();
    }
}
