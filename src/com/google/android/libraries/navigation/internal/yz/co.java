package com.google.android.libraries.navigation.internal.yz;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class co extends ap {
    final /* synthetic */ cq b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public co(cq cqVar) {
        super(cqVar);
        this.b = cqVar;
    }

    private final List b() {
        ArrayList arrayListF = hx.f(size());
        hb.f(arrayListF, iterator());
        return arrayListF;
    }

    @Override // com.google.android.libraries.navigation.internal.yz.ap, com.google.android.libraries.navigation.internal.yz.kx
    public final /* synthetic */ ku a() {
        return this.b;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final Object[] toArray() {
        return b().toArray();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final Object[] toArray(Object[] objArr) {
        return b().toArray(objArr);
    }
}
