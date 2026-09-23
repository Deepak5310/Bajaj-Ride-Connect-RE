package com.google.android.libraries.navigation.internal.adh;

import com.google.android.libraries.navigation.internal.adg.ev;
import com.google.android.libraries.navigation.internal.ael.ar;
import com.google.android.libraries.navigation.internal.ael.cc;
import com.google.android.libraries.navigation.internal.ael.dg;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class c extends k {
    public final ar a;
    public final d b = new d(1);
    public final f c = new f();
    private final f e = new f();
    private final g f = new g();
    public e d = null;

    public c(ar arVar) {
        this.a = arVar;
    }

    public final int a() {
        return this.c.b;
    }

    @Override // com.google.android.libraries.navigation.internal.adh.k
    public final void b() {
        super.b();
        this.b.c();
        this.c.c();
        this.e.c();
        e eVar = this.d;
        if (eVar != null) {
            eVar.a();
        }
    }

    @Override // com.google.android.libraries.navigation.internal.adh.k
    protected final void c(int i, int i2, int i3) {
        if (i == 1) {
            this.c.f(i2, i3);
        } else if (i == 2) {
            this.e.f(i2, i3);
        } else {
            if (i != 4) {
                return;
            }
            this.b.d(0, i2, i3);
        }
    }

    public final int d() {
        return this.e.b;
    }

    public final long e(int i) {
        return p(this.c.b(i), this.c.a(i));
    }

    public final ev f(int i) throws cc {
        return (ev) ((dg) ev.a.aH(7, null)).j(this.t, this.e.b(i), this.e.a(i), this.a);
    }

    @Override // com.google.android.libraries.navigation.internal.adh.k
    protected final boolean q(int i) {
        return i == 3;
    }
}
