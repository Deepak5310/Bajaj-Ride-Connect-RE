package com.google.android.libraries.navigation.internal.qu;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public class ch {
    private static final com.google.android.libraries.navigation.internal.zb.j b = com.google.android.libraries.navigation.internal.zb.j.e("com.google.android.libraries.navigation.internal.qu.ch");
    public final Map a = new HashMap();
    private final com.google.android.libraries.navigation.internal.mj.a c;
    private final com.google.android.libraries.navigation.internal.adi.an d;

    public ch(com.google.android.libraries.navigation.internal.mj.a aVar, com.google.android.libraries.navigation.internal.adi.an anVar) {
        this.c = aVar;
        this.d = anVar;
    }

    final void a(com.google.android.libraries.geo.mapcore.internal.model.cd cdVar) {
        if (this.a.containsKey(cdVar)) {
            return;
        }
        this.a.put(cdVar, new cg(this.c, this.d));
    }

    final void b(com.google.android.libraries.geo.mapcore.internal.model.cd cdVar) {
        this.a.remove(cdVar);
    }

    final boolean c(com.google.android.libraries.geo.mapcore.internal.model.cd cdVar) {
        cg cgVar = (cg) this.a.get(cdVar);
        if (cgVar == null) {
            return true;
        }
        if (cgVar.a.f().toEpochMilli() < cgVar.d) {
            cgVar.b.name();
            cgVar.a.f().toEpochMilli();
            return false;
        }
        cgVar.c = Math.min(TimeUnit.DAYS.toMillis(1L), (long) (cgVar.c * ((Math.random() * 0.9d) + 1.1d)));
        cgVar.d = cgVar.a.f().toEpochMilli() + cgVar.c;
        cgVar.b.name();
        return true;
    }
}
