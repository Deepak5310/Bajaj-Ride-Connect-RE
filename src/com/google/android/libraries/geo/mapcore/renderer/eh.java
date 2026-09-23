package com.google.android.libraries.geo.mapcore.renderer;

import androidx.tracing.Trace;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes2.dex */
public final class eh implements dx {
    public final ArrayList a;
    private final Comparator b;
    private boolean c;

    public eh(String str) {
        this((Comparator) null);
    }

    @Override // com.google.android.libraries.geo.mapcore.renderer.dx
    public final List a(bv bvVar) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = this.a;
        int size = arrayList2.size();
        for (int i = 0; i < size; i++) {
            aj ajVar = (aj) arrayList2.get(i);
            if (ajVar.n()) {
                ajVar.A(bvVar);
            } else {
                arrayList.add(ajVar);
            }
        }
        int size2 = arrayList.size();
        for (int i2 = 0; i2 < size2; i2++) {
            this.a.remove((aj) arrayList.get(i2));
        }
        return arrayList;
    }

    @Override // com.google.android.libraries.geo.mapcore.renderer.dx
    public final void b(aj ajVar) {
        this.a.add(ajVar);
        h();
    }

    public final void c(u uVar) {
        int i = 0;
        if (this.b != null) {
            synchronized (this) {
                if (this.c) {
                    for (int i2 = 0; i2 < this.a.size(); i2++) {
                        ((aj) this.a.get(i2)).z();
                    }
                    Collections.sort(this.a, this.b);
                    this.c = false;
                }
            }
        }
        int size = this.a.size();
        int i3 = 0;
        while (i < size) {
            aj ajVar = i == 0 ? null : (aj) this.a.get(i - 1);
            int i4 = i + 1;
            aj ajVar2 = (aj) this.a.get(i);
            aj ajVar3 = i != this.a.size() + (-1) ? (aj) this.a.get(i4) : null;
            if (ajVar2.p()) {
                ajVar2.G(ajVar, ajVar3, uVar);
                i3++;
            }
            i = i4;
        }
        String[] strArr = com.google.android.libraries.navigation.internal.nw.e.a;
        Trace.setCounter("drawnEntities", i3);
    }

    @Override // com.google.android.libraries.geo.mapcore.renderer.dx
    public final void d(aj ajVar) {
        h();
    }

    @Override // com.google.android.libraries.geo.mapcore.renderer.dx
    public final void e() {
        ArrayList arrayList = this.a;
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            ((aj) arrayList.get(i)).d(true);
        }
    }

    @Override // com.google.android.libraries.geo.mapcore.renderer.dx
    public final void f(long j) {
        int size = this.a.size();
        for (int i = 0; i < size; i++) {
            ((aj) this.a.get(i)).b(j);
        }
    }

    @Override // com.google.android.libraries.geo.mapcore.renderer.dx
    public final boolean g(aj ajVar) {
        return this.a.remove(ajVar);
    }

    public final void h() {
        if (this.b != null) {
            synchronized (this) {
                this.c = true;
            }
        }
    }

    public final String toString() {
        return "SortedRenderBin";
    }

    public eh(Comparator comparator) {
        this.a = new ArrayList();
        this.c = false;
        this.b = comparator;
    }
}
