package com.google.android.libraries.navigation.internal.lv;

import android.content.Context;
import android.os.Looper;
import com.google.android.libraries.navigation.internal.le.ao;
import com.google.android.libraries.navigation.internal.le.aq;
import com.google.android.libraries.navigation.internal.le.ar;
import com.google.android.libraries.navigation.internal.le.bb;
import com.google.android.libraries.navigation.internal.le.bd;
import com.google.android.libraries.navigation.internal.lh.be;
import java.util.Objects;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class x extends com.google.android.libraries.navigation.internal.ld.o implements com.google.android.libraries.navigation.internal.lu.m {
    static final com.google.android.libraries.navigation.internal.ld.j a;
    public static final com.google.android.libraries.navigation.internal.ld.k l;

    static {
        com.google.android.libraries.navigation.internal.ld.j jVar = new com.google.android.libraries.navigation.internal.ld.j();
        a = jVar;
        l = new com.google.android.libraries.navigation.internal.ld.k("LocationServices.API", new u(), jVar);
    }

    public x(Context context) {
        super(context, l, com.google.android.libraries.navigation.internal.ld.g.a, com.google.android.libraries.navigation.internal.ld.n.a);
    }

    @Override // com.google.android.libraries.navigation.internal.lu.m
    public final void a(com.google.android.libraries.navigation.internal.lu.x xVar) {
        i(ar.a(xVar, "x"), 2418).a(new r(), new com.google.android.libraries.navigation.internal.me.e() { // from class: com.google.android.libraries.navigation.internal.lv.n
            @Override // com.google.android.libraries.navigation.internal.me.e
            public final Object a(com.google.android.libraries.navigation.internal.me.w wVar) {
                return null;
            }
        });
    }

    @Override // com.google.android.libraries.navigation.internal.lu.m
    public final void b(final com.google.android.libraries.navigation.internal.lu.z zVar, com.google.android.libraries.navigation.internal.lu.x xVar, Looper looper) {
        if (looper == null) {
            looper = Looper.myLooper();
            be.k(looper, "invalid null looper");
        }
        aq aqVarB = ar.b(xVar, looper, "x");
        final w wVar = new w(this, aqVarB, new v() { // from class: com.google.android.libraries.navigation.internal.lv.s
            @Override // com.google.android.libraries.navigation.internal.lv.v
            public final void a(ah ahVar, ao aoVar, boolean z, com.google.android.libraries.navigation.internal.me.aa aaVar) {
                synchronized (ahVar.t) {
                    ag agVar = (ag) ahVar.t.remove(aoVar);
                    if (agVar == null) {
                        aaVar.b(Boolean.FALSE);
                        return;
                    }
                    agVar.a.b().a();
                    if (!z) {
                        aaVar.b(Boolean.TRUE);
                    } else if (ahVar.G(com.google.android.libraries.navigation.internal.lu.l.j)) {
                        ((l) ahVar.u()).g(ai.a(null, agVar, "ILocationCallback@" + System.identityHashCode(agVar)), new z(Boolean.TRUE, aaVar));
                    } else {
                        ((l) ahVar.u()).i(new am(2, null, null, agVar, null, new aa(Boolean.TRUE, aaVar), null));
                    }
                }
            }
        });
        bd bdVar = new bd() { // from class: com.google.android.libraries.navigation.internal.lv.t
            @Override // com.google.android.libraries.navigation.internal.le.bd
            public final void a(Object obj, Object obj2) {
                ag agVar;
                w wVar2 = wVar;
                ah ahVar = (ah) obj;
                aq aqVarB2 = wVar2.b();
                ao aoVar = (ao) Objects.requireNonNull(aqVarB2.b);
                boolean zG = ahVar.G(com.google.android.libraries.navigation.internal.lu.l.j);
                synchronized (ahVar.t) {
                    ag agVar2 = (ag) ahVar.t.get(aoVar);
                    if (agVar2 == null || zG) {
                        ag agVar3 = new ag(wVar2);
                        ahVar.t.put(aoVar, agVar3);
                        agVar = agVar3;
                    } else {
                        agVar2.a.c(aqVarB2);
                        agVar = agVar2;
                        agVar2 = null;
                    }
                    com.google.android.libraries.navigation.internal.lu.z zVar2 = zVar;
                    if (zG) {
                        ((l) ahVar.u()).e(ai.a(agVar2, agVar, aoVar.a()), zVar2, new z(null, (com.google.android.libraries.navigation.internal.me.aa) obj2));
                    } else {
                        ((l) ahVar.u()).i(new am(1, new ak(zVar2, null, false, false, false, false, Long.MAX_VALUE), null, agVar, null, new y((com.google.android.libraries.navigation.internal.me.aa) obj2, agVar), aoVar.a()));
                    }
                }
            }
        };
        bb bbVar = new bb();
        bbVar.a = bdVar;
        bbVar.b = wVar;
        bbVar.c = aqVarB;
        bbVar.f = 2436;
        h(bbVar.a());
    }
}
