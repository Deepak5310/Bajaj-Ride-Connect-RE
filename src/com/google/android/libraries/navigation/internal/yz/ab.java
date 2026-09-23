package com.google.android.libraries.navigation.internal.yz;

import java.util.Iterator;
import java.util.NavigableSet;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class ab extends ad implements NavigableSet {
    final /* synthetic */ ae f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ab(ae aeVar, Object obj, NavigableSet navigableSet, y yVar) {
        super(aeVar, obj, navigableSet, yVar);
        this.f = aeVar;
    }

    private final NavigableSet f(NavigableSet navigableSet) {
        y yVar = this.c;
        if (yVar == null) {
            yVar = this;
        }
        return new ab(this.f, this.a, navigableSet, yVar);
    }

    @Override // java.util.NavigableSet
    public final Object ceiling(Object obj) {
        return e().ceiling(obj);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.libraries.navigation.internal.yz.ad
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public final NavigableSet e() {
        return (NavigableSet) super.e();
    }

    @Override // java.util.NavigableSet
    public final Iterator descendingIterator() {
        return new x(this, e().descendingIterator());
    }

    @Override // java.util.NavigableSet
    public final NavigableSet descendingSet() {
        return f(e().descendingSet());
    }

    @Override // java.util.NavigableSet
    public final Object floor(Object obj) {
        return e().floor(obj);
    }

    @Override // java.util.NavigableSet
    public final NavigableSet headSet(Object obj, boolean z) {
        return f(e().headSet(obj, z));
    }

    @Override // java.util.NavigableSet
    public final Object higher(Object obj) {
        return e().higher(obj);
    }

    @Override // java.util.NavigableSet
    public final Object lower(Object obj) {
        return e().lower(obj);
    }

    @Override // java.util.NavigableSet
    public final Object pollFirst() {
        return hb.c(iterator());
    }

    @Override // java.util.NavigableSet
    public final Object pollLast() {
        return hb.c(descendingIterator());
    }

    @Override // java.util.NavigableSet
    public final NavigableSet subSet(Object obj, boolean z, Object obj2, boolean z2) {
        return f(e().subSet(obj, z, obj2, z2));
    }

    @Override // java.util.NavigableSet
    public final NavigableSet tailSet(Object obj, boolean z) {
        return f(e().tailSet(obj, z));
    }
}
