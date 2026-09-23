package com.google.android.libraries.navigation.internal.abl;

import android.graphics.Point;
import android.graphics.Rect;
import com.google.android.libraries.navigation.internal.abh.es;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class m {
    private List a = new ArrayList();
    private final Set b = new HashSet();
    private Point c = null;

    public final es a(List list, float f, float f2) {
        int iRound = Math.round(f);
        int iRound2 = Math.round(f2);
        Point point = this.c;
        if (point == null) {
            this.c = new Point(iRound, iRound2);
        } else {
            int i = iRound - point.x;
            int i2 = iRound2 - this.c.y;
            if ((i * i) + (i2 * i2) > 900) {
                this.c.x = iRound;
                this.c.y = iRound2;
            }
        }
        int i3 = this.c.x;
        int i4 = this.c.y;
        ArrayList arrayList = new ArrayList();
        Iterator it2 = list.iterator();
        while (it2.hasNext()) {
            n nVar = (n) it2.next();
            if (nVar.a.F()) {
                Rect rectC = nVar.c();
                float fExactCenterX = i3 - rectC.exactCenterX();
                float fExactCenterY = i4 - rectC.exactCenterY();
                if ((fExactCenterX * fExactCenterX) + (fExactCenterY * fExactCenterY) < 900.0f) {
                    arrayList.add(nVar);
                }
            }
        }
        List list2 = this.a;
        if (arrayList.size() != list2.size()) {
            this.a = arrayList;
            this.b.clear();
            break;
        }
        for (int i5 = 0; i5 < arrayList.size(); i5++) {
            if (!((n) arrayList.get(i5)).equals(list2.get(i5))) {
                this.a = arrayList;
                this.b.clear();
                break;
            }
        }
        n nVar2 = null;
        if (this.a.isEmpty()) {
            return null;
        }
        float fA = -3.4028235E38f;
        for (n nVar3 : this.a) {
            if (!this.b.contains(nVar3) && Float.compare(nVar3.a(), fA) >= 0.0f) {
                fA = nVar3.a();
                nVar2 = nVar3;
            }
        }
        if (nVar2 == null) {
            this.b.clear();
            return a(list, iRound, iRound2);
        }
        this.b.add(nVar2);
        return nVar2.a;
    }
}
