package com.google.android.libraries.navigation.internal.bp;

import com.google.android.libraries.navigation.internal.adr.Cif;
import com.google.android.libraries.navigation.internal.adr.dc;
import com.google.android.libraries.navigation.internal.adr.fy;
import com.google.android.libraries.navigation.internal.adr.gj;
import com.google.android.libraries.navigation.internal.adr.ib;
import com.google.android.libraries.navigation.internal.adr.ii;
import com.google.android.libraries.navigation.internal.adr.ki;
import com.google.android.libraries.navigation.internal.adr.kk;
import com.google.android.libraries.navigation.internal.adr.km;
import com.google.android.libraries.navigation.internal.yz.ev;
import com.google.android.libraries.navigation.internal.yz.fd;
import com.google.android.libraries.navigation.internal.yz.ma;
import java.util.HashMap;
import java.util.Iterator;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class cf {
    public final ki a;
    public final av[] b;
    public final bl c;
    private final boolean d;

    public cf(ki kiVar, boolean z) {
        Cif cif;
        fd fdVarJ;
        this.a = kiVar;
        this.d = z;
        this.b = new av[kiVar.h.size()];
        int i = 0;
        while (true) {
            av[] avVarArr = this.b;
            if (i >= avVarArr.length) {
                break;
            }
            avVarArr[i] = new av((gj) kiVar.h.get(i));
            i++;
        }
        if (kiVar.h.size() > 1) {
            cif = ((gj) kiVar.h.get(0)).c;
            if (cif == null) {
                cif = Cif.a;
            }
        } else {
            cif = kiVar.g;
            if (cif == null) {
                cif = Cif.a;
            }
        }
        com.google.android.libraries.navigation.internal.adr.cm cmVar = cif.i;
        cmVar = cmVar == null ? com.google.android.libraries.navigation.internal.adr.cm.a : cmVar;
        com.google.android.libraries.navigation.internal.ael.bz bzVar = cmVar.j;
        com.google.android.libraries.navigation.internal.ael.bz bzVar2 = cmVar.k;
        com.google.android.libraries.navigation.internal.ael.bz<com.google.android.libraries.navigation.internal.adr.cl> bzVar3 = cmVar.l;
        ev evVarO = ev.o(bzVar);
        ev evVarO2 = ev.o(bzVar2);
        HashMap map = new HashMap();
        for (com.google.android.libraries.navigation.internal.adr.cl clVar : bzVar3) {
            String str = clVar.b;
            if (str.isEmpty()) {
                fdVarJ = ma.b;
            } else if (map.containsKey(str)) {
                fdVarJ = ma.b;
            } else {
                map.put(str, ev.o(clVar.c));
            }
            this.c = new n(evVarO, evVarO2, fdVarJ);
        }
        fdVarJ = fd.j(map);
        this.c = new n(evVarO, evVarO2, fdVarJ);
    }

    final int a() {
        return this.a.l;
    }

    public final int b() {
        return this.b.length;
    }

    public final av c(int i) {
        return this.b[i];
    }

    public final dc d() {
        dc dcVar = this.a.y;
        return dcVar == null ? dc.a : dcVar;
    }

    public final fy e() {
        fy fyVarB = fy.b(this.a.e);
        return fyVarB == null ? fy.SUMMARY : fyVarB;
    }

    public final Cif f() {
        Cif cif = this.a.g;
        return cif == null ? Cif.a : cif;
    }

    public final ii g() {
        ii iiVar = this.a.i;
        return iiVar == null ? ii.a : iiVar;
    }

    public final String h() {
        return this.a.A;
    }

    public final String i() {
        String[] strArr = new String[this.b.length];
        int i = 0;
        while (true) {
            av[] avVarArr = this.b;
            if (i >= avVarArr.length) {
                com.google.android.libraries.navigation.internal.yx.ak akVarE = com.google.android.libraries.navigation.internal.yx.al.b(this).e("isOfflineRoute", this.d);
                akVarE.g("paths", strArr);
                return akVarE.toString();
            }
            av avVar = avVarArr[i];
            com.google.android.libraries.navigation.internal.yx.ak akVarC = com.google.android.libraries.navigation.internal.yx.al.b(avVar).c("#stepGroups", avVar.a());
            int size = 0;
            for (int i2 = 0; i2 < avVar.a.e.size(); i2++) {
                size += ((ib) avVar.a.e.get(i2)).d.size();
            }
            strArr[i] = akVarC.c("#steps", size).toString();
            i++;
        }
    }

    final boolean j() {
        return (this.a.b & 512) != 0;
    }

    public final boolean k(int i) {
        Iterator it2 = this.a.w.iterator();
        while (it2.hasNext()) {
            int iA = kk.a(((km) it2.next()).b);
            if (iA == 0) {
                iA = kk.a;
            }
            if (iA == i) {
                return true;
            }
        }
        return false;
    }
}
