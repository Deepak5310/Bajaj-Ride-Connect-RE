package com.google.android.libraries.navigation.internal.qp;

import com.google.android.libraries.geo.mapcore.internal.model.cg;
import com.google.android.libraries.navigation.internal.adi.ao;
import com.google.android.libraries.navigation.internal.adi.ap;
import com.google.android.libraries.navigation.internal.adi.bq;
import com.google.android.libraries.navigation.internal.adi.br;
import com.google.android.libraries.navigation.internal.adi.bs;
import com.google.android.libraries.navigation.internal.adi.bu;
import com.google.android.libraries.navigation.internal.adi.bv;
import com.google.android.libraries.navigation.internal.ael.bb;
import java.util.List;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class g implements y {
    private final String a;

    public g(cg cgVar) {
        this.a = ((com.google.android.libraries.geo.mapcore.internal.model.b) cgVar).m;
    }

    @Override // com.google.android.libraries.navigation.internal.qp.y
    public final void a(com.google.android.libraries.navigation.internal.pt.d dVar, com.google.android.libraries.navigation.internal.adi.ag agVar) {
        if (this.a != null) {
            ap apVar = ((com.google.android.libraries.navigation.internal.adi.aj) agVar.b).e;
            if (apVar == null) {
                apVar = ap.a;
            }
            bb bbVar = (bb) apVar.aH(5, null);
            bbVar.x(apVar);
            ao aoVar = (ao) bbVar;
            bq bqVar = (bq) bv.a.q();
            int i = bu.d;
            if (!bqVar.b.H()) {
                bqVar.v();
            }
            bv bvVar = (bv) bqVar.b;
            if (i == 0) {
                throw null;
            }
            bvVar.c = i;
            bvVar.b |= 1;
            br brVar = (br) bs.a.q();
            if (!brVar.b.H()) {
                brVar.v();
            }
            bs bsVar = (bs) brVar.b;
            bsVar.b |= 1;
            bsVar.c = "styles";
            String str = this.a;
            if (!brVar.b.H()) {
                brVar.v();
            }
            bs bsVar2 = (bs) brVar.b;
            str.getClass();
            bsVar2.b |= 2;
            bsVar2.d = str;
            bqVar.c(brVar);
            aoVar.c(bqVar);
            ap apVar2 = (ap) aoVar.t();
            if (!agVar.b.H()) {
                agVar.v();
            }
            com.google.android.libraries.navigation.internal.adi.aj ajVar = (com.google.android.libraries.navigation.internal.adi.aj) agVar.b;
            apVar2.getClass();
            ajVar.e = apVar2;
            ajVar.b |= 2;
        }
    }

    @Override // com.google.android.libraries.navigation.internal.qp.y
    public final boolean b(List list, aa aaVar) {
        return true;
    }
}
