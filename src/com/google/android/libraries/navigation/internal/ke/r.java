package com.google.android.libraries.navigation.internal.ke;

import com.google.android.libraries.navigation.internal.adq.al;
import com.google.android.libraries.navigation.internal.ael.bb;
import com.google.android.libraries.navigation.internal.afl.pd;
import com.google.android.libraries.navigation.internal.afl.pe;
import com.google.android.libraries.navigation.internal.jy.v;
import com.google.android.libraries.navigation.internal.yx.ak;
import com.google.android.libraries.navigation.internal.yx.am;
import com.google.android.libraries.navigation.internal.zp.bk;
import com.google.android.libraries.navigation.internal.zp.cb;
import com.google.android.libraries.navigation.internal.zp.cf;
import com.google.android.libraries.navigation.internal.zr.ab;
import com.google.android.libraries.navigation.internal.zr.ac;
import com.google.android.libraries.navigation.internal.zr.bh;
import com.google.android.libraries.navigation.internal.zr.bi;
import com.google.android.libraries.navigation.internal.zr.fc;
import com.google.android.libraries.navigation.internal.zr.fd;
import com.google.android.libraries.navigation.internal.zr.fe;
import com.google.android.libraries.navigation.internal.zr.ff;
import com.google.android.libraries.navigation.internal.zt.ap;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class r extends g {
    private final v a;
    private final ap d;
    private final String e;
    private final String f;
    private final cf g;
    private final bk h;
    private final com.google.android.libraries.navigation.internal.zy.n i;
    private final boolean j;

    /* JADX WARN: Illegal instructions before constructor call */
    public r(v vVar, com.google.android.libraries.navigation.internal.jy.j jVar, ap apVar, String str, String str2, cf cfVar, com.google.android.libraries.navigation.internal.zy.n nVar, boolean z, bk bkVar, com.google.android.libraries.navigation.internal.kd.f fVar) {
        long millis = jVar.a.toMillis();
        super(millis, millis, fVar);
        this.a = vVar;
        this.d = apVar;
        this.e = str;
        this.f = str2;
        this.g = cfVar;
        this.i = null;
        this.j = false;
        this.h = bkVar;
    }

    @Override // com.google.android.libraries.navigation.internal.ke.g, com.google.android.libraries.navigation.internal.ke.c
    public final synchronized void b(pd pdVar) {
        super.b(pdVar);
        al alVar = (al) c().t();
        if (!pdVar.b.H()) {
            pdVar.v();
        }
        pe peVar = (pe) pdVar.b;
        pe peVar2 = pe.a;
        alVar.getClass();
        peVar.f = alVar;
        peVar.b |= 4;
    }

    public final synchronized boolean equals(Object obj) {
        boolean z = false;
        if (!(obj instanceof r)) {
            return false;
        }
        r rVar = (r) obj;
        synchronized (rVar) {
            if (am.a(this.a, rVar.a) && am.a(this.d, rVar.d) && am.a(this.e, rVar.e) && am.a(this.f, rVar.f)) {
                rVar.w();
                if (am.a(null, null) && am.a(this.g, rVar.g)) {
                    com.google.android.libraries.navigation.internal.zy.n nVar = rVar.i;
                    if (am.a(null, null)) {
                        boolean z2 = rVar.j;
                        if (am.a(this.h, rVar.h)) {
                            z = true;
                        }
                    }
                }
            }
        }
        return z;
    }

    public final synchronized int hashCode() {
        return Arrays.hashCode(new Object[]{this.a, this.d, this.e, this.f, this.g, null, false, this.h, null});
    }

    @Override // com.google.android.libraries.navigation.internal.ke.c
    public final boolean k() {
        cf cfVar = this.g;
        return cfVar == com.google.android.libraries.navigation.internal.zp.n.aU || cfVar == com.google.android.libraries.navigation.internal.zp.n.aT;
    }

    @Override // com.google.android.libraries.navigation.internal.ke.g
    public final void r(List list) {
        s(list);
    }

    public final String toString() {
        ak akVarB = com.google.android.libraries.navigation.internal.yx.al.b(this);
        akVarB.h();
        akVarB.g("action", this.a);
        ap apVar = this.d;
        akVarB.g("uiState", apVar == null ? null : apVar.toString());
        akVarB.g("contentEi", this.e);
        akVarB.g("contentVed", this.f);
        akVarB.g("dataReference", null);
        akVarB.g("clientLeafVe", this.g);
        akVarB.g("featureFprint", null);
        akVarB.g("isFeatureFprintScrubbed", null);
        return akVarB.toString();
    }

    public final synchronized void w() {
    }

    @Override // com.google.android.libraries.navigation.internal.ke.g
    public final synchronized void y(bh bhVar) {
        super.y(bhVar);
        fc fcVar = (fc) fd.a.q();
        if (!fcVar.b.H()) {
            fcVar.v();
        }
        v vVar = this.a;
        fd fdVar = (fd) fcVar.b;
        fdVar.c = vVar.a.Z;
        fdVar.b |= 2;
        ap apVar = this.d;
        if (apVar != null) {
            if (!fcVar.b.H()) {
                fcVar.v();
            }
            fd fdVar2 = (fd) fcVar.b;
            fdVar2.d = apVar;
            fdVar2.b |= 8;
        }
        String str = this.e;
        if (str != null) {
            if (!fcVar.b.H()) {
                fcVar.v();
            }
            fd fdVar3 = (fd) fcVar.b;
            fdVar3.b |= 16;
            fdVar3.e = str;
        }
        if (this.f != null) {
            fe feVar = (fe) ff.a.q();
            String str2 = this.f;
            if (!feVar.b.H()) {
                feVar.v();
            }
            ff ffVar = (ff) feVar.b;
            str2.getClass();
            ffVar.b |= 2;
            ffVar.c = str2;
            if (!fcVar.b.H()) {
                fcVar.v();
            }
            fd fdVar4 = (fd) fcVar.b;
            ff ffVar2 = (ff) feVar.t();
            ffVar2.getClass();
            fdVar4.f = ffVar2;
            fdVar4.b |= 32;
        }
        cf cfVar = this.g;
        if (cfVar != null) {
            cb cbVarB = com.google.android.libraries.navigation.internal.jw.i.b(cfVar);
            if (!fcVar.b.H()) {
                fcVar.v();
            }
            fd fdVar5 = (fd) fcVar.b;
            cbVarB.getClass();
            fdVar5.g = cbVarB;
            fdVar5.b |= 64;
        }
        bk bkVar = this.h;
        if (bkVar != null) {
            if (!fcVar.b.H()) {
                fcVar.v();
            }
            fd fdVar6 = (fd) fcVar.b;
            fdVar6.j = bkVar;
            fdVar6.b |= 512;
        }
        if (!bhVar.b.H()) {
            bhVar.v();
        }
        bi biVar = (bi) bhVar.b;
        fd fdVar7 = (fd) fcVar.t();
        bi biVar2 = bi.a;
        fdVar7.getClass();
        biVar.k = fdVar7;
        biVar.b |= 4096;
        ac acVar = ((bi) bhVar.b).f;
        if (acVar == null) {
            acVar = ac.a;
        }
        bb bbVar = (bb) acVar.aH(5, null);
        bbVar.x(acVar);
        ab abVar = (ab) bbVar;
        if (!bhVar.b.H()) {
            bhVar.v();
        }
        bi biVar3 = (bi) bhVar.b;
        ac acVar2 = (ac) abVar.t();
        acVar2.getClass();
        biVar3.f = acVar2;
        biVar3.b |= 64;
    }
}
