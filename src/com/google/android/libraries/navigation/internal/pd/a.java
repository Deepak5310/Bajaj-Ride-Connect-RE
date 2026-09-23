package com.google.android.libraries.navigation.internal.pd;

import com.google.android.libraries.navigation.internal.oe.r;
import com.google.android.libraries.navigation.internal.oe.x;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class a {
    public r a;
    public x b;
    public float c;
    public float d;
    public float e;
    public e f;

    public a() {
        this.f = e.a;
    }

    public a(d dVar) {
        this.f = e.a;
        this.a = dVar.i;
        this.b = dVar.j;
        this.c = dVar.k;
        this.d = dVar.l;
        this.e = dVar.m;
        this.f = dVar.f515n;
    }

    public final d a() {
        return new d(this.a, this.c, this.d, this.e, this.f);
    }

    public final void b(d dVar) {
        this.a = dVar.i;
        this.b = dVar.j;
        this.c = dVar.k;
        this.d = dVar.l;
        this.e = dVar.m;
        this.f = dVar.f515n;
    }

    public final void d(r rVar) {
        this.a = rVar;
        this.b = com.google.android.libraries.navigation.internal.oe.h.c(rVar);
    }

    public final void e(x xVar) {
        this.b = xVar;
        this.a = com.google.android.libraries.navigation.internal.oe.h.a(xVar);
    }

    public final void c(int i, Object obj) {
        if (obj != null) {
            int i2 = i - 1;
            if (i == 0) {
                throw null;
            }
            if (i2 == 0) {
                e((x) obj);
                return;
            }
            if (i2 == 1) {
                this.c = ((Float) obj).floatValue();
                return;
            }
            if (i2 == 2) {
                this.d = ((Float) obj).floatValue();
            } else if (i2 == 3) {
                this.e = ((Float) obj).floatValue();
            } else {
                if (i2 != 4) {
                    throw new IllegalArgumentException("Invalid camera position property ".concat(b.a(i)));
                }
                this.f = (e) obj;
            }
        }
    }
}
