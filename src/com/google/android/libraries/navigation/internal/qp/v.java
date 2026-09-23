package com.google.android.libraries.navigation.internal.qp;

import com.google.android.libraries.navigation.internal.adi.au;
import com.google.android.libraries.navigation.internal.adi.av;
import com.google.android.libraries.navigation.internal.adi.ax;
import com.google.android.libraries.navigation.internal.ael.bz;
import com.google.android.libraries.navigation.internal.km.aq;
import com.google.android.libraries.navigation.internal.qu.bq;
import com.google.android.libraries.navigation.internal.yx.ao;
import com.google.android.libraries.navigation.internal.yx.ar;
import com.google.android.libraries.navigation.internal.yz.ev;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class v implements com.google.android.libraries.navigation.internal.gg.e {
    final /* synthetic */ x a;
    final /* synthetic */ w b;

    public v(w wVar, x xVar) {
        this.a = xVar;
        this.b = wVar;
    }

    @Override // com.google.android.libraries.navigation.internal.gg.e
    public final void a(com.google.android.libraries.navigation.internal.gg.i iVar, com.google.android.libraries.navigation.internal.gg.o oVar) {
        if (oVar.equals(com.google.android.libraries.navigation.internal.gg.o.b) || oVar.equals(com.google.android.libraries.navigation.internal.gg.o.d) || oVar.equals(com.google.android.libraries.navigation.internal.gg.o.k)) {
            bz bzVar = ((com.google.android.libraries.navigation.internal.adi.aj) iVar.a).c;
        }
        this.b.d(this.a, oVar);
        w wVar = this.b;
        com.google.android.libraries.navigation.internal.qm.a.a(wVar.c, w.a(this.a), iVar, oVar.e());
        w wVar2 = this.b;
        wVar2.a.add(oVar.e());
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.libraries.navigation.internal.gg.e
    public final /* bridge */ /* synthetic */ void b(com.google.android.libraries.navigation.internal.gg.i iVar, Object obj) {
        ax axVar = (ax) obj;
        new ArrayList();
        try {
            x xVar = this.a;
            ar.g(axVar.b.size() == ((ab) xVar).a.size(), "The received painted region list does not contain same number of painted regions as expected. Expected: (%s) Received: (%s)", ((ab) xVar).a.size(), axVar.b.size());
            ArrayList<ao> arrayList = new ArrayList();
            for (int i = 0; i < axVar.b.size(); i++) {
                av avVar = (av) axVar.b.get(i);
                int iB = au.b(avVar.c);
                if (iB == 0) {
                    iB = au.a;
                }
                int i2 = iB;
                if (i2 == au.c || i2 == au.d) {
                    int iB2 = au.b(avVar.c);
                    if (iB2 == 0) {
                        iB2 = au.a;
                    }
                    au.a(iB2);
                    if (iB2 == 0) {
                        throw null;
                    }
                    ((ab) xVar).a.get(i);
                }
                com.google.android.libraries.navigation.internal.adi.aj ajVar = ((ab) xVar).b;
                if (ajVar == null) {
                    throw new IllegalArgumentException("A paint request template not found for given tile type: ".concat(String.valueOf(((ab) xVar).f.name())));
                }
                arrayList.add(new ao((aa) ((ab) xVar).a.get(i), new ac(avVar, i2, ((ab) xVar).e, ((ab) xVar).d, ev.o(ajVar.j))));
            }
            w wVar = this.b;
            for (ao aoVar : arrayList) {
                aa aaVar = (aa) aoVar.a;
                final ac acVar = (ac) aoVar.b;
                Iterator it2 = wVar.b(aaVar.h()).iterator();
                while (it2.hasNext()) {
                    final com.google.android.libraries.navigation.internal.qu.t tVar = (com.google.android.libraries.navigation.internal.qu.t) ((aa) it2.next()).d();
                    com.google.android.libraries.navigation.internal.qu.aa aaVar2 = tVar.b;
                    final bq bqVar = tVar.a;
                    aaVar2.l.execute(new Runnable() { // from class: com.google.android.libraries.navigation.internal.qu.s
                        @Override // java.lang.Runnable
                        public final void run() throws Throwable {
                            tVar.b(bqVar, acVar);
                        }
                    });
                }
            }
            com.google.android.libraries.navigation.internal.qm.a.a(this.b.c, w.a(this.a), iVar, aq.SUCCESS);
            this.b.a.add(aq.SUCCESS);
        } catch (IllegalArgumentException e) {
            ((com.google.android.libraries.navigation.internal.zb.h) com.google.android.libraries.navigation.internal.zb.j.b.F((char) 1111)).p("Received error in parsing the Paint tile response. Error:");
            w wVar2 = this.b;
            x xVar2 = this.a;
            com.google.android.libraries.navigation.internal.gg.o oVarB = com.google.android.libraries.navigation.internal.gg.o.b(e);
            wVar2.d(xVar2, oVarB);
            com.google.android.libraries.navigation.internal.qm.a.a(this.b.c, w.a(this.a), iVar, oVarB.e());
            this.b.a.add(oVarB.e());
        }
    }
}
