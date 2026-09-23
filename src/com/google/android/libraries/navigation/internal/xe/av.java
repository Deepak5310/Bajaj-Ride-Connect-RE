package com.google.android.libraries.navigation.internal.xe;

import android.location.Location;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class av implements com.google.android.libraries.navigation.internal.abh.fg {
    private final as a;

    public av(as asVar) {
        this.a = asVar;
    }

    @Override // com.google.android.libraries.navigation.internal.abh.fg
    public final void a() {
        com.google.android.libraries.navigation.internal.nj.i.b();
        as asVar = this.a;
        if (asVar.z) {
            if (asVar.A) {
                asVar.l();
            } else {
                asVar.j();
            }
            asVar.B = false;
        }
    }

    @Override // com.google.android.libraries.navigation.internal.abh.fg
    public final void b() {
        this.a.k();
    }

    @Override // com.google.android.libraries.navigation.internal.abh.fg
    public final void c(boolean z) {
        this.a.o(z);
    }

    @Override // com.google.android.libraries.navigation.internal.abh.fg
    public final void d() {
    }

    @Override // com.google.android.libraries.navigation.internal.abh.fg
    public final void e(boolean z) {
        as asVar = this.a;
        if (asVar.C == z) {
            return;
        }
        com.google.android.libraries.navigation.internal.pi.s sVar = asVar.x;
        if (z) {
            sVar.a(asVar, asVar.y);
        } else {
            sVar.k(asVar);
        }
        asVar.C = z;
    }

    @Override // com.google.android.libraries.navigation.internal.abh.fg
    public final void f(boolean z) {
        this.a.n(z);
    }

    @Override // com.google.android.libraries.navigation.internal.abh.fg
    public final void g(com.google.android.libraries.navigation.internal.abh.fe feVar) {
        this.a.D = feVar;
    }

    @Override // com.google.android.libraries.navigation.internal.abh.fg
    public final void h(Location location) {
    }

    @Override // com.google.android.libraries.navigation.internal.abh.fg
    public final boolean i() {
        return this.a.z;
    }
}
