package com.google.android.libraries.navigation.internal.ael;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class di {
    public static final di a = new di();
    private final ConcurrentMap c = new ConcurrentHashMap();
    private final ds b = new cp();

    private di() {
    }

    public final dr a(Class cls) {
        ca.f(cls, "messageType");
        dr drVarM = (dr) this.c.get(cls);
        if (drVarM == null) {
            cw cwVar = ((cp) this.b).a;
            ef efVar = dt.a;
            cv cvVarA = cwVar.a(cls);
            if (cvVarA.b()) {
                drVarM = new dc(dt.a, au.a, cvVarA.a());
            } else {
                drVarM = db.m(cvVarA, df.a, cl.a, dt.a, cp.a(cvVarA) ? au.a : null, cu.a);
            }
            ca.f(cls, "messageType");
            dr drVar = (dr) this.c.putIfAbsent(cls, drVarM);
            if (drVar != null) {
                return drVar;
            }
        }
        return drVarM;
    }

    public final dr b(Object obj) {
        return a(obj.getClass());
    }
}
