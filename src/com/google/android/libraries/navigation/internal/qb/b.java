package com.google.android.libraries.navigation.internal.qb;

import java.util.ArrayList;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class b {
    public final ArrayList a = new ArrayList();

    final void a(d dVar) {
        this.a.add(dVar);
    }

    final boolean b(d dVar, f fVar) {
        ArrayList arrayList = this.a;
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            d dVar2 = (d) arrayList.get(i);
            if (dVar2.b.f(dVar.b) && !fVar.a(dVar2, dVar).c) {
                return true;
            }
        }
        return false;
    }
}
