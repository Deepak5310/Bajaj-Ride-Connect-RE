package com.google.android.libraries.navigation.internal.qq;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class p implements q {
    public final Set a = new HashSet();
    private final float b;
    private final List c;

    public p(float f, com.google.android.libraries.navigation.internal.oe.ad adVar) {
        this.b = f;
        ArrayList arrayList = new ArrayList();
        this.c = arrayList;
        arrayList.add(adVar);
    }

    @Override // com.google.android.libraries.navigation.internal.qq.q
    public final boolean a(x xVar, float f) {
        char c;
        synchronized (this.a) {
            for (int i = 0; i < this.c.size(); i++) {
                if (!this.a.contains(Integer.valueOf(i))) {
                    com.google.android.libraries.navigation.internal.oe.ad adVar = (com.google.android.libraries.navigation.internal.oe.ad) this.c.get(i);
                    float f2 = this.b * f;
                    if (xVar.a != null && adVar.p().f((int) Math.ceil((com.google.android.libraries.navigation.internal.pb.j.c(xVar.c) * f2) / 2.0f)).b(xVar.a)) {
                        float f3 = xVar.f + (f2 / 2.0f);
                        float[] fArr = xVar.e;
                        com.google.android.libraries.navigation.internal.oe.x xVar2 = new com.google.android.libraries.navigation.internal.oe.x(Math.round(fArr[0] * 10.0f), Math.round(fArr[1] * 10.0f));
                        com.google.android.libraries.navigation.internal.oe.x xVar3 = new com.google.android.libraries.navigation.internal.oe.x();
                        com.google.android.libraries.navigation.internal.oe.x xVar4 = new com.google.android.libraries.navigation.internal.oe.x();
                        com.google.android.libraries.navigation.internal.oe.x xVar5 = new com.google.android.libraries.navigation.internal.oe.x();
                        com.google.android.libraries.navigation.internal.oe.x xVar6 = new com.google.android.libraries.navigation.internal.oe.x();
                        boolean z = false;
                        for (int i2 = 0; i2 < adVar.e(); i2++) {
                            adVar.u(i2, xVar4);
                            if (com.google.android.libraries.navigation.internal.pb.j.m(xVar.c, xVar4, xVar.g)) {
                                float[] fArr2 = xVar.g;
                                c = 0;
                                xVar5.J(Math.round(fArr2[0] * 10.0f), Math.round(fArr2[1] * 10.0f));
                                if (z) {
                                    float f4 = f3 * 10.0f;
                                    if (com.google.android.libraries.navigation.internal.oe.x.k(xVar6, xVar5, xVar2, xVar3) <= f4 * f4) {
                                        return true;
                                    }
                                }
                                xVar6.W(xVar5);
                                z = true;
                            } else {
                                c = 0;
                            }
                        }
                    }
                }
            }
            return false;
        }
    }

    public p(float f, List list) {
        this.b = f;
        this.c = list;
    }
}
