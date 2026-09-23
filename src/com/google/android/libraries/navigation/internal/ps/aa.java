package com.google.android.libraries.navigation.internal.ps;

import com.google.android.libraries.navigation.internal.yz.ev;
import com.google.android.libraries.navigation.internal.yz.lv;
import com.google.android.libraries.navigation.internal.yz.mb;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class aa extends com.google.android.libraries.navigation.internal.fq.k {
    private Collection c;
    private final Map d;

    public aa(int i, com.google.android.libraries.navigation.internal.fq.h hVar, com.google.android.libraries.navigation.internal.fq.f fVar) {
        super(i, hVar, fVar);
        this.c = mb.a;
        this.d = new HashMap();
    }

    @Override // com.google.android.libraries.navigation.internal.fq.k
    public final synchronized Object f(Object obj) {
        Object objF = super.f(obj);
        if (objF != null) {
            return objF;
        }
        return this.d.get(obj);
    }

    @Override // com.google.android.libraries.navigation.internal.fq.k
    public final synchronized void k() {
        int i = ev.d;
        s((Collection) lv.a);
        super.k();
    }

    @Override // com.google.android.libraries.navigation.internal.fq.k
    protected final synchronized void n(Object obj, Object obj2) {
        if (this.c.contains(obj)) {
            this.d.put(obj, obj2);
        }
    }

    public final synchronized void s(Collection collection) {
        this.c = collection;
        this.d.keySet().retainAll(this.c);
    }
}
