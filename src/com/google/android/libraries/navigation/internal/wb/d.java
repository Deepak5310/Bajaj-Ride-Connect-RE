package com.google.android.libraries.navigation.internal.wb;

import com.google.android.libraries.navigation.internal.yx.ar;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class d {
    public final com.google.android.libraries.geo.mapcore.internal.ui.b a;
    public final com.google.android.libraries.navigation.internal.ub.f b;
    public final com.google.android.libraries.navigation.internal.nt.m c;
    public final com.google.android.libraries.navigation.internal.nt.m d;
    public final Executor e;
    public final com.google.android.libraries.navigation.internal.nt.t f = new b(this);
    public final com.google.android.libraries.navigation.internal.nt.t g = new c(this);
    public boolean h;

    public d(com.google.android.libraries.geo.mapcore.internal.ui.b bVar, com.google.android.libraries.navigation.internal.ub.f fVar, com.google.android.libraries.navigation.internal.nt.m mVar, com.google.android.libraries.navigation.internal.nt.m mVar2, Executor executor) {
        ar.q(bVar);
        this.a = bVar;
        this.b = fVar;
        this.c = mVar;
        this.d = mVar2;
        this.e = executor;
    }

    public final void a() {
        this.a.setNeedleDrawableId(com.google.android.libraries.navigation.internal.dw.c.h);
        this.a.setNorthDrawableId(this.h ? com.google.android.libraries.navigation.internal.dw.c.j : com.google.android.libraries.navigation.internal.dw.c.i);
        this.a.setBackgroundDrawableId(this.h ? com.google.android.libraries.navigation.internal.du.c.B : com.google.android.libraries.navigation.internal.du.c.C);
    }
}
