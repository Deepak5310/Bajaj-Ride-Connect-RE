package com.google.android.libraries.navigation.internal.dy;

import android.content.Context;
import com.google.android.libraries.navigation.internal.ace.nv;
import com.google.android.libraries.navigation.internal.ace.nx;
import com.google.android.libraries.navigation.internal.ace.nz;
import com.google.android.libraries.navigation.internal.ace.oa;
import com.google.android.libraries.navigation.internal.dw.h;
import com.google.android.libraries.navigation.internal.dx.i;
import com.google.android.libraries.navigation.internal.dx.l;
import com.google.android.libraries.navigation.internal.jy.aa;
import com.google.android.libraries.navigation.internal.nc.j;
import com.google.android.libraries.navigation.internal.nc.t;
import com.google.android.libraries.navigation.internal.us.o;
import com.google.android.libraries.navigation.internal.us.p;
import com.google.android.libraries.navigation.internal.yz.eq;
import com.google.android.libraries.navigation.internal.yz.ev;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class b {
    public final o a;
    public final c b;
    public final i c;
    public ev d;
    public String e;
    private final Context f;

    /* JADX INFO: compiled from: PG */
    public interface a {
        b a(c cVar, boolean z, i iVar, Context context);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public b(c cVar, boolean z, i iVar, Context context, o oVar) {
        aa aaVarK;
        aa aaVar;
        this.b = cVar;
        this.a = oVar;
        this.c = iVar;
        this.f = context;
        this.e = context.getString(h.bd);
        int i = ev.d;
        eq eqVar = new eq();
        ev evVarH = iVar.h();
        int size = evVarH.size();
        for (int i2 = 0; i2 < size; i2++) {
            final oa oaVar = (oa) evVarH.get(i2);
            i iVar2 = this.c;
            int iA = nv.a(oaVar.h);
            Integer numQ = iVar2.q(iA == 0 ? nv.a : iA);
            p pVarA = null;
            t tVarM = numQ == null ? null : j.m(numQ.intValue());
            nz nzVarB = nz.b(oaVar.c);
            switch ((nzVarB == null ? nz.UNKNOWN_USER_INCIDENT_TYPE : nzVarB).ordinal()) {
                case 1:
                    aaVarK = aa.k(com.google.android.libraries.navigation.internal.afe.i.k);
                    aaVar = aaVarK;
                    break;
                case 2:
                    aaVarK = aa.k(com.google.android.libraries.navigation.internal.afe.i.o);
                    aaVar = aaVarK;
                    break;
                case 3:
                    aaVarK = aa.k(com.google.android.libraries.navigation.internal.afe.i.s);
                    aaVar = aaVarK;
                    break;
                case 4:
                    aaVarK = aa.k(com.google.android.libraries.navigation.internal.afe.i.p);
                    aaVar = aaVarK;
                    break;
                case 5:
                    aaVarK = aa.k(com.google.android.libraries.navigation.internal.afe.i.j);
                    aaVar = aaVarK;
                    break;
                case 6:
                    aaVarK = aa.k(com.google.android.libraries.navigation.internal.afe.i.q);
                    aaVar = aaVarK;
                    break;
                case 7:
                    aaVarK = aa.k(com.google.android.libraries.navigation.internal.afe.i.x);
                    aaVar = aaVarK;
                    break;
                case 8:
                    aaVarK = aa.k(com.google.android.libraries.navigation.internal.afe.i.u);
                    aaVar = aaVarK;
                    break;
                case 9:
                case 11:
                case 12:
                default:
                    aaVar = null;
                    break;
                case 10:
                    aaVarK = aa.k(com.google.android.libraries.navigation.internal.afe.i.w);
                    aaVar = aaVarK;
                    break;
            }
            if (tVarM != null && aaVar != null) {
                o oVar2 = this.a;
                i iVar3 = this.c;
                com.google.android.libraries.navigation.internal.vg.b bVarG = iVar3.g(oaVar);
                nx nxVarB = nx.b(oaVar.g);
                pVarA = oVar2.a(new com.google.android.libraries.navigation.internal.dx.c(iVar3, bVarG, new l(nxVarB == null ? nx.UNKNOWN_SEVERITY : nxVarB)), false, tVarM, new p.a() { // from class: com.google.android.libraries.navigation.internal.dy.a
                    @Override // com.google.android.libraries.navigation.internal.us.p.a
                    public final void a() {
                        this.a.b.a(oaVar);
                    }
                }, aaVar);
            }
            if (pVarA != null) {
                eqVar.h(pVarA);
            }
        }
        this.d = eqVar.g();
    }
}
