package com.google.android.libraries.navigation.internal.zb;

import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public abstract class w {
    public final ConcurrentHashMap a = new ConcurrentHashMap();

    protected w() {
    }

    protected abstract Object a();

    public final Object b(u uVar, com.google.android.libraries.navigation.internal.zd.n nVar) {
        Object obj = this.a.get(uVar);
        if (obj != null) {
            return obj;
        }
        Object objA = a();
        Object objPutIfAbsent = this.a.putIfAbsent(uVar, objA);
        if (objPutIfAbsent != null) {
            return objPutIfAbsent;
        }
        int i = ((p) nVar).b;
        v vVar = null;
        for (int i2 = 0; i2 < i; i2++) {
            if (o.f.equals(nVar.c(i2))) {
                Object objE = nVar.e(i2);
                if (objE instanceof aa) {
                    if (vVar == null) {
                        vVar = new v(this, uVar);
                    }
                    ((aa) objE).a();
                }
            }
        }
        return objA;
    }
}
