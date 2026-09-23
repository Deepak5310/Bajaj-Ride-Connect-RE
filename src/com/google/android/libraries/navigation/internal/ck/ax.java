package com.google.android.libraries.navigation.internal.ck;

import com.google.android.libraries.navigation.internal.yz.lg;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public abstract class ax implements cm {
    private static final com.google.android.libraries.navigation.internal.zb.j a = com.google.android.libraries.navigation.internal.zb.j.e("com.google.android.libraries.navigation.internal.ck.ax");

    protected double a(com.google.android.libraries.navigation.internal.zk.e eVar, com.google.android.libraries.navigation.internal.zk.e eVar2) {
        return eVar2.c(eVar).a * 6367000.0d;
    }

    protected final List b(List list) {
        ArrayList arrayList = new ArrayList(list.size());
        arrayList.add(0);
        com.google.android.libraries.navigation.internal.zk.e eVarE = com.google.android.libraries.navigation.internal.zk.e.e(((com.google.android.libraries.navigation.internal.oe.x) list.get(0)).p(), ((com.google.android.libraries.navigation.internal.oe.x) list.get(0)).r());
        int i = 1;
        double dA = 0.0d;
        while (i < list.size()) {
            com.google.android.libraries.navigation.internal.zk.e eVarE2 = com.google.android.libraries.navigation.internal.zk.e.e(((com.google.android.libraries.navigation.internal.oe.x) list.get(i)).p(), ((com.google.android.libraries.navigation.internal.oe.x) list.get(i)).r());
            dA += a(eVarE, eVarE2);
            arrayList.add(Integer.valueOf(Math.round((float) dA)));
            i++;
            eVarE = eVarE2;
        }
        return arrayList;
    }

    protected abstract List c(be beVar, boolean z, boolean z2);

    protected final void d(be beVar, boolean z, List list, List list2, List list3, List list4) {
        List list5 = list3;
        List list6 = list4;
        List list7 = beVar.m;
        List listB = b(list7);
        int i = 0;
        int i2 = 1;
        com.google.android.libraries.navigation.internal.yx.ar.k(list7.size() == listB.size());
        lg lgVar = lg.a;
        Iterator it2 = listB.iterator();
        if (it2.hasNext()) {
            Object next = it2.next();
            while (it2.hasNext()) {
                Object next2 = it2.next();
                if (lgVar.compare(next, next2) > 0) {
                    ((com.google.android.libraries.navigation.internal.zb.h) a.d(com.google.android.libraries.navigation.internal.nl.a.a).F('t')).p("The polyline point offsets are not ordered.");
                    break;
                }
                next = next2;
            }
        }
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(c(beVar, beVar.f, z));
        lg lgVar2 = lg.a;
        Iterator it3 = arrayList.iterator();
        if (it3.hasNext()) {
            Object next3 = it3.next();
            while (it3.hasNext()) {
                Object next4 = it3.next();
                if (lgVar2.compare(next3, next4) >= 0) {
                    ((com.google.android.libraries.navigation.internal.zb.h) a.d(com.google.android.libraries.navigation.internal.nl.a.a).F('s')).p("The polyline style offsets are not strictly ordered.");
                    break;
                }
                next3 = next4;
            }
        }
        List list8 = beVar.m;
        list.addAll(list8);
        LinkedList linkedList = new LinkedList(arrayList);
        aw awVar = (aw) linkedList.poll();
        if (awVar == null) {
            ((com.google.android.libraries.navigation.internal.zb.h) a.d(com.google.android.libraries.navigation.internal.nl.a.a).F('r')).p("There should be at least one offset/style pair for a road stretch polyline.");
        } else {
            list5.add(awVar.a);
            list6.add(awVar.b);
        }
        while (i2 < listB.size()) {
            int iIntValue = ((Integer) listB.get(i2)).intValue();
            aw awVar2 = (aw) linkedList.peek();
            while (awVar2 != null && awVar2.c <= iIntValue) {
                linkedList.poll();
                if (i2 != listB.size() - 1 || awVar2.c != iIntValue) {
                    list5.add(awVar2.a);
                    list6.add(awVar2.b);
                    list2.add(Integer.valueOf(i2 + i));
                }
                if (awVar2.c != iIntValue) {
                    int i3 = i2 + i;
                    int i4 = i2 - 1;
                    com.google.android.libraries.navigation.internal.oe.x xVar = (com.google.android.libraries.navigation.internal.oe.x) list8.get(i4);
                    com.google.android.libraries.navigation.internal.oe.x xVar2 = (com.google.android.libraries.navigation.internal.oe.x) list8.get(i2);
                    int i5 = awVar2.c;
                    double dIntValue = ((Integer) listB.get(i4)).intValue();
                    double dIntValue2 = ((Integer) listB.get(i2)).intValue();
                    double d = dIntValue2 - dIntValue;
                    Double dValueOf = Double.valueOf(dIntValue);
                    Double dValueOf2 = Double.valueOf(dIntValue2);
                    if (d <= 0.0d) {
                        throw new IllegalStateException(com.google.android.libraries.navigation.internal.yx.bq.a("Polyline point offsets are invalid: (A: %s, B: %s)", dValueOf, dValueOf2));
                    }
                    list.add(i3, xVar.B(xVar2, (float) ((((double) i5) - dIntValue) / d)));
                    i++;
                }
                awVar2 = (aw) linkedList.peek();
                list8 = list8;
                iIntValue = iIntValue;
                list5 = list3;
                list6 = list4;
            }
            i2++;
            list8 = list8;
            list5 = list3;
            list6 = list4;
        }
    }
}
