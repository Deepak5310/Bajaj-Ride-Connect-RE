package com.google.android.libraries.navigation.internal.zd;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class r extends u {
    private final Map a;
    private final Map b;
    private final t c;
    private final s d;

    public r(q qVar) {
        HashMap map = new HashMap();
        this.a = map;
        HashMap map2 = new HashMap();
        this.b = map2;
        map.putAll(qVar.c);
        map2.putAll(qVar.d);
        this.c = qVar.e;
        this.d = qVar.f;
    }

    @Override // com.google.android.libraries.navigation.internal.zd.u
    protected final void a(com.google.android.libraries.navigation.internal.zb.ac acVar, Object obj, Object obj2) {
        t tVar = (t) this.a.get(acVar);
        if (tVar != null) {
            tVar.a(acVar, obj, obj2);
        } else {
            this.c.a(acVar, obj, obj2);
        }
    }

    @Override // com.google.android.libraries.navigation.internal.zd.u
    protected final void b(com.google.android.libraries.navigation.internal.zb.ac acVar, Iterator it2, Object obj) {
        s sVar = (s) this.b.get(acVar);
        if (sVar != null) {
            sVar.a(acVar, it2, obj);
        } else if (this.d != null && !this.a.containsKey(acVar)) {
            this.d.a(acVar, it2, obj);
        } else {
            while (it2.hasNext()) {
                a(acVar, it2.next(), obj);
            }
        }
    }
}
