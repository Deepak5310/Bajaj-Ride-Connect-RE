package com.google.android.libraries.navigation.internal.ps;

import com.google.android.libraries.geo.mapcore.internal.model.cd;
import com.google.android.libraries.geo.mapcore.internal.model.cg;
import com.google.android.libraries.navigation.internal.adi.an;
import com.google.android.libraries.navigation.internal.qu.cf;
import com.google.android.libraries.navigation.internal.yz.ev;
import com.google.android.libraries.navigation.internal.yz.lv;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class h {
    public final aa a;
    public final s b;
    public final s c;
    public final Executor d;
    public final Map e;
    private final cf f;
    private final g g;

    public h(com.google.android.libraries.navigation.internal.fq.f fVar, Executor executor, cf cfVar) {
        g gVar = new g();
        this.d = executor;
        this.f = cfVar;
        this.g = gVar;
        this.a = new aa(50, com.google.android.libraries.navigation.internal.fq.h.INDOOR_METADATA, fVar);
        this.b = new s(new aa(1024, com.google.android.libraries.navigation.internal.fq.h.INDOOR_BUILDING, fVar));
        this.c = new s(new aa(1024, com.google.android.libraries.navigation.internal.fq.h.INDOOR_LEVEL, fVar));
        this.e = new HashMap();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void a(Collection collection) {
        Iterator it2 = collection.iterator();
        while (it2.hasNext()) {
            com.google.android.libraries.navigation.internal.pt.a aVar = ((com.google.android.libraries.navigation.internal.pt.b) it2.next()).b;
            if (aVar != null) {
                this.b.b(aVar.a, aVar);
                int i = 0;
                while (true) {
                    ev evVar = aVar.b;
                    if (i < ((lv) evVar).c) {
                        com.google.android.libraries.navigation.internal.pt.c cVar = (com.google.android.libraries.navigation.internal.pt.c) evVar.get(i);
                        this.c.b(cVar.a(), cVar);
                        i++;
                    }
                }
            }
        }
    }

    public final void b(cd cdVar) {
        List list;
        Collection collection = (Collection) this.a.f(cdVar);
        if (collection != null) {
            synchronized (this) {
                list = (List) this.e.remove(cdVar);
            }
            if (list != null) {
                Iterator it2 = list.iterator();
                while (it2.hasNext()) {
                    ((f) it2.next()).a(cdVar, 0, collection);
                }
            }
            a(collection);
            return;
        }
        cf cfVar = this.f;
        com.google.android.libraries.navigation.internal.qv.k kVarC = cfVar.c(cfVar.b.a(an.GMM_VECTOR_BASE), cg.s, false);
        boolean z = (kVarC instanceof com.google.android.libraries.navigation.internal.qu.aa) && ((com.google.android.libraries.navigation.internal.qu.aa) kVarC).t();
        i iVar = new i(new d(this, z));
        if (z) {
            kVarC.g(cdVar, iVar, com.google.android.libraries.navigation.internal.rb.b.b());
        } else {
            kVarC.i(cdVar, iVar, false);
        }
    }

    public final void c(com.google.android.libraries.navigation.internal.oe.i iVar, e eVar) {
        this.b.a(iVar, eVar);
    }
}
