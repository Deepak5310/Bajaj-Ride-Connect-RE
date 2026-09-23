package com.google.android.libraries.navigation.internal.hr;

import com.google.android.libraries.navigation.internal.afl.am;
import com.google.android.libraries.navigation.internal.afl.ea;
import com.google.android.libraries.navigation.internal.afl.ha;
import com.google.android.libraries.navigation.internal.afl.hb;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Predicate;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class l implements com.google.android.libraries.navigation.internal.gg.e {
    final /* synthetic */ com.google.android.libraries.navigation.internal.hu.b a;
    final /* synthetic */ m b;

    public l(m mVar, com.google.android.libraries.navigation.internal.hu.b bVar) {
        this.a = bVar;
        this.b = mVar;
    }

    @Override // com.google.android.libraries.navigation.internal.gg.e
    public final void a(com.google.android.libraries.navigation.internal.gg.i iVar, com.google.android.libraries.navigation.internal.gg.o oVar) {
        com.google.android.libraries.navigation.internal.zb.j jVar = o.a;
        synchronized (this.b.g.k) {
            this.b.g.k.putIfAbsent(oVar, 0);
            Map map = this.b.g.k;
            map.put(oVar, Integer.valueOf(((Integer) map.get(oVar)).intValue() + 1));
        }
        Throwable th = oVar.r;
        ((com.google.android.libraries.navigation.internal.zb.h) com.google.android.libraries.navigation.internal.zb.j.b.F(675)).s("Failed to get a successful parameters response, %s", oVar);
        m mVar = this.b;
        mVar.g.f(mVar, null, oVar, this.a);
    }

    @Override // com.google.android.libraries.navigation.internal.gg.e
    public final /* bridge */ /* synthetic */ void b(com.google.android.libraries.navigation.internal.gg.i iVar, Object obj) {
        am amVar = (am) obj;
        com.google.android.libraries.navigation.internal.zb.j jVar = o.a;
        if (amVar != null) {
            amVar.c.stream().filter(new Predicate() { // from class: com.google.android.libraries.navigation.internal.hr.j
                @Override // java.util.function.Predicate
                public final boolean test(Object obj2) {
                    return (((hb) obj2).b & 2) != 0;
                }
            }).forEach(new Consumer() { // from class: com.google.android.libraries.navigation.internal.hr.k
                @Override // java.util.function.Consumer
                public final void accept(Object obj2) {
                    hb hbVar = (hb) obj2;
                    ha haVarB = ha.b(hbVar.e);
                    if (haVarB == null) {
                        haVarB = ha.UNKNOWN_TYPE;
                    }
                    if (haVarB == ha.LOGGING) {
                        com.google.android.libraries.navigation.internal.kk.i iVar2 = (com.google.android.libraries.navigation.internal.kk.i) ((com.google.android.libraries.navigation.internal.kl.a) this.a.b.g.b.a()).a(com.google.android.libraries.navigation.internal.hw.a.p);
                        boolean z = true;
                        if (((hbVar.c == 18 ? (ea) hbVar.d : ea.a).b & 65536) == 0) {
                            if (((hbVar.c == 18 ? (ea) hbVar.d : ea.a).b & 131072) == 0) {
                                z = false;
                            }
                        }
                        iVar2.a(z);
                    }
                    int i = hbVar.e;
                }
            });
        }
        ((com.google.android.libraries.navigation.internal.kk.k) ((com.google.android.libraries.navigation.internal.kl.a) this.b.g.b.a()).a(com.google.android.libraries.navigation.internal.hw.a.q)).a(this.b.c.m);
        m mVar = this.b;
        mVar.g.f(mVar, amVar, null, this.a);
    }
}
