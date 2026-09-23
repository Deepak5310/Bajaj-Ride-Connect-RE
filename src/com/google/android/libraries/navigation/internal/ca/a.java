package com.google.android.libraries.navigation.internal.ca;

import com.google.android.libraries.navigation.internal.adr.Cif;
import com.google.android.libraries.navigation.internal.adr.bk;
import com.google.android.libraries.navigation.internal.adr.bm;
import com.google.android.libraries.navigation.internal.adr.dx;
import com.google.android.libraries.navigation.internal.adr.eg;
import com.google.android.libraries.navigation.internal.adr.ej;
import com.google.android.libraries.navigation.internal.adr.el;
import com.google.android.libraries.navigation.internal.adr.kb;
import com.google.android.libraries.navigation.internal.adr.ki;
import com.google.android.libraries.navigation.internal.ael.bb;
import com.google.android.libraries.navigation.internal.ael.bi;
import com.google.android.libraries.navigation.internal.ael.bz;
import com.google.android.libraries.navigation.internal.ael.dj;
import com.google.android.libraries.navigation.internal.zb.j;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public class a {
    public static final j a = j.e("com.google.android.libraries.navigation.internal.ca.a");

    public static void a(kb kbVar) {
        if (((ki) kbVar.b).h.size() <= 0 || (kbVar.c(0).b & 1) == 0) {
            return;
        }
        Cif cif = kbVar.c(0).c;
        if (cif == null) {
            cif = Cif.a;
        }
        bm bmVar = cif.e;
        if (bmVar == null) {
            bmVar = bm.a;
        }
        int i = bmVar.c;
        List<el> listUnmodifiableList = Collections.unmodifiableList(((ki) kbVar.b).k);
        ArrayList arrayList = new ArrayList();
        for (el elVar : listUnmodifiableList) {
            if (elVar.c == 31) {
                bm bmVar2 = ((ej) elVar.d).c;
                if (bmVar2 == null) {
                    bmVar2 = bm.a;
                }
                bb bbVar = (bb) bmVar2.aH(5, null);
                bbVar.x(bmVar2);
                bk bkVar = (bk) bbVar;
                int i2 = ((bm) bkVar.b).c - i;
                if (i2 > 0) {
                    if (!bkVar.b.H()) {
                        bkVar.v();
                    }
                    bm bmVar3 = (bm) bkVar.b;
                    bmVar3.b |= 1;
                    bmVar3.c = i2;
                    ej ejVar = elVar.c == 31 ? (ej) elVar.d : ej.a;
                    bb bbVar2 = (bb) ejVar.aH(5, null);
                    bbVar2.x(ejVar);
                    eg egVar = (eg) bbVar2;
                    if (!egVar.b.H()) {
                        egVar.v();
                    }
                    ej ejVar2 = (ej) egVar.b;
                    bm bmVar4 = (bm) bkVar.t();
                    bmVar4.getClass();
                    ejVar2.c = bmVar4;
                    ejVar2.b |= 1;
                    ej ejVar3 = (ej) egVar.t();
                    bb bbVar3 = (bb) elVar.aH(5, null);
                    bbVar3.x(elVar);
                    dx dxVar = (dx) bbVar3;
                    if (!dxVar.b.H()) {
                        dxVar.v();
                    }
                    el elVar2 = (el) dxVar.b;
                    ejVar3.getClass();
                    elVar2.d = ejVar3;
                    elVar2.c = 31;
                    arrayList.add(dxVar.t());
                }
            }
        }
        if (!kbVar.b.H()) {
            kbVar.v();
        }
        ((ki) kbVar.b).k = dj.b;
        if (!kbVar.b.H()) {
            kbVar.v();
        }
        ki kiVar = (ki) kbVar.b;
        bz bzVar = kiVar.k;
        if (!bzVar.c()) {
            kiVar.k = bi.A(bzVar);
        }
        com.google.android.libraries.navigation.internal.ael.b.m(arrayList, kiVar.k);
    }
}
