package com.google.android.libraries.navigation.internal.ps;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class s {
    public final aa a;
    private final Map b = new HashMap();

    public s(aa aaVar) {
        this.a = aaVar;
    }

    public final void a(Object obj, r rVar) {
        Object objF = this.a.f(obj);
        if (objF != null) {
            rVar.a(objF);
            return;
        }
        synchronized (this.b) {
            Collection arrayList = (Collection) this.b.get(obj);
            if (arrayList == null) {
                arrayList = new ArrayList();
                this.b.put(obj, arrayList);
            }
            arrayList.add(rVar);
        }
    }

    public final void b(Object obj, Object obj2) {
        this.a.m(obj, obj2);
        synchronized (this.b) {
            if (this.b.containsKey(obj)) {
                Iterator it2 = ((Collection) this.b.get(obj)).iterator();
                while (it2.hasNext()) {
                    ((r) it2.next()).a(obj2);
                }
                this.b.remove(obj);
            }
        }
    }
}
