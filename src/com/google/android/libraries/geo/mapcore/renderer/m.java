package com.google.android.libraries.geo.mapcore.renderer;

import java.util.ArrayList;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes2.dex */
public final class m implements aj {
    private static final fg r = new fg(0, 0, 0);
    public final int b;
    public final int c;
    public final int d;
    public final int e;
    public final int f;
    public final int g;
    public final float h;
    public final r i;
    public final boolean j;
    public final boolean k;
    public ArrayList m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public ArrayList f84n;
    bv a = null;
    public boolean l = false;
    public ArrayList o = new ArrayList();
    public ArrayList p = new ArrayList();
    public com.google.android.libraries.navigation.internal.agg.de q = new com.google.android.libraries.navigation.internal.agg.de();

    public m(int i, int i2, int i3, float f, ArrayList arrayList, ArrayList arrayList2, r rVar, boolean z, boolean z2, dq dqVar) {
        int i4;
        this.b = i;
        this.c = i2;
        this.d = i3;
        this.h = f;
        int i5 = 1073741824 >> i3;
        this.e = i5;
        this.f = (i * i5) - 536870912;
        this.g = -((i5 * (i2 + 1)) - 536870912);
        this.i = rVar;
        this.j = z;
        this.k = z2;
        this.m = arrayList;
        this.f84n = arrayList2;
        int size = arrayList.size();
        int i6 = 0;
        int i7 = 0;
        while (true) {
            i4 = true != z2 ? 3 : 4;
            if (i6 >= size) {
                break;
            }
            i7 += ((com.google.android.libraries.navigation.internal.agg.de) arrayList.get(i6)).b / i4;
            i6++;
        }
        int size2 = arrayList2.size();
        int i8 = 0;
        for (int i9 = 0; i9 < size2; i9++) {
            i8 += ((com.google.android.libraries.navigation.internal.agj.o) arrayList2.get(i9)).b;
        }
        dqVar.c++;
        dqVar.a += (i7 * i4 * 4) + i8 + i8;
    }

    @Override // com.google.android.libraries.geo.mapcore.renderer.aj
    public final void A(bv bvVar) {
        if (o()) {
            return;
        }
        ArrayList arrayList = this.m;
        ArrayList arrayList2 = this.f84n;
        if (arrayList == null || arrayList2 == null) {
            return;
        }
        for (int i = 0; i < arrayList.size(); i++) {
            com.google.android.libraries.navigation.internal.agg.de deVar = (com.google.android.libraries.navigation.internal.agg.de) arrayList.get(i);
            com.google.android.libraries.navigation.internal.agj.o oVar = (com.google.android.libraries.navigation.internal.agj.o) arrayList2.get(i);
            if (!deVar.isEmpty()) {
                this.a = bvVar;
                bw bwVarF = bvVar.f("building");
                this.a.k(bwVarF);
                this.a.L(34962, deVar.a, deVar.b);
                bw bwVarD = this.a.d("building");
                this.a.i(bwVarD);
                this.a.M(oVar.a, oVar.b, 35044);
                this.o.add(bwVarF);
                this.p.add(bwVarD);
                this.q.c(oVar.b);
            }
        }
        this.m = null;
        this.f84n = null;
    }

    @Override // com.google.android.libraries.geo.mapcore.renderer.aj
    public final void C(boolean z) {
        this.l = z;
    }

    @Override // com.google.android.libraries.geo.mapcore.renderer.aj
    public final ae E() {
        return ae.a;
    }

    @Override // com.google.android.libraries.geo.mapcore.renderer.aj
    public final fg F() {
        return r;
    }

    @Override // com.google.android.libraries.geo.mapcore.renderer.aj
    public final void G(aj ajVar, aj ajVar2, u uVar) {
    }

    @Override // com.google.android.libraries.geo.mapcore.renderer.aj
    public final void b(long j) {
        r rVar = this.i;
        if (!rVar.j) {
            rVar.l = 1.0f;
            return;
        }
        float f = (j - rVar.k) / 500.0f;
        rVar.l = f;
        if (f > 1.0f) {
            rVar.l = 1.0f;
        }
    }

    @Override // com.google.android.libraries.geo.mapcore.renderer.aj
    public final ey c(int i) {
        throw null;
    }

    @Override // com.google.android.libraries.geo.mapcore.renderer.aj
    public final void d(boolean z) {
        if (o()) {
            bv bvVar = this.a;
            com.google.android.libraries.navigation.internal.yx.ar.q(bvVar);
            if (!z) {
                ArrayList arrayList = this.o;
                int size = arrayList.size();
                for (int i = 0; i < size; i++) {
                    bvVar.l((bw) arrayList.get(i));
                }
                ArrayList arrayList2 = this.p;
                int size2 = arrayList2.size();
                for (int i2 = 0; i2 < size2; i2++) {
                    bvVar.l((bw) arrayList2.get(i2));
                }
            }
            this.o.clear();
            this.p.clear();
        }
    }

    @Override // com.google.android.libraries.geo.mapcore.renderer.aj
    public final Cdo g() {
        return null;
    }

    @Override // com.google.android.libraries.geo.mapcore.renderer.aj
    public final int h() {
        return this.d;
    }

    @Override // com.google.android.libraries.geo.mapcore.renderer.aj
    public final af i() {
        return cf.BUILDING;
    }

    @Override // com.google.android.libraries.geo.mapcore.renderer.aj
    public final boolean n() {
        return true;
    }

    @Override // com.google.android.libraries.geo.mapcore.renderer.aj
    public final boolean o() {
        return this.a != null;
    }

    @Override // com.google.android.libraries.geo.mapcore.renderer.aj
    public final boolean p() {
        return true;
    }

    @Override // com.google.android.libraries.geo.mapcore.renderer.aj
    public final dy y() {
        return dy.BUILDING_PASS;
    }

    @Override // com.google.android.libraries.geo.mapcore.renderer.aj
    public final void z() {
    }
}
