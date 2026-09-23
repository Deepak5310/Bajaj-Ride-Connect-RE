package com.google.android.libraries.navigation.internal.abl;

import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;
import com.google.android.libraries.navigation.internal.abh.er;
import com.google.android.libraries.navigation.internal.abh.es;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class n implements er {
    public final es a;
    public final Paint b = new Paint();
    public Point c = new Point(-2, -2);
    public Point d = new Point(-1, -1);
    private final s e;

    public n(es esVar, s sVar) {
        this.a = esVar;
        this.e = sVar;
    }

    public final float a() {
        return this.a.c();
    }

    @Override // com.google.android.libraries.navigation.internal.abh.er
    public final Rect c() {
        return new Rect(this.c.x, this.c.y, this.d.x, this.d.y);
    }

    @Override // com.google.android.libraries.navigation.internal.abh.er
    public final void d() {
        s sVar = this.e;
        if (com.google.android.libraries.navigation.internal.afu.d.g()) {
            sVar.b.add(this);
            sVar.m();
        } else {
            sVar.b.add(this);
            sVar.m();
        }
    }

    @Override // com.google.android.libraries.navigation.internal.abh.er
    public final void e() {
    }

    public final boolean equals(Object obj) {
        if (obj instanceof n) {
            return this.a.equals(((n) obj).a);
        }
        return false;
    }

    @Override // com.google.android.libraries.navigation.internal.abh.er
    public final void f() {
    }

    @Override // com.google.android.libraries.navigation.internal.abh.er
    public final void g() {
        this.e.l(this);
    }

    public final int hashCode() {
        return this.a.hashCode();
    }

    @Override // com.google.android.libraries.navigation.internal.abh.er
    public final void i() {
        s sVar = this.e;
        sVar.b.remove(this);
        if (sVar.e == this.a) {
            sVar.e = null;
        }
        sVar.m();
    }

    @Override // com.google.android.libraries.navigation.internal.abh.er
    public final void j(boolean z) {
        es esVar = this.a;
        if (esVar.F()) {
            s sVar = this.e;
            es esVar2 = sVar.e;
            if (esVar2 != null && esVar != esVar2) {
                sVar.k();
            }
            sVar.e = this.a;
            sVar.m();
        }
    }

    @Override // com.google.android.libraries.navigation.internal.abh.er
    public final boolean k() {
        return this.e.e == this.a;
    }

    @Override // com.google.android.libraries.navigation.internal.abh.er
    public final void h(int i) {
        if (i == 3) {
            com.google.android.libraries.navigation.internal.abf.p.e("Marker.setFlat()");
            return;
        }
        if (i == 4) {
            com.google.android.libraries.navigation.internal.abf.p.e("Marker.setRotation()");
            return;
        }
        if (i == 5) {
            com.google.android.libraries.navigation.internal.abf.p.e("Marker.setDraggable()");
        } else {
            if (i != 6) {
                this.e.m();
                return;
            }
            if (!this.a.Z()) {
                this.e.l(this);
            }
            this.e.m();
        }
    }
}
