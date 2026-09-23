package com.google.android.libraries.navigation.internal.yz;

import java.util.ListIterator;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class z extends x implements ListIterator {
    final /* synthetic */ aa d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public z(aa aaVar) {
        super(aaVar);
        this.d = aaVar;
    }

    private final ListIterator b() {
        a();
        return (ListIterator) this.a;
    }

    @Override // java.util.ListIterator
    public final void add(Object obj) {
        boolean zIsEmpty = this.d.isEmpty();
        b().add(obj);
        aa aaVar = this.d;
        aaVar.f.b++;
        if (zIsEmpty) {
            aaVar.a();
        }
    }

    @Override // java.util.ListIterator
    public final boolean hasPrevious() {
        return b().hasPrevious();
    }

    @Override // java.util.ListIterator
    public final int nextIndex() {
        return b().nextIndex();
    }

    @Override // java.util.ListIterator
    public final Object previous() {
        return b().previous();
    }

    @Override // java.util.ListIterator
    public final int previousIndex() {
        return b().previousIndex();
    }

    @Override // java.util.ListIterator
    public final void set(Object obj) {
        b().set(obj);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public z(aa aaVar, int i) {
        super(aaVar, aaVar.d().listIterator(i));
        this.d = aaVar;
    }
}
