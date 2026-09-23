package com.google.android.libraries.geo.mapcore.renderer;

import androidx.tracing.Trace;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes2.dex */
public class dg implements dx {
    private static final com.google.android.libraries.navigation.internal.zb.j c = com.google.android.libraries.navigation.internal.zb.j.e("com.google.android.libraries.geo.mapcore.renderer.dg");
    public final Comparator a;
    public final eh[] b;
    private final df d;

    public dg(int i, df dfVar, Comparator comparator) {
        this.d = dfVar;
        this.a = comparator;
        if (i <= 0) {
            ((com.google.android.libraries.navigation.internal.zb.h) c.d(com.google.android.libraries.navigation.internal.nl.a.a).F(1363)).q("Invalid numBins: %d", 0);
            this.b = new eh[0];
        } else {
            this.b = new eh[i];
            for (int i2 = 0; i2 < i; i2++) {
                this.b[i2] = new eh(comparator);
            }
        }
    }

    private final eh h(aj ajVar) {
        eh[] ehVarArr = this.b;
        if (ehVarArr.length == 1) {
            return ehVarArr[0];
        }
        int iA = this.d.a(ajVar);
        eh[] ehVarArr2 = this.b;
        if (iA < ehVarArr2.length && iA >= 0) {
            return ehVarArr2[iA];
        }
        ((com.google.android.libraries.navigation.internal.zb.h) c.d(com.google.android.libraries.navigation.internal.nl.a.a).F(1362)).t("layerIndex is: %d , while numBins is: %d", iA, this.b.length);
        return this.b[0];
    }

    @Override // com.google.android.libraries.geo.mapcore.renderer.dx
    public final List a(bv bvVar) {
        ArrayList arrayList = new ArrayList();
        int i = 0;
        while (true) {
            eh[] ehVarArr = this.b;
            if (i >= ehVarArr.length) {
                return arrayList;
            }
            arrayList.addAll(ehVarArr[i].a(bvVar));
            i++;
        }
    }

    @Override // com.google.android.libraries.geo.mapcore.renderer.dx
    public final void b(aj ajVar) {
        h(ajVar).b(ajVar);
    }

    public final void c(u uVar) {
        int i = 0;
        while (true) {
            eh[] ehVarArr = this.b;
            if (i >= ehVarArr.length) {
                String[] strArr = com.google.android.libraries.navigation.internal.nw.e.a;
                Trace.setCounter("drawnSortedRenderBins", ehVarArr.length);
                return;
            } else {
                ehVarArr[i].c(uVar);
                i++;
            }
        }
    }

    @Override // com.google.android.libraries.geo.mapcore.renderer.dx
    public final void d(aj ajVar) {
        if (this.a != null) {
            h(ajVar).h();
        }
    }

    @Override // com.google.android.libraries.geo.mapcore.renderer.dx
    public final void e() {
        int i = 0;
        while (true) {
            eh[] ehVarArr = this.b;
            if (i >= ehVarArr.length) {
                return;
            }
            ehVarArr[i].e();
            i++;
        }
    }

    @Override // com.google.android.libraries.geo.mapcore.renderer.dx
    public final void f(long j) {
        for (eh ehVar : this.b) {
            ehVar.f(j);
        }
    }

    @Override // com.google.android.libraries.geo.mapcore.renderer.dx
    public final boolean g(aj ajVar) {
        return h(ajVar).g(ajVar);
    }
}
