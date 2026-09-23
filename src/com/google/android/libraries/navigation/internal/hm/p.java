package com.google.android.libraries.navigation.internal.hm;

import com.google.android.libraries.navigation.internal.ael.cz;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class p implements com.google.android.libraries.navigation.internal.hn.r, com.google.android.libraries.navigation.internal.nt.t {
    private final com.google.android.libraries.navigation.internal.fz.d a;
    private final com.google.android.libraries.navigation.internal.yx.aa b;
    private volatile cz d = null;
    private final Map c = new HashMap();

    public p(com.google.android.libraries.navigation.internal.ng.b bVar, com.google.android.libraries.navigation.internal.fz.d dVar, com.google.android.libraries.navigation.internal.yx.aa aaVar) {
        this.a = dVar;
        this.b = aaVar;
        com.google.android.libraries.navigation.internal.nt.m mVar = (com.google.android.libraries.navigation.internal.nt.m) bVar.b().f();
        if (mVar != null) {
            mVar.g(this, com.google.android.libraries.navigation.internal.aac.ac.INSTANCE);
        }
    }

    @Override // com.google.android.libraries.navigation.internal.nt.t
    public final void a(com.google.android.libraries.navigation.internal.nt.m mVar) {
        this.d = null;
    }

    @Override // com.google.android.libraries.navigation.internal.hn.r
    public final cz b() {
        cz czVar;
        cz czVar2 = this.d;
        if (czVar2 != null) {
            return czVar2;
        }
        com.google.android.libraries.navigation.internal.fz.d dVar = this.a;
        com.google.android.libraries.navigation.internal.yx.aa aaVar = this.b;
        Map map = this.c;
        com.google.android.libraries.navigation.internal.fz.c cVarA = dVar.a(aaVar);
        synchronized (map) {
            czVar = (cz) this.c.get(((com.google.android.libraries.navigation.internal.fz.a) cVarA).a);
            if (czVar == null) {
                czVar = ((com.google.android.libraries.navigation.internal.fz.a) cVarA).b;
                this.c.put(((com.google.android.libraries.navigation.internal.fz.a) cVarA).a, czVar);
            }
            this.d = czVar;
        }
        return czVar;
    }
}
