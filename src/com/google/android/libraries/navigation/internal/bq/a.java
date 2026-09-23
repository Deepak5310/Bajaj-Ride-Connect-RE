package com.google.android.libraries.navigation.internal.bq;

import com.google.android.libraries.navigation.internal.bp.ay;
import com.google.android.libraries.navigation.internal.oe.ak;
import com.google.android.libraries.navigation.internal.oe.al;
import com.google.android.libraries.navigation.internal.oe.r;
import com.google.android.libraries.navigation.internal.oe.t;
import com.google.android.libraries.navigation.internal.oe.x;
import com.google.android.libraries.navigation.internal.yx.ar;
import com.google.android.libraries.navigation.internal.yz.ev;
import com.google.android.libraries.navigation.internal.yz.lv;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class a {
    public final ev a;
    public final al b;

    /* JADX WARN: Multi-variable type inference failed */
    public a(ev evVar, ev evVar2, int i) {
        this.a = evVar;
        al alVar = null;
        ak akVar = new ak(null);
        int i2 = ((lv) evVar2).c;
        boolean z = true;
        int i3 = 0;
        while (i3 < i2) {
            akVar.a((r) evVar2.get(i3));
            i3++;
            z = false;
        }
        int size = evVar.size();
        for (int i4 = 0; i4 < size; i4++) {
            ay ayVar = (ay) evVar.get(i4);
            t tVarF = i == -1 ? ayVar.f() : ayVar.g();
            if (tVarF != null) {
                akVar.a(tVarF.a);
                akVar.a(tVarF.b);
                z = false;
            }
        }
        if (!z) {
            ar.l(akVar.b != Integer.MAX_VALUE, "No points included");
            ar.k(akVar.c != Integer.MIN_VALUE);
            ar.k(akVar.d != Integer.MIN_VALUE);
            ar.k(akVar.e != Integer.MAX_VALUE);
            x xVar = new x((akVar.b + akVar.c) / 2, (akVar.e + akVar.d) / 2);
            xVar.U(-akVar.a);
            alVar = new al(xVar, akVar.c - akVar.b, akVar.d - akVar.e, (float) Math.toDegrees(akVar.a));
        }
        this.b = alVar;
    }
}
