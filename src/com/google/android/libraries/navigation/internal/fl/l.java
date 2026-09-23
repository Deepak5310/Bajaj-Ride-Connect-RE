package com.google.android.libraries.navigation.internal.fl;

import com.google.android.libraries.navigation.internal.adi.ak;
import com.google.android.libraries.navigation.internal.adi.al;
import com.google.android.libraries.navigation.internal.adi.an;
import com.google.android.libraries.navigation.internal.adi.ar;
import com.google.android.libraries.navigation.internal.ael.bs;
import com.google.android.libraries.navigation.internal.afl.bc;
import com.google.android.libraries.navigation.internal.afl.no;
import com.google.android.libraries.navigation.internal.oe.aw;
import com.google.android.libraries.navigation.internal.yx.aq;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class l implements aw {
    private final com.google.android.libraries.navigation.internal.agl.a a;

    public l(com.google.android.libraries.navigation.internal.agl.a aVar) {
        this.a = aVar;
    }

    private final List g() {
        ar arVar = ((com.google.android.libraries.navigation.internal.om.p) this.a.a()).f().c;
        if (arVar == null) {
            arVar = ar.a;
        }
        return arVar.c;
    }

    public final long a(an anVar) {
        for (al alVar : g()) {
            if ((alVar.b & 8) != 0) {
                an anVarB = an.b(alVar.c);
                if (anVarB == null) {
                    anVarB = an.UNKNOWN;
                }
                if (anVarB == anVar) {
                    if (alVar.h != -1) {
                        return TimeUnit.SECONDS.toMillis(alVar.h);
                    }
                    return -1L;
                }
            }
        }
        no noVar = ((com.google.android.libraries.navigation.internal.om.h) ((com.google.android.libraries.navigation.internal.om.p) this.a.a()).e()).c;
        if (!new bs(noVar.d, no.a).contains(anVar)) {
            for (bc bcVar : noVar.e) {
                if (new bs(bcVar.d, bc.a).contains(anVar)) {
                    return TimeUnit.SECONDS.toMillis(bcVar.c);
                }
            }
            return TimeUnit.SECONDS.toMillis(noVar.c);
        }
        return -1L;
    }

    @Override // com.google.android.libraries.navigation.internal.oe.aw
    public final long b(an anVar, com.google.android.libraries.navigation.internal.mj.a aVar) {
        long epochMilli = aVar.f().toEpochMilli();
        long jA = a(anVar);
        if (jA == -1) {
            return -1L;
        }
        return ((com.google.android.libraries.navigation.internal.gz.a) aVar).a + ((epochMilli + jA) - aVar.f().toEpochMilli());
    }

    @Override // com.google.android.libraries.navigation.internal.oe.aw
    public final long c(an anVar, com.google.android.libraries.navigation.internal.mj.a aVar) {
        throw null;
    }

    @Override // com.google.android.libraries.navigation.internal.oe.aw
    public final long d(an anVar, com.google.android.libraries.navigation.internal.mj.a aVar) {
        return -1L;
    }

    @Override // com.google.android.libraries.navigation.internal.oe.aw
    public final String e(an anVar) {
        al alVar;
        an anVarB;
        Iterator it2 = g().iterator();
        do {
            if (!it2.hasNext()) {
                ak akVar = (ak) al.a.q();
                if (!akVar.b.H()) {
                    akVar.v();
                }
                al alVar2 = (al) akVar.b;
                alVar2.c = anVar.ah;
                alVar2.b |= 1;
                alVar = (al) akVar.t();
                break;
            }
            alVar = (al) it2.next();
            anVarB = an.b(alVar.c);
            if (anVarB == null) {
                anVarB = an.UNKNOWN;
            }
        } while (!anVarB.equals(anVar));
        String strA = alVar.k;
        if (aq.c(strA)) {
            strA = com.google.android.libraries.navigation.internal.yx.c.a(anVar.name());
            if (strA.startsWith("gmm_")) {
                return strA.replaceFirst("gmm_", "");
            }
        }
        return strA;
    }

    @Override // com.google.android.libraries.navigation.internal.oe.aw
    public final boolean f(an anVar) {
        return false;
    }
}
