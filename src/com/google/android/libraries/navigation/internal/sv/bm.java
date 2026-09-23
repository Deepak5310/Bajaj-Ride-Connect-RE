package com.google.android.libraries.navigation.internal.sv;

import com.google.android.libraries.navigation.internal.adr.Cdo;
import com.google.android.libraries.navigation.internal.adr.el;
import com.google.android.libraries.navigation.internal.adr.ex;
import com.google.android.libraries.navigation.internal.adr.fh;
import com.google.android.libraries.navigation.internal.adr.ii;
import com.google.android.libraries.navigation.internal.yz.fd;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class bm {
    private final List a = new ArrayList();
    private final com.google.android.libraries.navigation.internal.yx.as b;
    private final fd c;
    private ii d;
    private final com.google.android.libraries.navigation.internal.dx.a e;

    public bm(com.google.android.libraries.navigation.internal.yx.as asVar, fd fdVar, com.google.android.libraries.navigation.internal.dx.a aVar) {
        this.b = asVar;
        this.c = fdVar;
        this.e = aVar;
    }

    public final el a(com.google.android.libraries.navigation.internal.bp.bg bgVar, double d) {
        ii iiVar;
        ii iiVar2 = bgVar.u;
        if (iiVar2 != null && ((iiVar = this.d) == null || !iiVar.equals(iiVar2))) {
            this.d = iiVar2;
            this.a.clear();
            for (el elVar : iiVar2.g) {
                Cdo cdoB = Cdo.b(elVar.u);
                if (cdoB == null) {
                    cdoB = Cdo.INCIDENT_OTHER;
                }
                if (cdoB != Cdo.INCIDENT_POLICE_PRESENCE) {
                    Cdo cdoB2 = Cdo.b(elVar.u);
                    if (cdoB2 == null) {
                        cdoB2 = Cdo.INCIDENT_OTHER;
                    }
                    if (cdoB2 != Cdo.INCIDENT_MOBILE_SPEED_CAMERA) {
                        ex exVar = (elVar.c == 22 ? (fh) elVar.d : fh.a).i;
                        if (exVar == null) {
                            exVar = ex.a;
                        }
                        if (exVar.c > d && this.b.a(elVar)) {
                            this.a.add(elVar);
                        }
                    }
                }
            }
        }
        if (this.a.isEmpty()) {
            return null;
        }
        int iB = (int) com.google.android.libraries.navigation.internal.ja.a.b(bgVar.L(d));
        ListIterator listIterator = this.a.listIterator();
        while (listIterator.hasNext()) {
            el elVar2 = (el) listIterator.next();
            Cdo cdoB3 = Cdo.b(elVar2.u);
            if (cdoB3 == null) {
                cdoB3 = Cdo.INCIDENT_OTHER;
            }
            ex exVar2 = (elVar2.c == 22 ? (fh) elVar2.d : fh.a).i;
            if (exVar2 == null) {
                exVar2 = ex.a;
            }
            int iB2 = iB - ((int) com.google.android.libraries.navigation.internal.ja.a.b(bgVar.L(exVar2.c)));
            if (this.c.containsKey(cdoB3) && iB2 <= ((Integer) this.c.get(cdoB3)).intValue()) {
                listIterator.remove();
                if (iB2 > 0) {
                    return elVar2;
                }
            }
        }
        return null;
    }
}
