package com.google.android.libraries.navigation.internal.uu;

import com.google.android.libraries.navigation.SpeedAlertSeverity;
import com.google.android.libraries.navigation.environment.cs;
import com.google.android.libraries.navigation.internal.adr.bm;
import com.google.android.libraries.navigation.internal.ady.al;
import com.google.android.libraries.navigation.internal.yx.an;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class o implements k {
    final /* synthetic */ q a;

    public o(q qVar) {
        this.a = qVar;
    }

    @Override // com.google.android.libraries.navigation.internal.uu.k
    public final void a() {
        this.a.f629n = true;
    }

    @Override // com.google.android.libraries.navigation.internal.uu.k
    public final void b(float f) {
        q qVar;
        int i;
        q qVar2 = this.a;
        r rVar = qVar2.d;
        bm.a aVar = this.a.f;
        bm.a aVar2 = bm.a.KILOMETERS;
        int i2 = qVar2.h;
        cs csVar = (cs) rVar;
        Float f2 = (Float) csVar.a.get(SpeedAlertSeverity.MINOR);
        boolean zG = csVar.b.g();
        float f3 = f * (aVar == aVar2 ? 3.6f : 2.2369363f);
        if (zG && f2 != null) {
            float fA = com.google.android.libraries.navigation.internal.xf.q.a(f2.floatValue(), i2);
            if (i2 != -1 && !csVar.c.g() && f3 >= fA) {
                csVar.c = an.j(Long.valueOf(csVar.d.a()));
            } else if (csVar.c.g() && (f3 < fA || i2 == -1)) {
                csVar.c = com.google.android.libraries.navigation.internal.yx.a.a;
            }
        }
        int i3 = (int) f3;
        q qVar3 = this.a;
        if (i3 == qVar3.i) {
            return;
        }
        if (qVar3.x.o().booleanValue() && this.a.x.k().booleanValue() && (((i = (qVar = this.a).i) < 100 && i3 >= 100) || (i >= 100 && i3 < 100))) {
            qVar.p = true;
        }
        q qVar4 = this.a;
        qVar4.i = i3;
        qVar4.e.b();
    }

    @Override // com.google.android.libraries.navigation.internal.uu.k
    public final void c() {
        q qVar = this.a;
        ((cs) qVar.d).c = com.google.android.libraries.navigation.internal.yx.a.a;
        if (qVar.i == -1) {
            return;
        }
        if (qVar.x.o().booleanValue() && this.a.x.k().booleanValue()) {
            q qVar2 = this.a;
            if (qVar2.i >= 100) {
                qVar2.p = true;
            }
        }
        q qVar3 = this.a;
        qVar3.i = -1;
        qVar3.e.b();
    }

    @Override // com.google.android.libraries.navigation.internal.uu.k
    public final void d(al alVar) {
        this.a.g = alVar;
    }

    @Override // com.google.android.libraries.navigation.internal.uu.k
    public final void e(int i) {
        q qVar = this.a;
        int i2 = qVar.y;
        if (i2 == 0) {
            throw null;
        }
        if (i2 == i) {
            return;
        }
        qVar.y = i;
        qVar.a();
        this.a.e.b();
    }

    @Override // com.google.android.libraries.navigation.internal.uu.k
    public final void f(int i, bm.a aVar) {
        boolean z = false;
        if (aVar != null && !this.a.f.equals(aVar)) {
            this.a.f = aVar;
            z = true;
        }
        q qVar = this.a;
        if (qVar.h != i) {
            qVar.h = i;
        } else if (!z) {
            return;
        }
        if (i == -1) {
            qVar.a();
            this.a.b();
            return;
        }
        qVar.e.c();
        this.a.a();
        this.a.b();
        this.a.e.b();
        this.a.e.a();
    }
}
