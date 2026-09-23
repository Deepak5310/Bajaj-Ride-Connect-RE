package com.google.android.libraries.navigation.internal.abi;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class q extends c {
    public q(i iVar) {
        super(iVar);
    }

    @Override // com.google.android.libraries.navigation.internal.abi.c
    protected final void c(j jVar) {
        this.a.b(jVar, true);
    }

    @Override // com.google.android.libraries.navigation.internal.abi.c
    protected final boolean d(j jVar) {
        return this.a.d(jVar, true);
    }

    @Override // com.google.android.libraries.navigation.internal.abi.c
    public final boolean e() {
        return true;
    }

    @Override // com.google.android.libraries.navigation.internal.abi.c
    public final boolean f() {
        return true;
    }

    @Override // com.google.android.libraries.navigation.internal.abi.c
    public final boolean g() {
        return true;
    }

    @Override // com.google.android.libraries.navigation.internal.abi.c
    protected final boolean h(j jVar) {
        return this.a.c(jVar, true);
    }

    @Override // com.google.android.libraries.navigation.internal.abi.c
    public final int i(long j, LinkedList linkedList, List list) {
        g gVar;
        g gVar2;
        Iterator it2 = linkedList.iterator();
        do {
            gVar = null;
            if (!it2.hasNext()) {
                gVar2 = null;
                break;
            }
            gVar2 = (g) it2.next();
        } while (gVar2.e() != 2);
        ListIterator listIterator = linkedList.listIterator(linkedList.size());
        while (listIterator.hasPrevious()) {
            g gVar3 = (g) listIterator.previous();
            if (gVar3.e() == 2) {
                gVar = gVar3;
                break;
            }
        }
        if (gVar2 == null || gVar == null || gVar.f() - j > 300) {
            return 1;
        }
        return Math.max(Math.max(Math.abs(gVar.a(0) - gVar2.a(0)) / gVar.b(), Math.abs(gVar.c(0) - gVar2.c(0)) / gVar.d()), Math.max(Math.abs(gVar.a(1) - gVar2.a(1)) / gVar.b(), Math.abs(gVar.c(1) - gVar2.c(1)) / gVar.d())) > 0.125f ? 1 : 3;
    }
}
