package com.google.android.libraries.navigation.internal.cl;

import com.google.android.libraries.navigation.internal.yz.ev;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class ay implements Iterator {
    public final List a = new ArrayList();
    private int b = 0;
    private int c = 0;
    private int d;
    private final int e;
    private final List f;

    public ay(com.google.android.libraries.navigation.internal.rf.g gVar, com.google.android.libraries.navigation.internal.oe.ad adVar, com.google.android.libraries.navigation.internal.adg.b bVar, ev evVar) {
        com.google.android.libraries.navigation.internal.oe.x xVarL;
        float fH;
        this.f = evVar;
        int iIndexOf = evVar.indexOf(bVar);
        this.e = iIndexOf;
        this.d = iIndexOf;
        com.google.android.libraries.navigation.internal.oe.d dVar = new com.google.android.libraries.navigation.internal.oe.d(new com.google.android.libraries.navigation.internal.oe.l(com.google.android.libraries.navigation.internal.oe.bc.h(gVar.h().a.a)));
        ArrayList arrayList = new ArrayList();
        dVar.a(adVar, arrayList);
        com.google.android.libraries.navigation.internal.oe.ad adVar2 = !arrayList.isEmpty() ? (com.google.android.libraries.navigation.internal.oe.ad) arrayList.get(0) : null;
        if (adVar2 == null || adVar2.e() == 0) {
            return;
        }
        float fA = adVar2.a() / 10.0f;
        com.google.android.libraries.navigation.internal.oe.x xVarL2 = adVar2.l(0);
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(xVarL2);
        int iE = adVar2.e();
        int i = 1;
        loop0: while (true) {
            float f = fA;
            while (true) {
                if (i >= iE || arrayList2.size() >= 10) {
                    break loop0;
                }
                xVarL = adVar2.l(i);
                fH = xVarL2.h(xVarL);
                if (fH < f) {
                    f -= fH;
                    i++;
                    xVarL2 = xVarL;
                }
            }
            xVarL2 = xVarL2.B(xVarL, f / fH);
            arrayList2.add(xVarL2);
        }
        int size = arrayList2.size() / 2;
        for (int i2 = 0; i2 < arrayList2.size(); i2++) {
            int i3 = i2 / 2;
            if ((i2 & 1) != 0) {
                i3 = (-i3) - 1;
            }
            this.a.add((com.google.android.libraries.navigation.internal.oe.x) arrayList2.get(i3 + size));
        }
    }

    @Override // java.util.Iterator
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public final ax next() {
        this.b++;
        ax axVar = new ax((com.google.android.libraries.navigation.internal.oe.x) this.a.get(this.c), (com.google.android.libraries.navigation.internal.adg.b) this.f.get(this.d));
        int size = (this.d + 1) % this.f.size();
        this.d = size;
        if (size == this.e && this.c < this.a.size()) {
            this.c++;
        }
        return axVar;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.b < 40 && this.c < this.a.size();
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException();
    }
}
