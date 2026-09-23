package com.google.android.libraries.navigation.internal.cp;

import com.google.android.libraries.navigation.internal.ace.hi;
import com.google.android.libraries.navigation.internal.ace.hj;
import com.google.android.libraries.navigation.internal.ace.hk;
import com.google.android.libraries.navigation.internal.ace.hl;
import com.google.android.libraries.navigation.internal.ace.hm;
import com.google.android.libraries.navigation.internal.adr.Cdo;
import com.google.android.libraries.navigation.internal.adr.el;
import com.google.android.libraries.navigation.internal.adr.ex;
import com.google.android.libraries.navigation.internal.adr.fh;
import com.google.android.libraries.navigation.internal.bp.bg;
import com.google.android.libraries.navigation.internal.yx.an;
import j$.time.Duration;
import java.util.Iterator;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class a implements com.google.android.libraries.navigation.internal.cn.o {
    private final com.google.android.libraries.navigation.internal.hn.r a;

    public a(com.google.android.libraries.navigation.internal.hn.r rVar) {
        this.a = rVar;
    }

    @Override // com.google.android.libraries.navigation.internal.cn.o
    public final Boolean a(el elVar, Integer num, bg bgVar, boolean z) {
        an anVarJ;
        Cdo cdoB = Cdo.b(elVar.u);
        if (cdoB == null) {
            cdoB = Cdo.INCIDENT_OTHER;
        }
        hl hlVar = ((hm) this.a.b()).d;
        if (hlVar == null) {
            hlVar = hl.a;
        }
        Iterator it2 = hlVar.b.iterator();
        while (true) {
            if (!it2.hasNext()) {
                anVarJ = com.google.android.libraries.navigation.internal.yx.a.a;
                break;
            }
            hk hkVar = (hk) it2.next();
            Cdo cdoB2 = Cdo.b(hkVar.c);
            if (cdoB2 == null) {
                cdoB2 = Cdo.INCIDENT_ROAD_CLOSED;
            }
            if (cdoB2 == cdoB) {
                anVarJ = an.j(hkVar);
                break;
            }
        }
        if (!anVarJ.g()) {
            int i = elVar.u;
            return false;
        }
        hk hkVar2 = (hk) anVarJ.e(hk.a);
        for (hj hjVar : hkVar2.e) {
            int iA = hi.a(hjVar.b);
            if (iA == 0) {
                iA = hi.a;
            }
            int i2 = iA - 1;
            if (iA == 0) {
                throw null;
            }
            if (i2 == 1) {
                if (z) {
                    return true;
                }
            } else if (i2 != 2) {
                int i3 = hjVar.b;
            } else if (!z) {
                return true;
            }
        }
        if (bgVar == null) {
            return true;
        }
        if (z && (hkVar2.b & 2) != 0) {
            ex exVar = (elVar.c == 22 ? (fh) elVar.d : fh.a).i;
            if (exVar == null) {
                exVar = ex.a;
            }
            if ((exVar.b & 1) != 0) {
                ex exVar2 = (elVar.c == 22 ? (fh) elVar.d : fh.a).i;
                if (exVar2 == null) {
                    exVar2 = ex.a;
                }
                double d = exVar2.c;
                if (d <= num.intValue()) {
                    return false;
                }
                if (bgVar.K(num.intValue(), d).compareTo(Duration.ofSeconds(hkVar2.d)) > 0) {
                    return true;
                }
            }
        }
        return false;
    }
}
