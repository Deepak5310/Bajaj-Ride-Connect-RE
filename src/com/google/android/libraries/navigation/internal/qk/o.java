package com.google.android.libraries.navigation.internal.qk;

import com.google.android.libraries.navigation.internal.yz.kc;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class o {
    public final List a;
    public final List b;
    public final List c;
    public final Map d;
    public com.google.android.libraries.navigation.internal.oe.x e;
    private final List f;

    public o() {
        ArrayList arrayList = new ArrayList();
        this.f = arrayList;
        this.a = Collections.unmodifiableList(arrayList);
        ArrayList arrayList2 = new ArrayList();
        this.b = arrayList2;
        this.c = Collections.unmodifiableList(arrayList2);
        this.d = kc.g(t.class);
    }

    public final void a() {
        this.f.clear();
        this.b.clear();
        this.d.clear();
    }

    public final void b(t tVar, com.google.android.libraries.navigation.internal.qa.a aVar) {
        this.f.add(aVar);
        if (!this.d.containsKey(tVar)) {
            this.d.put(tVar, 1);
        } else {
            this.d.put(tVar, Integer.valueOf(((Integer) this.d.get(tVar)).intValue() + 1));
        }
    }
}
