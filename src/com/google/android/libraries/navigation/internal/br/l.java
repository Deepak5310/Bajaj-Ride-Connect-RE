package com.google.android.libraries.navigation.internal.br;

import com.google.android.libraries.navigation.internal.adr.ah;
import com.google.android.libraries.navigation.internal.adr.el;
import com.google.android.libraries.navigation.internal.adr.fh;
import com.google.android.libraries.navigation.internal.adr.fn;
import com.google.android.libraries.navigation.internal.yx.aa;
import com.google.android.libraries.navigation.internal.yz.ba;
import com.google.android.libraries.navigation.internal.yz.da;
import com.google.android.libraries.navigation.internal.yz.ez;
import com.google.android.libraries.navigation.internal.yz.fw;
import com.google.android.libraries.navigation.internal.yz.fy;
import com.google.android.libraries.navigation.internal.yz.hp;
import com.google.android.libraries.navigation.internal.yz.lg;
import com.google.android.libraries.navigation.internal.yz.lo;
import com.google.android.libraries.navigation.internal.yz.me;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class l {
    public static final lo a;
    private static final com.google.android.libraries.navigation.internal.zb.j b = com.google.android.libraries.navigation.internal.zb.j.e("com.google.android.libraries.navigation.internal.br.l");
    private static final lo c = new ba(new aa() { // from class: com.google.android.libraries.navigation.internal.br.h
        @Override // com.google.android.libraries.navigation.internal.yx.aa
        public final Object ak(Object obj) {
            el elVar = (el) obj;
            return Double.valueOf((elVar.c == 25 ? (fn) elVar.d : fn.a).e);
        }
    }, lg.a);

    static {
        int i = 0;
        hp hpVar = new hp(el.a.INFORMATION, new el.a[]{el.a.WARNING, el.a.ALERT, el.a.CRITICAL});
        ez ezVar = new ez(hpVar.size());
        Iterator<E> it2 = hpVar.iterator();
        while (it2.hasNext()) {
            ezVar.f(it2.next(), Integer.valueOf(i));
            i++;
        }
        a = new da(ezVar.d());
        ez ezVar2 = new ez();
        ezVar2.f(com.google.android.libraries.navigation.internal.az.d.DESCENDING_IMPORTANCE, new me(c));
        ezVar2.f(com.google.android.libraries.navigation.internal.az.d.DESCENDING_SEVERITY, new Comparator() { // from class: com.google.android.libraries.navigation.internal.br.i
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                el elVar = (el) obj2;
                me meVar = new me(l.a);
                el.a aVarB = el.a.b(((el) obj).f);
                if (aVarB == null) {
                    aVarB = el.a.INFORMATION;
                }
                el.a aVarB2 = el.a.b(elVar.f);
                if (aVarB2 == null) {
                    aVarB2 = el.a.INFORMATION;
                }
                return meVar.compare(aVarB, aVarB2);
            }
        });
        ezVar2.d();
    }

    public static k a(ah ahVar) {
        c cVar = new c();
        cVar.a = g.c(ahVar, g.a, com.google.android.libraries.navigation.internal.ady.u.a);
        cVar.b = g.c(ahVar, g.a, com.google.android.libraries.navigation.internal.ady.u.d);
        return cVar.a();
    }

    public static k b(ah ahVar) {
        c cVar = new c();
        cVar.a = g.c(ahVar, g.b, com.google.android.libraries.navigation.internal.ady.u.e);
        cVar.b = g.c(ahVar, g.b, com.google.android.libraries.navigation.internal.ady.u.f);
        return cVar.a();
    }

    public static fy c(el elVar) {
        fw fwVar = new fw();
        for (String str : (elVar.c == 22 ? (fh) elVar.d : fh.a).j) {
            try {
                fwVar.c(Long.valueOf(com.google.android.libraries.navigation.internal.zy.p.b(str)));
            } catch (NumberFormatException unused) {
                ((com.google.android.libraries.navigation.internal.zb.h) b.d(com.google.android.libraries.navigation.internal.nl.a.a).F(83)).s("Non-numeric incident id %s", str);
            }
        }
        return fwVar.i();
    }

    public static String d(el elVar, boolean z) {
        String strC;
        ah ahVar = elVar.w;
        if (ahVar == null) {
            ahVar = ah.a;
        }
        return (!z || (strC = g.c(ahVar, g.a, com.google.android.libraries.navigation.internal.ady.u.d)) == null) ? g.c(ahVar, g.a, com.google.android.libraries.navigation.internal.ady.u.a) : strC;
    }

    public static String e(el elVar) {
        return s.b(elVar.f221n);
    }

    public static String f(el elVar) {
        return s.b(elVar.p);
    }

    public static List g(el elVar) {
        ArrayList arrayList = new ArrayList();
        if ((elVar.b & 65536) != 0) {
            ah ahVar = elVar.v;
            if (ahVar == null) {
                ahVar = ah.a;
            }
            g.b(arrayList, ahVar);
        }
        if ((elVar.b & 131072) != 0) {
            ah ahVar2 = elVar.w;
            if (ahVar2 == null) {
                ahVar2 = ah.a;
            }
            g.b(arrayList, ahVar2);
        }
        return arrayList;
    }
}
