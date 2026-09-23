package com.google.android.libraries.navigation.internal.eh;

import com.google.android.libraries.navigation.internal.ace.hs;
import com.google.android.libraries.navigation.internal.ee.u;
import com.google.android.libraries.navigation.internal.hm.j;
import com.google.android.libraries.navigation.internal.nt.m;
import com.google.android.libraries.navigation.internal.nt.t;
import com.google.android.libraries.navigation.internal.yx.an;
import com.google.android.libraries.navigation.internal.yx.br;
import com.google.android.libraries.navigation.internal.yx.bw;
import com.google.android.libraries.navigation.internal.yz.ek;
import com.google.android.libraries.navigation.internal.yz.fd;
import com.google.android.libraries.navigation.internal.yz.fs;
import com.google.android.libraries.navigation.internal.yz.fw;
import com.google.android.libraries.navigation.internal.yz.fy;
import com.google.android.libraries.navigation.internal.yz.ma;
import com.google.android.libraries.navigation.internal.yz.nn;
import java.util.HashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class d {
    public final AtomicReference a = new AtomicReference(ma.b);
    public final AtomicReference b = new AtomicReference(ma.b);
    public final Executor c;
    public final com.google.android.libraries.navigation.internal.ek.a d;
    public final j e;
    private final br f;
    private final com.google.android.libraries.navigation.internal.ei.a g;

    public d(com.google.android.libraries.navigation.internal.ei.a aVar, com.google.android.libraries.navigation.internal.ek.a aVar2, final com.google.android.libraries.navigation.internal.ej.a aVar3, j jVar, Executor executor) {
        this.g = aVar;
        this.d = aVar2;
        this.e = jVar;
        this.c = executor;
        this.f = bw.a(new br() { // from class: com.google.android.libraries.navigation.internal.eh.c
            @Override // com.google.android.libraries.navigation.internal.yx.br
            public final Object a() {
                return new AtomicBoolean(!((hs) aVar3.a.b()).b);
            }
        });
    }

    public final u a(int i) {
        fd fdVar = (fd) this.b.get();
        if (fdVar.isEmpty()) {
            d();
            if (((AtomicBoolean) this.f.a()).getAndSet(false)) {
                this.c.execute(new Runnable() { // from class: com.google.android.libraries.navigation.internal.eh.a
                    @Override // java.lang.Runnable
                    public final void run() {
                        final d dVar = this.a;
                        dVar.e.a().g(new t() { // from class: com.google.android.libraries.navigation.internal.eh.b
                            @Override // com.google.android.libraries.navigation.internal.nt.t
                            public final void a(m mVar) {
                                dVar.d();
                            }
                        }, dVar.c);
                    }
                });
            }
            fdVar = (fd) this.b.get();
        }
        com.google.android.libraries.navigation.internal.el.b bVar = (com.google.android.libraries.navigation.internal.el.b) fdVar.get(Integer.valueOf(i));
        if (bVar != null) {
            return bVar.a();
        }
        return null;
    }

    public final fd b(HashMap map) {
        fs fsVarB = this.g.b();
        fw fwVar = new fw();
        fwVar.k(fsVarB.x());
        fwVar.k(map.keySet());
        fy fyVarI = fwVar.i();
        HashMap map2 = new HashMap();
        nn nnVarListIterator = fyVarI.listIterator();
        while (nnVarListIterator.hasNext()) {
            Integer num = (Integer) nnVarListIterator.next();
            ek ekVarA = fsVarB.c(num);
            Integer num2 = (Integer) map.get(num);
            if (num2 != null) {
                map2.put(num2, num);
            } else {
                nn nnVarListIterator2 = ekVarA.listIterator();
                while (nnVarListIterator2.hasNext()) {
                    map2.put((Integer) nnVarListIterator2.next(), num);
                }
            }
        }
        return fd.j(map2);
    }

    public final fd c(fd fdVar, HashMap map) {
        u uVar;
        nn nnVarListIterator = fdVar.keySet().listIterator();
        while (nnVarListIterator.hasNext()) {
            Integer num = (Integer) nnVarListIterator.next();
            if (!map.containsKey(num) && (uVar = (u) fdVar.get(num)) != null) {
                map.put(num, new com.google.android.libraries.navigation.internal.el.a(uVar, com.google.android.libraries.navigation.internal.ei.a.c(num.intValue()), com.google.android.libraries.navigation.internal.ei.a.d(num.intValue()), com.google.android.libraries.navigation.internal.ei.a.e(num.intValue())));
            }
        }
        return fd.j(map);
    }

    public final void d() {
        this.b.set(c((fd) an.i(this.g.a()).e(ma.b), com.google.android.libraries.navigation.internal.ek.a.a()));
        this.a.set(b(com.google.android.libraries.navigation.internal.ek.a.b()));
    }
}
