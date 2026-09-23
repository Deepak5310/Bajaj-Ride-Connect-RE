package com.google.android.libraries.navigation.internal.qp;

import com.google.android.libraries.navigation.internal.adi.an;
import com.google.android.libraries.navigation.internal.ael.bz;
import com.google.android.libraries.navigation.internal.yx.ar;
import com.google.android.libraries.navigation.internal.yz.ev;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Set;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class ab implements x {
    public final ev a;
    public final com.google.android.libraries.navigation.internal.adi.aj b;
    public final ev c;
    public final String d;
    public final String e;
    public final an f;

    /* JADX WARN: Code duplicated, block: B:23:0x006f A[EDGE_INSN: B:23:0x006f->B:39:0x00b3 BREAK  A[LOOP:1: B:31:0x0095->B:57:0x0095]] */
    public ab(List list, ev evVar, z zVar, com.google.android.libraries.navigation.internal.fu.a aVar) {
        bz bzVar;
        com.google.android.libraries.navigation.internal.adi.aj ajVar;
        com.google.android.libraries.navigation.internal.adi.al alVar;
        com.google.android.libraries.navigation.internal.adi.al alVar2;
        an anVarB;
        ar.b(!list.isEmpty(), "No tile requests specified when creating a batch request");
        this.a = ev.o(list);
        this.c = evVar;
        an anVarE = ((aa) list.get(0)).e();
        this.f = anVarE;
        com.google.android.libraries.navigation.internal.ox.f fVar = zVar.c;
        if (fVar == null) {
            com.google.android.libraries.navigation.internal.adi.ar arVar = ((com.google.android.libraries.navigation.internal.om.p) zVar.a.a()).f().c;
            bzVar = (arVar == null ? com.google.android.libraries.navigation.internal.adi.ar.a : arVar).c;
        } else {
            com.google.android.libraries.navigation.internal.adi.ar arVar2 = fVar.a().c;
            bzVar = (arVar2 == null ? com.google.android.libraries.navigation.internal.adi.ar.a : arVar2).c;
        }
        Iterator it2 = bzVar.iterator();
        do {
            ajVar = null;
            if (!it2.hasNext()) {
                alVar = null;
                break;
            }
            alVar = (com.google.android.libraries.navigation.internal.adi.al) it2.next();
            anVarB = an.b(alVar.c);
            if (anVarB == null) {
                anVarB = an.UNKNOWN;
            }
        } while (anVarB != anVarE);
        String str = ((com.google.android.libraries.geo.mapcore.internal.model.b) zVar.b).f61n;
        if (str == null) {
            alVar2 = null;
            break;
        }
        Set set = (Set) ((com.google.android.libraries.navigation.internal.om.p) zVar.a.a()).d().b.get(str);
        ArrayList arrayList = set == null ? null : new ArrayList(set);
        if (arrayList != null) {
            Iterator it3 = arrayList.iterator();
            while (true) {
                if (!it3.hasNext()) {
                    alVar2 = null;
                    break;
                }
                alVar2 = (com.google.android.libraries.navigation.internal.adi.al) it3.next();
                an anVarB2 = an.b(alVar2.c);
                if ((anVarB2 == null ? an.UNKNOWN : anVarB2) == anVarE && (alVar2.b & 2) != 0) {
                    break;
                }
            }
        } else {
            alVar2 = null;
            break;
        }
        alVar = alVar2 != null ? alVar2 : alVar;
        if (alVar != null && (ajVar = alVar.d) == null) {
            ajVar = com.google.android.libraries.navigation.internal.adi.aj.a;
        }
        this.b = ajVar;
        this.d = Locale.getDefault().toLanguageTag();
        this.e = aVar.b();
    }
}
