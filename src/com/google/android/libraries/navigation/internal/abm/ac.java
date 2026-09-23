package com.google.android.libraries.navigation.internal.abm;

import com.google.android.libraries.navigation.internal.adg.ef;
import com.google.android.libraries.navigation.internal.yz.fy;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class ac implements com.google.android.libraries.navigation.internal.ol.x {
    public static final int[] a = {0, 10, 30};
    List b;
    private final dl c;
    private final Executor d;
    private boolean e;
    private boolean f;
    private final Set g;

    public ac(dl dlVar) {
        com.google.android.libraries.navigation.internal.abf.ah.a();
        this.e = false;
        this.f = false;
        this.g = new HashSet();
        this.b = new ArrayList();
        this.c = dlVar;
        this.d = com.google.android.libraries.navigation.internal.abf.ah.a();
    }

    static boolean e(com.google.android.libraries.navigation.internal.ol.at atVar) {
        if (!(atVar.b() instanceof com.google.android.libraries.navigation.internal.ol.o)) {
            return false;
        }
        int i = ((ef) atVar.b().n()).f186n;
        return i == 2147483645 || i == 2147483646;
    }

    private final synchronized com.google.android.libraries.navigation.internal.ol.at g(List list, com.google.android.libraries.navigation.internal.oe.x xVar) {
        y yVar;
        ArrayList<y> arrayList = new ArrayList();
        Iterator it2 = list.iterator();
        while (it2.hasNext()) {
            com.google.android.libraries.navigation.internal.ol.at atVar = (com.google.android.libraries.navigation.internal.ol.at) it2.next();
            if (e(atVar)) {
                arrayList.add(new y(atVar));
            }
        }
        com.google.android.libraries.navigation.internal.abf.s.c(!arrayList.isEmpty());
        Collections.sort(arrayList, y.a);
        Collections.sort(this.b, y.a);
        if (this.b.size() == arrayList.size()) {
            int i = 0;
            while (true) {
                if (i >= this.b.size()) {
                    for (int i2 = 0; i2 < arrayList.size(); i2++) {
                        ((y) arrayList.get(i2)).e = ((y) this.b.get(i2)).e;
                    }
                    break;
                }
                if (!((y) this.b.get(i)).d.equals(((y) arrayList.get(i)).d)) {
                    break;
                }
                i++;
            }
        }
        this.b = arrayList;
        for (y yVar2 : arrayList) {
            yVar2.h = xVar.i(yVar2.g);
        }
        Collections.sort(this.b, y.b);
        int i3 = 0;
        while (true) {
            if (i3 >= this.b.size()) {
                yVar = null;
                break;
            }
            yVar = (y) this.b.get(i3);
            if (!yVar.e) {
                break;
            }
            i3++;
        }
        if (yVar == null) {
            Iterator it3 = this.b.iterator();
            while (it3.hasNext()) {
                ((y) it3.next()).e = false;
            }
            Iterator it4 = list.iterator();
            while (it4.hasNext()) {
                com.google.android.libraries.navigation.internal.ol.at atVar2 = (com.google.android.libraries.navigation.internal.ol.at) it4.next();
                if (!e(atVar2)) {
                    return atVar2;
                }
            }
            yVar = (y) this.b.get(0);
        }
        yVar.e = true;
        return yVar.c;
    }

    @Override // com.google.android.libraries.navigation.internal.ol.x
    public final com.google.android.libraries.navigation.internal.ol.at a(List list, com.google.android.libraries.navigation.internal.oe.x xVar) {
        boolean z;
        int iA;
        ArrayList arrayList = new ArrayList(list);
        new HashSet();
        synchronized (this) {
            z = this.e;
        }
        com.google.android.libraries.navigation.internal.afu.d.a.a().I();
        int i = 0;
        while (i < arrayList.size()) {
            com.google.android.libraries.navigation.internal.ol.at atVar = (com.google.android.libraries.navigation.internal.ol.at) arrayList.get(i);
            com.google.android.libraries.navigation.internal.ol.au auVarB = atVar.b();
            if ((!z && !(auVarB instanceof com.google.android.libraries.navigation.internal.ol.v)) || (!e(atVar) && (iA = atVar.a()) >= 0 && a[iA] > 10)) {
                arrayList.remove(i);
                i--;
            }
            i++;
        }
        com.google.android.libraries.navigation.internal.ol.at atVar2 = arrayList.isEmpty() ? null : (com.google.android.libraries.navigation.internal.ol.at) arrayList.get(0);
        if (atVar2 != null && ((!(atVar2.b() instanceof com.google.android.libraries.navigation.internal.ol.o) || ((ef) atVar2.b().n()).f186n != Integer.MAX_VALUE) && atVar2.a() != -1)) {
            Executor executor = this.d;
            final dl dlVar = this.c;
            Objects.requireNonNull(dlVar);
            executor.execute(new Runnable() { // from class: com.google.android.libraries.navigation.internal.abm.ab
                @Override // java.lang.Runnable
                public final void run() {
                    dlVar.k();
                }
            });
        }
        if (atVar2 != null && e(atVar2)) {
            return g(arrayList, xVar);
        }
        b();
        return atVar2;
    }

    final synchronized void b() {
        this.b.clear();
    }

    public final synchronized void c(boolean z) {
        this.f = z;
    }

    public final synchronized void d(boolean z) {
        this.e = z;
    }

    final synchronized void f() {
        fy.o(this.g);
    }
}
