package com.google.android.libraries.navigation.internal.abi;

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class m extends c {
    public m(i iVar) {
        super(iVar);
    }

    @Override // com.google.android.libraries.navigation.internal.abi.c
    protected final void c(j jVar) {
        this.a.b(jVar, false);
    }

    @Override // com.google.android.libraries.navigation.internal.abi.c
    protected final boolean d(j jVar) {
        return this.a.d(jVar, false);
    }

    @Override // com.google.android.libraries.navigation.internal.abi.c
    public final boolean f() {
        return true;
    }

    @Override // com.google.android.libraries.navigation.internal.abi.c
    protected final boolean h(j jVar) {
        return this.a.c(jVar, false);
    }

    @Override // com.google.android.libraries.navigation.internal.abi.c
    public final int i(long j, LinkedList linkedList, List list) {
        if (linkedList.size() < 3) {
            return 2;
        }
        g gVar = (g) linkedList.getLast();
        float fI = gVar.i();
        ListIterator listIterator = linkedList.listIterator(linkedList.size());
        g gVar2 = gVar;
        while (listIterator.hasPrevious()) {
            g gVar3 = (g) listIterator.previous();
            if (gVar3.e() != gVar.e()) {
                break;
            }
            if (Math.abs(a(fI, gVar3.i())) > 0.17453292f) {
                return 1;
            }
            gVar2 = gVar3;
        }
        return Math.abs(gVar2.j() - gVar.j()) / ((gVar.b() + gVar.d()) * 0.5f) < (true != list.isEmpty() ? 0.2f : 0.1f) ? 2 : 3;
    }
}
