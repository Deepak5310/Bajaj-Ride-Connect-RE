package com.google.android.libraries.navigation.internal.abm;

import com.google.android.libraries.navigation.internal.yz.ev;
import com.google.android.libraries.navigation.internal.yz.lv;
import java.util.ArrayList;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class ag {
    private final com.google.android.libraries.navigation.internal.pt.a a;
    private final af b;

    public ag(com.google.android.libraries.navigation.internal.pt.a aVar) {
        af afVar = af.a;
        com.google.android.libraries.navigation.internal.abf.s.k(aVar, "phoenixIndoorBuilding");
        com.google.android.libraries.navigation.internal.pt.a aVar2 = aVar.f;
        this.a = aVar2 != null ? aVar2 : aVar;
        this.b = afVar;
    }

    public final int a() {
        return this.a.d;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final ev b() {
        ev evVar = this.a.b;
        lv lvVar = (lv) evVar;
        ArrayList arrayList = new ArrayList(lvVar.c);
        int i = lvVar.c;
        for (int i2 = 0; i2 < i; i2++) {
            arrayList.add(new ah((com.google.android.libraries.navigation.internal.pt.c) evVar.get(i2)));
        }
        return ev.o(arrayList);
    }

    public final Object c() {
        return this.a.a;
    }

    public final boolean d() {
        return this.a.c;
    }
}
