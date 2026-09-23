package com.google.android.libraries.geo.mapcore.internal.model;

import java.util.PriorityQueue;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes2.dex */
public final class bp {
    public final bm[] a;
    public int b;
    public final com.google.android.libraries.navigation.internal.oe.ad c;

    public bp(com.google.android.libraries.navigation.internal.oe.ad adVar) {
        int i;
        this.c = adVar;
        int iE = adVar.e();
        int i2 = iE + 7;
        this.b = 1;
        int i3 = 1;
        while (true) {
            i = i2 >> 3;
            if (i3 >= i) {
                break;
            }
            this.b++;
            i3 += i3;
        }
        this.a = new bm[d(this.b - 1) + i];
        com.google.android.libraries.navigation.internal.oe.x xVar = new com.google.android.libraries.navigation.internal.oe.x();
        int iD = d(this.b - 1) - 1;
        for (int i4 = 0; i4 < iE; i4++) {
            adVar.u(i4, xVar);
            if (i4 > 0) {
                this.a[iD].a(xVar.a, xVar.b);
            }
            if ((i4 & 7) == 0) {
                iD++;
                this.a[iD] = new bm(xVar);
            }
        }
        for (int i5 = this.b - 2; i5 >= 0; i5--) {
            int i6 = i5 + 1;
            for (int iD2 = d(i5); iD2 < d(i6) && h(c(iD2)); iD2++) {
                bm[] bmVarArr = this.a;
                bmVarArr[iD2] = new bm(bmVarArr[c(iD2)]);
                if (!h(e(iD2))) {
                    break;
                }
                bm[] bmVarArr2 = this.a;
                bm bmVar = bmVarArr2[iD2];
                bm bmVar2 = bmVarArr2[e(iD2)];
                bmVar.a(bmVar2.a, bmVar2.b);
                bmVar.a(bmVar2.c, bmVar2.d);
            }
        }
    }

    public static int c(int i) {
        return i + i + 1;
    }

    public static int d(int i) {
        return (1 << i) - 1;
    }

    public static int e(int i) {
        return i + i + 2;
    }

    public static void g(PriorityQueue priorityQueue, com.google.android.libraries.navigation.internal.oe.x xVar, double d, int i, int i2) {
        bl blVar;
        if (priorityQueue.size() < i2) {
            blVar = new bl();
        } else {
            bl blVar2 = (bl) priorityQueue.peek();
            com.google.android.libraries.navigation.internal.yx.ar.q(blVar2);
            if (blVar2.b <= d) {
                return;
            }
            blVar = (bl) priorityQueue.poll();
            com.google.android.libraries.navigation.internal.yx.ar.q(blVar);
        }
        blVar.a.W(xVar);
        blVar.b = d;
        blVar.c = i;
        priorityQueue.offer(blVar);
    }

    public final int a(int i) {
        return d(this.b - 1);
    }

    public final int b(int i) {
        int iNumberOfTrailingZeros = Integer.numberOfTrailingZeros(Integer.highestOneBit(i + 1));
        return (i - d(iNumberOfTrailingZeros)) << (((this.b + 3) - iNumberOfTrailingZeros) - 1);
    }

    public final com.google.android.libraries.navigation.internal.oe.ag f(com.google.android.libraries.navigation.internal.oe.x xVar, double d, int i) {
        bo boVar = new bo(this, com.google.android.libraries.navigation.internal.oe.ai.h(xVar, (int) (d + 1.0d)), 0, i);
        com.google.android.libraries.navigation.internal.oe.x xVar2 = new com.google.android.libraries.navigation.internal.oe.x();
        com.google.android.libraries.navigation.internal.oe.x xVar3 = new com.google.android.libraries.navigation.internal.oe.x();
        com.google.android.libraries.navigation.internal.oe.x xVar4 = new com.google.android.libraries.navigation.internal.oe.x();
        bl blVar = new bl();
        int i2 = -2;
        while (boVar.hasNext()) {
            int iIntValue = boVar.next().intValue();
            this.c.u(iIntValue, xVar2);
            if (iIntValue - i2 > 1) {
                this.c.u(iIntValue, xVar4);
                if (!boVar.hasNext()) {
                    double dH = xVar.h(xVar2);
                    if (dH > d || dH >= blVar.b) {
                        break;
                        break;
                    }
                    blVar.a.W(xVar2);
                    blVar.b = dH;
                    blVar.c = iIntValue;
                    break;
                }
            } else {
                double dJ = com.google.android.libraries.navigation.internal.oe.x.j(xVar4, xVar2, xVar, xVar3);
                if (dJ <= d && dJ < blVar.b) {
                    blVar.a.W(xVar3);
                    blVar.b = dJ;
                    if (true == xVar3.equals(xVar2)) {
                        i2 = iIntValue;
                    }
                    blVar.c = i2;
                }
                xVar4.W(xVar2);
            }
            i2 = iIntValue;
        }
        if (blVar.c >= 0) {
            return blVar.a(this.c, i, xVar4, xVar2);
        }
        return null;
    }

    public final boolean h(int i) {
        bm[] bmVarArr = this.a;
        return i < bmVarArr.length && bmVarArr[i] != null;
    }
}
