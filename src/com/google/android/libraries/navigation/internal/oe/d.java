package com.google.android.libraries.navigation.internal.oe;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class d {
    private aj b;
    private int c;
    private x[] d;
    private boolean e;
    private int h;
    public boolean a = false;
    private final List f = new ArrayList();
    private final List g = new ArrayList();

    public d(aj ajVar) {
        int i = 0;
        this.b = ajVar;
        ajVar.c();
        this.c = 4;
        this.d = new x[4];
        while (true) {
            x[] xVarArr = this.d;
            if (i >= xVarArr.length) {
                return;
            }
            xVarArr[i] = new x();
            i++;
        }
    }

    private final void c(int i, x xVar, long j, boolean z, float f) {
        x xVarJ;
        x xVarJ2;
        boolean z2;
        if (i == this.c) {
            if (z) {
                if (this.h == this.f.size()) {
                    this.f.add(new ab(16, 0, 0, 0));
                    this.g.add(new c());
                }
                this.h++;
            }
            ab abVar = (ab) this.f.get(this.h - 1);
            if (abVar.c(xVar) && this.e) {
                c cVar = (c) this.g.get(this.h - 1);
                int i2 = cVar.b;
                long[] jArr = cVar.a;
                int length = jArr.length;
                if (i2 == length) {
                    cVar.a = Arrays.copyOf(jArr, length + length);
                }
                long[] jArr2 = cVar.a;
                int i3 = cVar.b;
                cVar.b = i3 + 1;
                jArr2[i3] = j;
            }
            if (z) {
                abVar.b = f;
                return;
            }
            return;
        }
        if (i == 0) {
            xVarJ = this.b.g();
            xVarJ2 = this.b.j(0);
        } else {
            xVarJ = this.b.j(i - 1);
            xVarJ2 = this.b.j(i);
        }
        if (y.e(xVarJ, xVarJ2, xVar) >= 0) {
            int i4 = i + 1;
            if (z) {
                z2 = true;
            } else {
                if (y.e(xVarJ, xVarJ2, this.d[i]) < 0) {
                    x xVar2 = new x();
                    y.h(xVarJ, xVarJ2, xVar, this.d[i], xVar2);
                    c(i4, xVar2, j, true, f - xVar.h(xVar2));
                }
                z2 = false;
            }
            c(i4, xVar, j, z2, f);
        } else if (!z && y.e(xVarJ, xVarJ2, this.d[i]) >= 0) {
            x xVar3 = new x();
            y.h(xVarJ, xVarJ2, this.d[i], xVar, xVar3);
            c(i + 1, xVar3, j, false, f - xVar.h(xVar3));
        }
        this.d[i].W(xVar);
    }

    public final void a(ad adVar, List list) {
        b(adVar, null, list, null);
    }

    public final void b(ad adVar, long[] jArr, List list, List list2) {
        this.h = 0;
        this.e = (jArr == null || list2 == null) ? false : true;
        ai aiVarP = adVar.p();
        if (this.b.b(aiVarP)) {
            if (this.b.l(aiVarP)) {
                if (this.a) {
                    ad adVarO = ad.o(adVar, 0, adVar.e());
                    adVarO.f = 0.0f;
                    list.add(adVarO);
                } else {
                    list.add(adVar);
                }
                if (jArr == null || list2 == null) {
                    return;
                }
                list2.add(jArr);
                return;
            }
            x xVar = new x();
            x xVar2 = new x();
            adVar.u(0, xVar);
            adVar.u(0, xVar2);
            float fH = !this.a ? adVar.f : 0.0f;
            c(0, xVar, (jArr == null || list2 == null) ? 0L : jArr[0], true, fH);
            for (int i = 1; i < adVar.e(); i++) {
                adVar.u(i, xVar);
                fH += xVar.h(xVar2);
                adVar.u(i, xVar2);
                c(0, xVar, (jArr == null || list2 == null) ? 0L : jArr[i], false, fH);
            }
            for (int i2 = 0; i2 < this.h; i2++) {
                ab abVar = (ab) this.f.get(i2);
                if (abVar.a > 1) {
                    ad adVarA = abVar.a();
                    if (this.a) {
                        adVarA.f = 0.0f;
                    }
                    list.add(adVarA);
                }
                abVar.b();
                if (jArr != null && list2 != null) {
                    c cVar = (c) this.g.get(i2);
                    int i3 = cVar.b;
                    if (i3 > 1) {
                        list2.add(Arrays.copyOf(cVar.a, i3));
                    }
                    cVar.b = 0;
                }
            }
        }
    }
}
