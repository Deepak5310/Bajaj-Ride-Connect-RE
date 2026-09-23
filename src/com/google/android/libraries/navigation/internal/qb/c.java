package com.google.android.libraries.navigation.internal.qb;

import com.google.android.libraries.navigation.internal.oe.ay;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class c {
    public final com.google.android.libraries.navigation.internal.qa.a a;
    public final com.google.android.libraries.navigation.internal.qa.a b;
    private final int e;
    public final List c = new ArrayList();
    private final List d = new ArrayList();
    private final a f = new a();

    public c(com.google.android.libraries.navigation.internal.qa.a aVar, com.google.android.libraries.navigation.internal.qa.a aVar2) {
        this.a = aVar;
        this.b = aVar2;
        int iCeil = (int) Math.ceil(aVar.b() / 350.0f);
        int iCeil2 = (int) Math.ceil(aVar.a() / 250.0f);
        this.e = iCeil;
        for (int i = 0; i < iCeil * iCeil2; i++) {
            this.c.add(null);
            this.d.add(null);
        }
    }

    private final void c(com.google.android.libraries.navigation.internal.qa.b bVar) {
        ay ayVar;
        ay ayVar2 = bVar.e;
        float f = ayVar2.b;
        float fMin = ayVar2.c;
        float fMax = f;
        float fMin2 = fMax;
        float fMax2 = fMin;
        for (int i = 1; i < 4; i++) {
            if (i == 0) {
                ayVar = bVar.e;
            } else if (i == 1) {
                ayVar = bVar.f;
            } else if (i == 2) {
                ayVar = bVar.g;
            } else {
                if (i != 3) {
                    throw new ArrayIndexOutOfBoundsException();
                }
                ayVar = bVar.h;
            }
            float f2 = ayVar.b;
            fMin2 = Math.min(f2, fMin2);
            float f3 = ayVar.c;
            fMin = Math.min(f3, fMin);
            fMax = Math.max(f2, fMax);
            fMax2 = Math.max(f3, fMax2);
        }
        com.google.android.libraries.navigation.internal.qa.a aVar = this.a;
        float f4 = aVar.a;
        float f5 = aVar.b;
        float f6 = fMin - f5;
        float f7 = fMax2 - f5;
        a aVar2 = this.f;
        aVar2.a = (int) Math.max(0.0d, Math.floor((fMin2 - f4) / 350.0f));
        aVar2.c = (int) Math.min(this.e, Math.ceil((fMax - f4) / 350.0f));
        aVar2.b = (int) Math.max(0.0d, Math.floor(f6 / 250.0f));
        aVar2.d = (int) Math.min(((double) this.c.size()) / ((double) this.e), Math.ceil(f7 / 250.0f));
    }

    public final boolean a(d dVar, f fVar, int i) {
        if (!this.a.e(dVar.b.a)) {
            return false;
        }
        c(dVar.b);
        if (!b(dVar, fVar, i)) {
            return false;
        }
        int i2 = this.f.a;
        while (true) {
            a aVar = this.f;
            if (i2 >= aVar.c) {
                return true;
            }
            for (int i3 = aVar.b; i3 < this.f.d; i3++) {
                if (i - 1 != 1) {
                    b bVar = (b) this.c.get((this.e * i3) + i2);
                    if (bVar == null) {
                        bVar = new b();
                        this.c.set((this.e * i3) + i2, bVar);
                    }
                    bVar.a(dVar);
                } else {
                    b bVar2 = (b) this.d.get((this.e * i3) + i2);
                    if (bVar2 == null) {
                        bVar2 = new b();
                        this.d.set((this.e * i3) + i2, bVar2);
                    }
                    bVar2.a(dVar);
                }
            }
            i2++;
        }
    }

    public final boolean b(d dVar, f fVar, int i) {
        b bVar;
        if (!this.a.e(dVar.b.a)) {
            return false;
        }
        c(dVar.b);
        int i2 = this.f.a;
        while (true) {
            a aVar = this.f;
            if (i2 >= aVar.c) {
                return true;
            }
            for (int i3 = aVar.b; i3 < this.f.d; i3++) {
                b bVar2 = (b) this.c.get((this.e * i3) + i2);
                if (bVar2 != null && bVar2.b(dVar, fVar)) {
                    return false;
                }
                if (i == 2 && (bVar = (b) this.d.get((this.e * i3) + i2)) != null && bVar.b(dVar, fVar)) {
                    return false;
                }
            }
            i2++;
        }
    }
}
