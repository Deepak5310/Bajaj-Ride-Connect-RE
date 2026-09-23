package com.google.android.libraries.navigation.internal.nt;

import com.google.android.libraries.navigation.internal.yx.br;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class l {
    private final ConcurrentHashMap a = new ConcurrentHashMap();

    private final o c(Object obj) {
        return (o) this.a.get(obj);
    }

    public final synchronized m a(Object obj, br brVar) {
        o oVarC = c(obj);
        if (oVarC != null) {
            return oVarC;
        }
        o oVar = new o(brVar);
        this.a.put(obj, oVar);
        return oVar;
    }

    public final synchronized void b(Object obj) {
        o oVarC = c(obj);
        if (oVarC != null) {
            oVarC.j();
        }
    }
}
