package com.google.android.libraries.geo.mapcore.internal.vector.gl;

import com.google.android.libraries.navigation.internal.oe.ay;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes2.dex */
final class i {
    float i;
    int j;
    int k;
    int l;
    private final g m;
    ay a = new ay();
    final ay b = new ay();
    ay c = new ay();
    final ay e = new ay();
    final ay f = new ay();
    ay h = new ay();
    final ay d = new ay();
    final ay g = new ay();

    public i(g gVar) {
        this.m = gVar;
    }

    final void a() {
        ay.s(this.b, this.a, this.d);
        if (this.m.l) {
            ay ayVar = this.d;
            ayVar.b = m.a(ayVar.b);
        }
        ay.o(this.d, this.e);
        ay ayVar2 = this.e;
        ay.n(ayVar2, ayVar2);
        ay.l(ayVar2, 255.0f, ayVar2);
    }
}
