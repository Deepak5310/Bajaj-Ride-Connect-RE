package com.google.android.libraries.navigation.internal.px;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class aw {
    public float b;
    public float c;
    public boolean d;
    public float e;
    public float f;
    public long g;
    public long h;
    public final com.google.android.libraries.geo.mapcore.internal.model.c a = new com.google.android.libraries.geo.mapcore.internal.model.c(new com.google.android.libraries.navigation.internal.oe.x(), 2, 0.0f);
    public int i = 1;

    public final void a(ax axVar) {
        synchronized (axVar.q) {
            com.google.android.libraries.geo.mapcore.internal.model.c cVar = this.a;
            com.google.android.libraries.geo.mapcore.internal.model.c cVar2 = axVar.u;
            cVar.a.W(cVar2.a);
            cVar.c = cVar2.c;
            cVar.b = cVar2.b;
            this.b = axVar.D;
            this.c = axVar.E;
            this.d = axVar.w;
            this.e = axVar.x;
            this.f = axVar.y;
            this.i = axVar.o;
            this.g = axVar.k;
            this.h = axVar.i;
        }
    }
}
