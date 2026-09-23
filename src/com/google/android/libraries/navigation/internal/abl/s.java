package com.google.android.libraries.navigation.internal.abl;

import com.google.android.libraries.navigation.internal.abh.au;
import com.google.android.libraries.navigation.internal.abh.cq;
import com.google.android.libraries.navigation.internal.abh.cr;
import com.google.android.libraries.navigation.internal.abh.er;
import com.google.android.libraries.navigation.internal.abh.es;
import com.google.android.libraries.navigation.internal.abh.ey;
import com.google.android.libraries.navigation.internal.abh.fn;
import com.google.android.libraries.navigation.internal.abh.fo;
import com.google.android.libraries.navigation.internal.abh.fx;
import com.google.android.libraries.navigation.internal.abh.fy;
import com.google.android.libraries.navigation.internal.abh.fz;
import com.google.android.libraries.navigation.internal.abh.hn;
import com.google.android.libraries.navigation.internal.abh.ho;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class s implements fo, ey {
    public es e;
    public float f;
    public float g;
    public float h;
    public float i;
    private final l l;
    public final List a = Collections.synchronizedList(new ArrayList());
    public final List b = Collections.synchronizedList(new ArrayList());
    public final List c = Collections.synchronizedList(new ArrayList());
    public final m d = new m();
    public final r j = new r();
    public final q k = new q();

    public s(l lVar) {
        this.l = lVar;
    }

    public final es a() {
        if (this.c.size() == 1) {
            return ((n) this.c.get(0)).a;
        }
        return null;
    }

    @Override // com.google.android.libraries.navigation.internal.abh.ey
    public final er b(es esVar) {
        return new n(esVar, this);
    }

    @Override // com.google.android.libraries.navigation.internal.abh.ey
    public final List c() {
        ArrayList arrayList = new ArrayList();
        synchronized (this.c) {
            Iterator it2 = this.c.iterator();
            while (it2.hasNext()) {
                arrayList.add(((n) it2.next()).a);
            }
        }
        return arrayList;
    }

    @Override // com.google.android.libraries.navigation.internal.abh.ey
    public final List d() {
        return c();
    }

    @Override // com.google.android.libraries.navigation.internal.abh.fo
    public final cq e(cr crVar) {
        com.google.android.libraries.navigation.internal.abf.p.b("Ground Overlays");
        return null;
    }

    @Override // com.google.android.libraries.navigation.internal.abh.fo
    public final fn f(au auVar) {
        return new x(auVar, this);
    }

    @Override // com.google.android.libraries.navigation.internal.abh.fo
    public final fn g(fx fxVar) {
        com.google.android.libraries.navigation.internal.abf.s.k(fxVar, "model");
        return new x(fxVar, this);
    }

    @Override // com.google.android.libraries.navigation.internal.abh.fo
    public final fy h(fz fzVar) {
        return new y(fzVar, this);
    }

    @Override // com.google.android.libraries.navigation.internal.abh.fo
    public final hn i(ho hoVar) {
        com.google.android.libraries.navigation.internal.abf.p.b("Tile Overlays");
        return null;
    }

    final void j(ab abVar) {
        this.a.add(abVar);
        m();
    }

    public final void k() {
        es esVar = this.e;
        if (esVar != null) {
            esVar.k();
        }
    }

    final void l(n nVar) {
        es esVar = this.e;
        es esVar2 = nVar.a;
        if (esVar == esVar2) {
            this.e = null;
            esVar2.b.g(esVar2);
        }
        m();
    }

    public final void m() {
        this.l.invalidate();
    }

    final void n(ab abVar) {
        this.a.remove(abVar);
        m();
    }

    public final boolean o(float f, float f2) {
        int size = this.a.size();
        while (true) {
            size--;
            if (size < 0) {
                return false;
            }
            try {
                ab abVar = (ab) this.a.get(size);
                if (abVar != null && abVar.f(f, f2)) {
                    return true;
                }
            } catch (IndexOutOfBoundsException unused) {
            }
        }
    }

    public final boolean p() {
        return this.c.size() > 1;
    }

    public final boolean q(float f, float f2) {
        if (this.e == null) {
            return false;
        }
        float f3 = this.f;
        if (f < f3 || f > f3 + this.h) {
            return false;
        }
        float f4 = this.g;
        return f2 >= f4 && f2 <= f4 + this.i;
    }
}
