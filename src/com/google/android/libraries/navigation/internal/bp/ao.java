package com.google.android.libraries.navigation.internal.bp;

import com.google.android.libraries.navigation.internal.adr.gv;
import com.google.android.libraries.navigation.internal.adr.ii;
import com.google.android.libraries.navigation.internal.yz.gs;
import com.google.android.libraries.navigation.internal.yz.lg;
import com.google.android.libraries.navigation.internal.yz.lo;
import com.google.android.libraries.navigation.internal.yz.md;
import j$.time.Duration;
import java.util.Arrays;
import java.util.Objects;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class ao {
    public volatile am[] a;

    public ao(am[] amVarArr) {
        this.a = amVarArr;
    }

    public static ao b(bq[] bqVarArr) {
        int length;
        int length2 = bqVarArr.length;
        if (length2 == 0) {
            return null;
        }
        int[] iArr = new int[length2];
        Duration[] durationArr = new Duration[length2];
        int i = 0;
        int i2 = 0;
        while (true) {
            length = bqVarArr.length;
            if (i >= length) {
                break;
            }
            i2 += bqVarArr[i].l;
            iArr[i] = i2;
            i++;
        }
        Duration durationPlus = Duration.ZERO;
        for (int i3 = length - 1; i3 >= 0; i3--) {
            durationArr[i3] = durationPlus;
            durationPlus = durationPlus.plus(bqVarArr[i3].f355n);
        }
        am[] amVarArr = new am[bqVarArr.length];
        for (int i4 = 0; i4 < bqVarArr.length; i4++) {
            amVarArr[i4] = new am(iArr[i4], durationArr[i4], false);
        }
        return new ao(amVarArr);
    }

    public static am[] d(ii iiVar, int i) {
        com.google.android.libraries.navigation.internal.yx.ar.a(iiVar.c.size() >= 2);
        com.google.android.libraries.navigation.internal.ael.bz bzVar = iiVar.c;
        long j = ((gv) bzVar.get(0)).d;
        int size = bzVar.size();
        int i2 = j > 0 ? 1 : 0;
        am[] amVarArr = new am[size + i2];
        long j2 = ((gv) gs.d(bzVar)).d;
        if (i2 > 0) {
            amVarArr[0] = new am(i, Duration.ofSeconds(j2), true);
        }
        for (int i3 = 0; i3 < bzVar.size(); i3++) {
            amVarArr[i3 + i2] = new am(((gv) bzVar.get(i3)).c, Duration.ofSeconds(j2 - ((gv) bzVar.get(i3)).d), true);
        }
        return amVarArr;
    }

    private final Comparable e(final an anVar, Comparable comparable, an anVar2) {
        boolean zE = anVar.e();
        lo loVar = lg.a;
        if (!zE) {
            loVar = md.a;
        }
        am[] amVarArr = this.a;
        am amVarB = anVar.b(comparable);
        Objects.requireNonNull(anVar);
        int iBinarySearch = Arrays.binarySearch(amVarArr, amVarB, new com.google.android.libraries.navigation.internal.yz.ba(new com.google.android.libraries.navigation.internal.yx.aa() { // from class: com.google.android.libraries.navigation.internal.bp.aj
            @Override // com.google.android.libraries.navigation.internal.yx.aa
            public final Object ak(Object obj) {
                return anVar.c((am) obj);
            }
        }, loVar));
        if (iBinarySearch >= 0) {
            am amVar = this.a[iBinarySearch];
            if (anVar.c(amVar).compareTo(comparable) == 0) {
                return anVar2.c(amVar);
            }
            do {
                iBinarySearch++;
                if (iBinarySearch >= this.a.length) {
                    break;
                }
            } while (loVar.compare(anVar.c(this.a[iBinarySearch]), comparable) < 0);
            iBinarySearch = (-iBinarySearch) - 1;
        }
        if (iBinarySearch == -1) {
            return anVar2.c(this.a[0]);
        }
        int i = -(iBinarySearch + 1);
        int i2 = i - 1;
        if (i2 >= this.a.length - 1) {
            return anVar2.c(this.a[this.a.length - 1]);
        }
        return anVar2.d(anVar2.c(this.a[i2]), anVar2.c(this.a[i]), anVar.a(anVar.c(this.a[i2]), anVar.c(this.a[i]), comparable));
    }

    public final double a(Duration duration) {
        return ((Double) e(al.a, duration, ak.a)).doubleValue();
    }

    public final Duration c(double d) {
        return (Duration) e(ak.a, Double.valueOf(d), al.a);
    }
}
