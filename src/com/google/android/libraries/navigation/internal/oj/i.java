package com.google.android.libraries.navigation.internal.oj;

import com.google.android.libraries.navigation.internal.ol.ai;
import com.google.android.libraries.navigation.internal.ol.o;
import com.google.android.libraries.navigation.internal.ol.u;
import com.google.android.libraries.navigation.internal.ot.q;
import com.google.android.libraries.navigation.internal.yx.ar;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class i implements q {
    private final u a;
    private final ai b;

    public i(o oVar, ai aiVar) {
        ar.f(oVar instanceof u, "PointLabelAdapter requires a ClientPointLabel, but found: %s", oVar.getClass());
        this.a = (u) oVar;
        this.b = aiVar;
    }

    @Override // com.google.android.libraries.navigation.internal.ot.q
    public final com.google.android.libraries.navigation.internal.or.c a() {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.android.libraries.navigation.internal.ot.q
    public final void b() {
        this.b.i(this.a);
    }

    @Override // com.google.android.libraries.navigation.internal.ot.q
    public final void c() {
        this.b.g(this.a);
    }

    @Override // com.google.android.libraries.navigation.internal.ot.q
    public final void d() {
        this.b.m(this.a);
    }
}
