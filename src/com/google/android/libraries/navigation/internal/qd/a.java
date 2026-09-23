package com.google.android.libraries.navigation.internal.qd;

import com.google.android.libraries.geo.mapcore.internal.model.bk;
import com.google.android.libraries.navigation.internal.oe.ad;
import com.google.android.libraries.navigation.internal.yz.hx;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class a {
    public final ad a;
    public final bk[] b;

    public a(ad adVar) {
        this.a = adVar;
        this.b = null;
    }

    public a(ad adVar, long[] jArr) {
        this.a = adVar;
        this.b = new bk[jArr.length];
        for (int i = 0; i < jArr.length; i++) {
            this.b[i] = new bk(jArr[i]);
        }
    }

    public a(ad adVar, bk[] bkVarArr) {
        this.a = adVar;
        this.b = bkVarArr;
    }

    public final List a(List list) {
        ArrayList arrayListE = hx.e(list.size());
        Iterator it2 = list.iterator();
        int i = 0;
        while (it2.hasNext()) {
            ad adVar = (ad) it2.next();
            int iE = adVar.e() + i;
            bk[] bkVarArr = this.b;
            arrayListE.add(new a(adVar, bkVarArr == null ? null : (bk[]) Arrays.copyOfRange(bkVarArr, i, iE)));
            i = iE - 2;
        }
        return arrayListE;
    }

    final List b(boolean z) {
        ad adVarA = this.a;
        int iE = adVarA.e();
        com.google.android.libraries.navigation.internal.oe.ab abVar = new com.google.android.libraries.navigation.internal.oe.ab(iE);
        abVar.b = adVarA.f;
        com.google.android.libraries.navigation.internal.oe.x xVar = new com.google.android.libraries.navigation.internal.oe.x();
        boolean z2 = false;
        for (int i = 0; i < iE; i++) {
            int i2 = true != z ? -1 : 0;
            adVarA.u(i, xVar);
            if (z) {
                int i3 = xVar.a;
                if (i3 < i2) {
                    xVar.a = i3 + 1073741824;
                    z2 = true;
                }
            } else {
                int i4 = xVar.a;
                if (i4 > i2) {
                    xVar.a = i4 - 1073741824;
                    z2 = true;
                }
            }
            abVar.c(xVar);
        }
        if (z2) {
            adVarA = abVar.a();
        }
        return a(adVarA.r(true != z ? -1073741824 : 0));
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof a) {
            a aVar = (a) obj;
            if (this.a.equals(aVar.a) && Arrays.equals(this.b, aVar.b)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.a, Integer.valueOf(Arrays.hashCode(this.b))});
    }
}
