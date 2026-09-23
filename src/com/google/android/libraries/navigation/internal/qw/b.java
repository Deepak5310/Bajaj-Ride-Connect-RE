package com.google.android.libraries.navigation.internal.qw;

import com.google.android.libraries.geo.mapcore.internal.model.cc;
import com.google.android.libraries.geo.mapcore.internal.model.cd;
import com.google.android.libraries.geo.mapcore.internal.model.cg;
import com.google.android.libraries.geo.mapcore.internal.model.ch;
import com.google.android.libraries.geo.mapcore.internal.model.t;
import com.google.android.libraries.navigation.internal.adi.an;
import com.google.android.libraries.navigation.internal.dm.o;
import com.google.android.libraries.navigation.internal.dm.r;
import com.google.android.libraries.navigation.internal.dm.s;
import com.google.android.libraries.navigation.internal.fq.f;
import com.google.android.libraries.navigation.internal.fq.h;
import com.google.android.libraries.navigation.internal.fq.k;
import com.google.android.libraries.navigation.internal.oe.ap;
import com.google.android.libraries.navigation.internal.oe.as;
import com.google.android.libraries.navigation.internal.qv.g;
import java.lang.ref.SoftReference;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class b implements g {
    private static final cd a = new cd(-1, -1, -1);
    private final t b;
    private final k c;

    public b(f fVar, ap apVar, int i) {
        an anVar = apVar.c;
        this.c = new k(i, h.SOFT_IN_MEMORY_TILE, fVar, com.google.android.libraries.navigation.internal.xn.a.e(anVar));
        r rVar = (r) s.a.q();
        cg cgVar = cg.s;
        cd cdVar = a;
        o oVarA = ch.a(apVar, cgVar, cdVar, "", "");
        if (!rVar.b.H()) {
            rVar.v();
        }
        s sVar = (s) rVar.b;
        oVarA.getClass();
        sVar.c = oVarA;
        sVar.b |= 1;
        this.b = new t((s) rVar.t(), anVar, cdVar, as.UNKNOWN);
    }

    @Override // com.google.android.libraries.navigation.internal.qv.g
    public final cc b(cd cdVar) {
        synchronized (this.c) {
            a aVar = (a) this.c.f(cdVar);
            cc ccVar = null;
            if (aVar == null) {
                return null;
            }
            cc ccVar2 = aVar.b;
            if (ccVar2 != null) {
                ccVar = ccVar2;
            } else {
                SoftReference softReference = aVar.a;
                if (softReference != null) {
                    ccVar = (cc) softReference.get();
                }
            }
            if (ccVar == null) {
                this.c.g(cdVar);
            }
            return ccVar;
        }
    }

    @Override // com.google.android.libraries.navigation.internal.qv.g
    public final void e(cd cdVar, cc ccVar) {
        synchronized (this.c) {
            this.c.m(cdVar, new a(ccVar));
        }
    }

    @Override // com.google.android.libraries.navigation.internal.qv.g
    public final void f(cd cdVar) {
        e(cdVar, this.b);
    }

    @Override // com.google.android.libraries.navigation.internal.qv.g
    public final boolean h(cd cdVar) {
        return b(cdVar) != null;
    }

    @Override // com.google.android.libraries.navigation.internal.qv.g
    public final boolean j(cc ccVar) {
        return ccVar == this.b;
    }

    @Override // com.google.android.libraries.navigation.internal.qv.g
    public final void t() {
        synchronized (this.c) {
            this.c.k();
        }
    }
}
