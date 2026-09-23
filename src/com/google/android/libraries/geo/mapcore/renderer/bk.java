package com.google.android.libraries.geo.mapcore.renderer;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes2.dex */
final class bk {
    public ag a;
    public boolean b;
    public boolean c;
    public boolean d;
    public du e;
    public ds f;
    public dt g;
    public dv h;

    public final void a() {
        ag agVar = this.a;
        du duVar = this.e;
        dv dvVar = this.h;
        if (agVar == null || duVar == null || dvVar == null || dvVar == agVar.g()) {
            return;
        }
        agVar.j(duVar, agVar.g(), agVar.g(), agVar.d());
        agVar.m(duVar, dvVar);
        this.h = null;
    }

    public final ds b(int i, int i2, int i3) {
        ag agVar = this.a;
        com.google.android.libraries.navigation.internal.yx.ar.q(agVar);
        ds[] dsVarArr = new ds[1];
        int[] iArr = new int[1];
        du duVar = this.e;
        com.google.android.libraries.navigation.internal.yx.ar.q(duVar);
        agVar.l(duVar, new int[]{12324, i, 12323, i2, 12322, i3, 12321, 0, 12325, 16, 12326, 8, 12352, 4, 12344}, dsVarArr, iArr);
        if (iArr[0] > 0) {
            return dsVarArr[0];
        }
        return null;
    }

    public final dt c(ag agVar, ds dsVar) {
        du duVar = this.e;
        com.google.android.libraries.navigation.internal.yx.ar.q(duVar);
        dt dtVarB = agVar.b(duVar, dsVar, agVar.d(), new int[]{12440, 2, 12344});
        this.g = dtVarB;
        return dtVarB;
    }
}
